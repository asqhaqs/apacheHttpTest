package com.quartzTest.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by xudong on 2018/8/20.
 */
public class SimpleJob implements Job{
    private static final Logger logger = LoggerFactory.getLogger(SimpleJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        logger.info("SimpleJob says: " + jobKey + " executed at " + new Date());
    }
}
