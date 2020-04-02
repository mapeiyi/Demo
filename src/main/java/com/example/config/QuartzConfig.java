package com.example.config;

import com.example.job.PrintTimeJob;
import org.quartz.*;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    /*@Bean
    public JobDetail printTimeJobDetail(){
        return JobBuilder.newJob(PrintTimeJob.class)//PrintTimeJob我们的业务类
                .withIdentity("PrintTimeJob")//可以给JobDetail起一个id
                .usingJobData("msg","Hello Quartz")//每个JobDetail内都有一个Map,包含了关联到这个Job的数据，在Jobl类中可以通过context获取，关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger(){
        CronScheduleBuilder cronScheduleBuilder =  CronScheduleBuilder.cronSchedule("0 * * * * ? ");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail())
                .withIdentity("quartzTaskService")//关联上述的JobDetail
                .withSchedule(cronScheduleBuilder)//给Trigger起个名字
                .build();
    }*/

    @Autowired
    private JobFactory jobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean  = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        //用于quartz集群，QuartzScheduler启动时更新已存在的job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //延长启动
        schedulerFactoryBean.setStartupDelay(1);
        //设置加载的配置文件
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("/quartz.properties"));
        return schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler(){
        return schedulerFactoryBean().getScheduler();
    }
}
