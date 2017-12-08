package com.example.app1.task;

import com.example.common.BaseTask;
import com.example.common.QuartzTask;
import org.springframework.stereotype.Component;

@Component
@QuartzTask(taskGroup = "测试任务组", taskName = "任务1", cron = "*/5 * * * * *")
public class TaskOne extends BaseTask {


    @Override
    public void beforeJob() {

    }

    @Override
    public void afterJob() {

    }

    @Override
    protected void doJob() {
        System.out.println("I AM -  任务1");
    }
}
