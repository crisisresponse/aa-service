package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class HeadHhMember {

    private MemberName name;
    private HeadHhAddress address;
    private String email;
    private String phoneNumber;
    //Enum
    private String memberType;
    private PersonalInfo personalInfo;
    private List<AdditionalHouseMember> additionalHouseMembers = new ArrayList<>();
}
