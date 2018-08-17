package com.quartzTest.job;

import org.quartz.*;

/**
 * the job for scheduler
 * Created by xudong on 2018/8/17.
 */
public class HellowJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobKey key = jobExecutionContext.getJobDetail().getKey();
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloatValue("myFloatValue");
        System.err.println("Instance " + key + " of Dumbjob says: " + jobSays + ", and val is: " + myFloatValue);
        System.out.println("this job is doing...");
    }
}
