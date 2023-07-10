package com.example.demo.annotation;

import com.example.demo.enums.AuthLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//只作用于方法上
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthControl {
    AuthLevel value() default AuthLevel.ALL;
}
