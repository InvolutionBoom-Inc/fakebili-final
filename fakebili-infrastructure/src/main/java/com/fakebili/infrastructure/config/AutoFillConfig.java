package com.fakebili.infrastructure.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author lgz
 * @version 0.1.0 2022/11/24 18:11:12
 * @since 0.1.0
 */
@Component
public class AutoFillConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", Timestamp.from(Instant.now()), metaObject);
        setFieldValByName("updateTime", Timestamp.from(Instant.now()), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", Timestamp.from(Instant.now()), metaObject);
    }
}
