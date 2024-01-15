package com.health.check.framework.config;

import cn.hutool.core.date.DatePattern;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.health.check.framework.serializer.fastjson.filter.FastJsonValueFilter;
import com.health.check.framework.util.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SpringMVC配置
 *
 * @author xiao.xl 2022/3/12 14:32
 */
@Slf4j
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {


    @Value("${health-check.enableCache:false}")
    private Boolean enableCache;

    @Resource(name = "validator")
    private Validator validator;

    @Override
    public Validator mvcValidator() {
        return validator;
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
//        converters.add(getMappingJackson2HttpMessageConverter());
        converters.add(fastJsonHttpMessageConverter());
//        converters.add(new MappingJackson2XmlHttpMessageConverter());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //swagger
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        if (enableCache) {
            registry.addResourceHandler("/static/cache/**").addResourceLocations("classpath:/static/");
        }
        super.addResourceHandlers(registry);
    }


    /**
     * 转换器配置
     *
     * @author xiao.xl 2022/3/12 14:38
     */
    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置日期格式
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat smt = new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
        objectMapper.setDateFormat(smt);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(this.getSupportedMediaType());
        return mappingJackson2HttpMessageConverter;
    }


    /**
     * 转换器配置
     *
     * @author xiao.xl 2022/3/12 14:38
     */
    private FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setFastJsonConfig(fastjsonConfig());
        converter.setSupportedMediaTypes(getSupportedMediaType());
        return converter;
    }

    /**
     * FastJson配置
     *
     * @author xiao.xl 2022/3/12 14:38
     */
    @Bean
    public FastJsonConfig fastjsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
        fastJsonConfig.setDateFormat(DatePattern.NORM_DATETIME_PATTERN);
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConfig.setSerializeFilters(new FastJsonValueFilter());
        fastJsonConfig.setParseProcess((ExtraProcessor) (object, key, value) -> {
            if (object == null) {
                return;
            }
            Arrays.asList(ReflectionUtils.getFieldsDirectly(object.getClass(), true)).parallelStream().forEach(field -> {
                if (field.getType() == String.class) {
                    String fieldValue = (String) ReflectionUtils.getFieldValue(object, field);
                    if (StringUtils.isBlank(fieldValue)) {
                        ReflectionUtils.setFieldValue(object, field, null);
                    }
                }
            });
        });
        return fastJsonConfig;
    }

    /**
     * MediaType配置
     *
     * @author xiao.xl 2022/3/12 14:37
     */
    private List<MediaType> getSupportedMediaType() {
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        mediaTypes.add(MediaType.IMAGE_JPEG);
        mediaTypes.add(MediaType.TEXT_HTML);
        mediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        return mediaTypes;
    }

}
