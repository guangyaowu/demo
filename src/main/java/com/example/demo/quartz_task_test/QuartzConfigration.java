package com.example.demo.quartz_task_test;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@PropertySource({"classpath:quartz.properties"})
@Configuration
public class QuartzConfigration {

    private final String JOB_METHOD_NAME = "job";

    @Value("${isOpen}")
    private int isOpen;

    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(TaskOne task) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(false);
        jobDetail.setName(task.getTaskName());
        jobDetail.setGroup(task.getTaskGroup());
        jobDetail.setTargetObject(task);
        jobDetail.setTargetMethod(JOB_METHOD_NAME);
        return jobDetail;
    }

    @Bean(name = "trigger")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
        BaseTask task = (BaseTask) jobDetail.getTargetObject();

        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(jobDetail.getObject());
        if (isOpen == 0) {
            tigger.setCronExpression("0 0 0 10 10 ? 2067");
        } else {
            tigger.setCronExpression(task.getCron());
        }
        tigger.setName(task.getTaskGroup() + "-" + task.getTaskName() + "-tigger");
        return tigger;

    }

    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger cronJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setOverwriteExistingJobs(true);
        bean.setStartupDelay(1);
        bean.setTriggers(cronJobTrigger);
        return bean;
    }
}
