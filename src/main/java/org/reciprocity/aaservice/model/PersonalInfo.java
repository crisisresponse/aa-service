package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class PersonalInfo {

    private LocalDate birthdate;

    //enum
    private String gender;

    private String employmentStatus;

    private String transportAvailability;

    private List<String> languageSpoken;

    private int householdSize;

    private String qualifications;

    private String fieldOfWork;
}
