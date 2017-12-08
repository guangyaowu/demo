package com.example.common;

import com.example.app1.controller.UserController;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;


@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${quartz.task.open}")
    private int taskSwitch;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        if (1 == taskSwitch) {
            scanAndCreateTask();
        } else {
            logger.info("定时任务关闭");
        }
    }

    private void scanAndCreateTask() {
        logger.info("定时任务开启【创建定时任务】");
        BaseTask.taskClassNames.forEach((String taskClassName) -> {
            try {
                QuartzTask quartzTask = Class.forName(taskClassName).getAnnotation(QuartzTask.class);
                //jobDetail
               /* MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
                jobDetail.setConcurrent(false);
                jobDetail.setName(task.getTaskName());
                jobDetail.setGroup(task.getTaskGroup());
                jobDetail.setTargetObject(task);
                jobDetail.setTargetMethod(JOB_METHOD_NAME);
                BaseTask task = (BaseTask) jobDetail.getTargetObject();
                //tigger
                CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
                tigger.setJobDetail(jobDetail.getObject());
                tigger.setName(task.getTaskGroup() + "-" + task.getTaskName() + "-tigger");
                //Scheduler
                SchedulerFactoryBean bean = new SchedulerFactoryBean();
                bean.setOverwriteExistingJobs(true);
                bean.setStartupDelay(1);
                Trigger cronJobTrigger;
                bean.setTriggers(cronJobTrigger);*/
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}