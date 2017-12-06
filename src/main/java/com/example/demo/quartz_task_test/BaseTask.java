package com.example.demo.quartz_task_test;

import org.springframework.context.annotation.PropertySource;

@PropertySource({"classpath:quartz.properties"})
public abstract class BaseTask {

    public abstract String getTaskGroup();

    public abstract String getTaskName();

    public abstract String getCron();

    public abstract void job();
}
