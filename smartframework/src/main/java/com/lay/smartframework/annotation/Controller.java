package com.lay.smartframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 控制器注解
 * @Author: lay
 * @Date: Created in 16:38 2019/1/25
 * @Modified By:IntelliJ IDEA
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
