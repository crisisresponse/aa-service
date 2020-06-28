package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class AdditionalHouseMemberRequest {

    private UUID headOfHouseId;
    private AdditionalHouseMember additionalHouseMember;
}
