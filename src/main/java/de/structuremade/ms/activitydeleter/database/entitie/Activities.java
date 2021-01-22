package de.structuremade.ms.activitydeleter.database.entitie;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activities")
@Getter
@Setter
public class Activities {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String id;

    @Column
    private boolean deleteNextLesson;

    @Column
    private Date validThru;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "user_watched")
    private List<User> users;

}
