package com.quartzTest;

import com.quartzTest.job.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.quartz.CronScheduleBuilder.*;

/**
 *
 * Created by xudong on 2018/8/20.
 */
public class CronTriggerExample {
    private static final Logger logger = LoggerFactory.getLogger(CronTriggerExample.class);
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job1","group1")
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .withSchedule(cronSchedule("0/20 * * * * ?"))
                .build();

        scheduler.scheduleJob(job,trigger);

        JobDetail job2 = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job2","group1")
                .build();

        CronTrigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("trigger2","group1")
                .withSchedule(cronSchedule("15 0/2 * * * ?"))
                .build();

        scheduler.scheduleJob(job2,trigger2);

        scheduler.start();
        Thread.sleep(300L*1000L);
        scheduler.shutdown();
    }

}
