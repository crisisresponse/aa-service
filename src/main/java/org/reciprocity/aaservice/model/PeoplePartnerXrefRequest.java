package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class PeoplePartnerXrefRequest {

    private UUID personKey;
    private Integer orgKey;
    private String primaryOrg;
}
