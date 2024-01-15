package com.health.check.framework.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * MarkEntityLogic
 *
 * @author Hoda 2022/5/14 4:19 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MarkEntityLogic<T extends MarkEntityLogic<T>> extends MarkEntity<T>{
    
    /**
     * 是否删除
     */
    @TableLogic
    private Boolean deleted = false;

}
