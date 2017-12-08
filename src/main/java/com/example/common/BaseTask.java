package com.example.common;


import java.util.LinkedHashSet;
import java.util.Set;

public abstract class BaseTask {


    static Set<String> taskClassNames = new LinkedHashSet<>();

    static {
        taskClassNames.add("com.example.app1.task.TaskOne");
        taskClassNames.add("com.example.app1.task.TaskTwo");
    }


    public abstract void beforeJob();

    public abstract void afterJob();

    protected abstract void doJob();

    public void exe() {
        beforeJob();
        doJob();
        afterJob();
    }
}
