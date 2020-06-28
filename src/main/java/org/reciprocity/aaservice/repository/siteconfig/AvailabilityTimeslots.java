package org.reciprocity.aaservice.repository.siteconfig;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
@Table(name="availability_timeslots")
@Getter @Setter
public class AvailabilityTimeslots {

    @GeneratedValue
    @Id
    @Column(name="timeslot_key")
    private Long timeslotKey;

    //enum
    @Column(name="day_of_week")
    private DayOfWeek dayOfTheWeek;

    @Column (name="timeslot_start")
    private Time timeSlotStartTime;

    @Column (name="timeslot_end")
    private Time timeSlotEndTime;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}

//    CREATE TABLE IF NOT EXISTS ods_owner.availability_timeslots
//        (
//        timeslot_key bigint UNIQUE,
//        day_of_week text CHECK (day_of_week IN ('SUNDAY', 'MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY')),
//        timeslot_start time NOT NULL,
//        timelot_end time NOT NULL,
//        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        PRIMARY KEY (timeslot_key)
//        );
