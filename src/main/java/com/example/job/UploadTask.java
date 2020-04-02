package com.example.job;

import lombok.SneakyThrows;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@DisallowConcurrentExecution
public class UploadTask extends QuartzJobBean {


    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(Thread.currentThread().getName()+"-------任务执行开始------------"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new Date()));
    }

}
