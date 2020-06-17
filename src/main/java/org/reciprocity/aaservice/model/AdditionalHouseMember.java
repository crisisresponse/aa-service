package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class AdditionalHouseMember {

    private HouseholdType type;
    private MemberName additionalMemberName;
    private LocalDate birthDate;
    private String gender;
    private String specificNeeds;
}
