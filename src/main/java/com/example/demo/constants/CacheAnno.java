package com.example.demo.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/10/10 15:30
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheAnno {
    /**
     * 缓存ID
     */
    String key() default "";
}
