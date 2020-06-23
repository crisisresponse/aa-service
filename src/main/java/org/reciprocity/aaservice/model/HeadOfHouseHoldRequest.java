package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class HeadOfHouseHoldRequest {

    private UUID headOfHouseholdID;
    private HeadHhMember headHhMember;
}
