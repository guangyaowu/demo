package com.example.app1.task;

import com.example.common.BaseTask;
import com.example.common.QuartzTask;
import org.springframework.stereotype.Component;

@Component
@QuartzTask(taskGroup = "测试任务组", taskName = "任务2", cron = "*/15 * * * * *")
public class TaskTwo extends BaseTask {

    @Override
    public void beforeJob() {

    }

    @Override
    public void afterJob() {

    }

    @Override
    protected void doJob() {
        System.out.println("I AM -  任务222222222");
    }
}
