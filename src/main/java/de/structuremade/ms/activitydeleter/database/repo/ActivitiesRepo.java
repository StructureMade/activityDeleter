package de.structuremade.ms.activitydeleter.database.repo;

import de.structuremade.ms.activitydeleter.database.entitie.Activities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActivitiesRepo extends JpaRepository<Activities, String> {
    List<Activities> findAllByValidThru(Date date);
}
