package com.health.check.framework.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.health.check.framework.base.MarkEntity;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Mybatis缺省字段填充
 *
 * @author xiao.xl 2022/3/10 9:33
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
	
	@Override
	public void insertFill(MetaObject metaObject) {
		if (metaObject.getOriginalObject() instanceof MarkEntity) {
			Date now = new Date();
			this.strictInsertFill(metaObject, "createTime", Date.class, now);
			if (UserContextHolder.currentUser() != null) {
				this.strictInsertFill(metaObject, "creater", String.class, UserContextHolder.currentUser().getName());
				this.strictInsertFill(metaObject, "updater", String.class, UserContextHolder.currentUser().getName());
			}
			this.strictInsertFill(metaObject, "updateTime", Date.class, now);
		}
	}
	
	@Override
	public void updateFill(MetaObject metaObject) {
		if (metaObject.getOriginalObject() instanceof MarkEntity) {
			this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
			if (UserContextHolder.currentUser() != null) {
				this.strictInsertFill(metaObject, "updater", String.class, UserContextHolder.currentUser().getName());
			}
		}
	}
	
}
