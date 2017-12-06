package com.example.demo.quartz_task_test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TaskOne extends BaseTask {

    @Value("${task1-cron}")
    private String cron;
    @Value("${task1-group}")
    private String taskGroup;
    @Value("${task1-name}")
    private String taskName;

    @Override
    public String getTaskGroup() {
        return taskGroup;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String getCron() {
        return cron;
    }

    @Override
    public void job() {
        System.out.println("Hello world, i'm the TaskOne !!!---" + cron);
    }
}
