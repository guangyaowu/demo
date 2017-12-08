package com.example.app1.task;

import com.example.common.QuartzTask;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
@QuartzTask(taskGroup = "测试任务组", taskName = "任务2", cron = "*/15 * * * * ?")
public class TaskTwo implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("我是任务---22222");
    }
}
