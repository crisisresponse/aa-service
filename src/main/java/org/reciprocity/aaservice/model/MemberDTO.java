package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {

    private NameDTO name;
    private AddressDTO address;
    private String email;
    private String phoneNumber;
    //Enum
    private String memberType;
}
