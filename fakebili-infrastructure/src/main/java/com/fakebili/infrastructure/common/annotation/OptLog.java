package com.fakebili.infrastructure.common.annotation;

import java.lang.annotation.*;

/**
 * @author lgz
 * @version 0.1.0 2022/12/07 16:12:39
 * @since 0.1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {

    String optType() default "";

    String optModuleType() default "";

    String optDesc() default "";

}

