package de.structuremade.ms.activitydeleter.database.repo;

import de.structuremade.ms.activitydeleter.database.entitie.Activities;
import de.structuremade.ms.activitydeleter.database.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
