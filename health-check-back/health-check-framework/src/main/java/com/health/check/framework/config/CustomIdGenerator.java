package com.health.check.framework.config;

import cn.hutool.core.lang.Singleton;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.health.check.framework.util.Sequence;
import lombok.extern.slf4j.Slf4j;

/**
 * ID生成策略
 *
 * @author xiao.xl 2022/3/10 10:01
 */
@Slf4j
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Long nextId(Object entity) {
        Sequence sequence = Singleton.get(Sequence.class);
        return sequence.nextId();
    }
}