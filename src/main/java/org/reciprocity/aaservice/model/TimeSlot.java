package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.time.DayOfWeek;

@Getter @Setter
public class TimeSlot {

    private Integer timeslotId;
    private String timeslotType;
    private DayOfWeek dayOfTheWeek;
    private Time timeSlotStartTime;
    private Time timeSlotEndTime;
}