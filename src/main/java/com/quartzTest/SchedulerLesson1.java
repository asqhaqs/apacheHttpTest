package com.quartzTest;

import com.quartzTest.job.HellowJob;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import org.quartz.*;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;


/**
 * Created by xudong on 2018/8/17.
 */
public class SchedulerLesson1 {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler sched = schedulerFactory.getScheduler();
        sched.start();

        //define a job and tie it
        JobDetail job = newJob(HellowJob.class)
                .withIdentity("myJob","group1").build();

        //Trigger the job to run now, and then every
        // 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever()).build();

        //tell quartz to schedule the job using our trigger
        sched.scheduleJob(job,trigger);
    }


}
