package com.cdd.cloud;

//@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})  //可以打在字段、方法、类上
//@Retention(RetentionPolicy.RUNTIME)  //运行时生效
//@Documented  //生成文档时包含这个注解
public @interface ExcludeFromComponentScan {

}
