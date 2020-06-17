package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AdultMember extends  AdditionalHouseMember {

    private String email;
    private String phoneNumber;
}
