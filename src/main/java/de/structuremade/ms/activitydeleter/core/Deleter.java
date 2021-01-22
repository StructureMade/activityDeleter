package de.structuremade.ms.activitydeleter.core;

import de.structuremade.ms.activitydeleter.ActivitydeleterApplication;
import de.structuremade.ms.activitydeleter.database.repo.ActivitiesRepo;
import de.structuremade.ms.activitydeleter.database.repo.UserRepo;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

public class Deleter implements Job {

    @Autowired
    ActivitiesRepo activitiesRepo;

    @Autowired
    UserRepo userRepo;

    private final static Logger LOGGER = LoggerFactory.getLogger(Deleter.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext){
        try {
            activitiesRepo.deleteAll(activitiesRepo.findAllByValidThru(Calendar.getInstance().getTime()));
        }catch (Exception e){
            LOGGER.error("Error by executing Job", e.fillInStackTrace());
        }
    }
}
