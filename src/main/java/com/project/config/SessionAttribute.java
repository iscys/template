package com.project.config;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 需要传值我们的session key
 *
 * 	 The name of the session Attribute key to bind to.
 *
 */
public @interface SessionAttribute {
    String value() default "";
}
