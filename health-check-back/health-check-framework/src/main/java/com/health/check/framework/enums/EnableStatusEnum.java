package com.health.check.framework.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.health.check.framework.exception.BusinessException;
import com.health.check.framework.util.Assert;
import com.health.check.framework.util.StringUtils;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 状态枚举
 *
 * @author 2022/4/23 20:13
 */
@Getter
public enum EnableStatusEnum implements IEnum<String> {
    /**
     * 启动
     */
    ENABLE("enable", "启用"),
    /**
     * 禁用
     */
    DISABLE("disable", "禁用");

    @JsonValue
    private String code;

    private String desc;

    EnableStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 是否匹配
     *
     * @param value 值
     * @return true: 匹配
     * @author xiao.xl 2022/4/23 20:13
     */
    public boolean match(String value) {
        return StringUtils.equalsIgnoreCase(value, this.getCode());
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EnableStatusEnum of(String code) {
        Assert.notNull(code, "枚举 EnableStatusEnum.code 不能为 null ");
        return Stream.of(values())
                .filter(x -> x.code.equals(code))
                .findAny()
                .orElseThrow(() -> new BusinessException(code + "not exists"));
    }

    @Override
    public String getValue() {
        return code;
    }
    
}


