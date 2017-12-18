package com.honpe.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * <p>Title: SameUrlData</p>
 * <p>Description:防止表单重复提交注解 </p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SameUrlData {

}
