package com.example.controller;

import com.example.job.UploadTask;
import com.example.job.UploadTaskT;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    @Autowired
    private Scheduler scheduler;

    /**
     * 添加定时化任务
     * @throws SchedulerException
     */
    @GetMapping("/addTask")
    public void index() throws SchedulerException{
        //cron表达式
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //根据name和group获取当前trigger的身份
        TriggerKey triggerKey = TriggerKey.triggerKey("cj","123");
        CronTrigger triggerOld = null;
        System.out.print("111111111111111111111111111111111111"+1);
        try{
            triggerOld = (CronTrigger) scheduler.getTrigger(triggerKey);
        }catch (SchedulerException e){
            e.printStackTrace();
        }
        if(null==triggerOld){
            //将job加入jobDetail中
            JobDetail jobDetail = JobBuilder.newJob(UploadTask.class).withIdentity("cj","123").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("cj","123").withSchedule(cronScheduleBuilder).build();
            //执行任务
            scheduler.scheduleJob(jobDetail,trigger);
        }else{
            System.out.println("当前job已存在--------------------------------------------");
        }
    }


    /**
     * 添加定时化任务2
     * @throws SchedulerException
     */
    @GetMapping("/addTaskT")
    public void indexT()throws SchedulerException{
        //cron表达式
        CronScheduleBuilder cronScheduleBuilderT = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        System.out.print("111111111111111111111111111111111111"+1);
        //根据name和group获取当前trigger的身份
        TriggerKey triggerKey = TriggerKey.triggerKey("cjT","1234");
        CronTrigger triggerOld = null;
        try{
            triggerOld = (CronTrigger) scheduler.getTrigger(triggerKey);
        }catch (SchedulerException e){
            e.printStackTrace();
        }
        if(null==triggerOld){
            JobDetail jobDetailT = JobBuilder.newJob(UploadTaskT.class).withIdentity("cjT","1234").build();
            Trigger triggerT = TriggerBuilder.newTrigger().withIdentity("cjT","1234").withSchedule(cronScheduleBuilderT).build();
            scheduler.scheduleJob(jobDetailT,triggerT);
        }else{
            System.out.println("当前job已存在--------------------------------------------");
        }
    }

    /**
     * 移除任务
     * @throws SchedulerException
     */
    @GetMapping("/removeTaskT")
    public void removeIndexT()throws SchedulerException{
        //cron表达式
        CronScheduleBuilder cronScheduleBuilderT = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        System.out.print("111111111111111111111111111111111111"+1);
        //根据name和group获取当前trigger的身份
        TriggerKey triggerKey = TriggerKey.triggerKey("cjT","1234");
        CronTrigger triggerOld = null;
        try{
            triggerOld = (CronTrigger) scheduler.getTrigger(triggerKey);
        }catch (SchedulerException e){
            e.printStackTrace();
        }
        //停止触发器
        scheduler.pauseTrigger(triggerKey);
        //移除触发器
        scheduler.unscheduleJob(triggerKey);
        //删除任务
        JobKey jobKey = triggerOld.getJobKey();
        scheduler.deleteJob(jobKey);
    }
}
