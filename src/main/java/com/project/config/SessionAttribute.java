package com.project.config;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 需要传值我们的session key 
 */
public @interface SessionAttribute {
    String value() default "";
}
