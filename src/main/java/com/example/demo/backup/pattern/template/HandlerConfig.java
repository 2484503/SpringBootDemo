package com.example.demo.backup.pattern.template;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author lijn
 * @version 1.0
 * @date 2019/8/29 10:15
 */
@Documented // 说明该注解将被包含在javadoc中
@Target(ElementType.TYPE) // 口、类、枚举、注解
@Retention(RetentionPolicy.RUNTIME) // 这个注解是可以通过反射得到注解的，https://www.iteye.com/blog/wisfly-2289443
public @interface HandlerConfig {
    boolean isValid() default true;
}
