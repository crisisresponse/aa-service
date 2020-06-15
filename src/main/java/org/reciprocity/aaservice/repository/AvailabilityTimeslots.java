package org.reciprocity.aaservice.repository;
//import javax.persistence.*;
//import java.sql.Time;
//import java.time.LocalDate;
//
//@Entity
//@Table(name="availability_timeslots")
//public class AvailabilityTimeslots {
//
//    @GeneratedValue
//    @Id
//    private Integer timeslotId;
//
//    //enum
//    @Column(name="day_of_week")
//    private String dayOfTheWeek;
//
//    @Column (name="timeslot_start")
//    private Time timeSlotStartTime;
//
//    @Column (name="timeslot_end")
//    private Time timeSlotEndTime;
//
//    @Column(name="created_date")
//    private LocalDate createdDate;
//
//    @Column(name="modified_date")
//    private LocalDate modifiedDate;
//}
//
////    CREATE TABLE IF NOT EXISTS ods_owner.availability_timeslots
////        (
////        timeslot_key integer UNIQUE,
////        timeslot_type text CHECK (timeslot_type IN ('PER', 'ORG', 'WH')),
////        day_of_week text CHECK (day_of_week IN ('SUNDAY', 'MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY')),
////        timeslot_start time NOT NULL,
////        timelot_end time NOT NULL,
////        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        PRIMARY KEY (timeslot_key),
////
////        CONSTRAINT unique_key_type UNIQUE(timeslot_key, timeslot_type)
////        );
