package de.structuremade.ms.activitydeleter;

import de.structuremade.ms.activitydeleter.core.Deleter;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivitydeleterApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(ActivitydeleterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ActivitydeleterApplication.class, args);
        JobDetail jobDetail = JobBuilder.newJob(Deleter.class).build();
        Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 1/1 * ? *")).startNow().build();
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
            System.exit(5);
        }
        try {

            scheduler.start();
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            LOGGER.error(e.fillInStackTrace().getLocalizedMessage());
        }
    }

}
