package com.health.check.framework.validate;

import com.google.common.collect.Lists;
import com.health.check.framework.exception.ValidException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Controller方法基本类型入参注解校验AOP
 *
 * @author xiao.xl 2022/3/12 14:46
 */
@Slf4j
@Aspect
@Component
public class ValidateAspect {

    @Resource
    private LocalValidatorFactoryBean validator;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) || @annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.GetMapping) || @annotation(org.springframework.web.bind.annotation.DeleteMapping) || @annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void validPointcut() {
        log.info("定义切点");
    }

    /**
     * @Title: handle
     * @Description: 执行Controller方法前拦截，校验带注解参数
     * @Author Jason 2019/3/19 10:08 AM
     * @Param: [point]
     * @Return: void
     */
    @Before("validPointcut()")
    public void handle(JoinPoint point) throws BindException {
        Object target = point.getThis();
        // 获得切入方法参数
        Object[] args = point.getArgs();

        // 如果有校验不通过的
        List<ObjectError> validateMsg = Lists.newArrayList();


        // 获得切入的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        ExecutableValidator executableValidator = validator.forExecutables();
        // 方法上的参数，使用validateParameters校验
        Set<ConstraintViolation<Object>> validResult = executableValidator.validateParameters(target, method, args);
        if (!validResult.isEmpty()) {
            List<ObjectError> errorList = validResult.stream().map(o -> new ObjectError(o.getPropertyPath().toString(), o.getMessage())).collect(Collectors.toList());
            validateMsg.addAll(errorList);
        }
        if (!validateMsg.isEmpty()) {
            throw ValidException.paramError(validateMsg);
        }
    }
}
