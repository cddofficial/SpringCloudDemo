package com.cdd.cloud;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})  //可以打在字段、方法、类上
//@Retention(RetentionPolicy.RUNTIME)  //运行时生效
//@Documented  //生成文档时包含这个注解
public @interface ExcludeFromComponentScan {

}
