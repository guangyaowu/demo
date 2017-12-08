package com.example.common;

import com.example.app1.controller.UserController;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${quartz.task.open}")
    private int taskSwitch;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        if (1 == taskSwitch) {
            logger.info("定时任务开启");
            scanAndCreateTask();
        } else {
            logger.info("定时任务关闭");
        }
    }

    private void scanAndCreateTask() {
        BaseTask.taskClassNames.forEach((String taskClassName) -> {
            String taskGroup = "";
            String taskName = "";
            String cron;
            try {
                Class<? extends Job> clazz = (Class<? extends Job>) Class.forName(taskClassName);
                QuartzTask quartzTask = clazz.getAnnotation(QuartzTask.class);
                taskGroup = quartzTask.taskGroup();
                taskName = quartzTask.taskName();
                cron = quartzTask.cron();
                JobDetail job = JobBuilder
                        .newJob(clazz)
                        .withIdentity(taskName, taskGroup)
                        .build();
                Trigger trigger = TriggerBuilder
                        .newTrigger()
                        .withIdentity(taskName, taskGroup)
                        .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                        .build();
                Scheduler scheduler = new StdSchedulerFactory().getScheduler();
                scheduler.start();
                scheduler.scheduleJob(job, trigger);
                logger.info("定时任务创建成功【" + taskGroup + "】【" + taskName + "】");

            } catch (ClassNotFoundException | SchedulerException e) {
                logger.error("定时任务创建失败【" + taskGroup + "】【" + taskName + "】");
            }

        });
    }
}