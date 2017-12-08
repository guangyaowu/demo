package com.example.common;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QuartzTask {

    String taskGroup();

    String taskName();

    String cron();
}
