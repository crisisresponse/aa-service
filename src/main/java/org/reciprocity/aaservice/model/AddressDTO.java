package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressDTO {

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

}
