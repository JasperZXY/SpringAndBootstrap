package com.jasper.sab.task;

import java.util.Date;

import org.junit.Test;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartz {
    @Test
    public void m() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            
            // InvokeStatJob是实现了org.quartz.Job的类
            JobDetail jobDetail = new JobDetail("jobDetail", "jobDetailGroup", InvokeStatJob.class);
            CronTrigger cronTrigger = new CronTrigger("cronTrigger", "triggerGroup");
            CronExpression cexp = new CronExpression("0/1 * * * * ?");
            cronTrigger.setCronExpression(cexp);
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
            
            Thread.sleep(4000);
            
            scheduler.deleteJob("jobDetail", "jobDetailGroup");
            System.out.println("stop");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("main");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //这个类必须要是public，不然会报异常：org.quartz.SchedulerException: Problem instantiating class
    public static class InvokeStatJob implements Job {
        
        public InvokeStatJob() {}
        
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("execute" + new Date());
        }
    }
}
