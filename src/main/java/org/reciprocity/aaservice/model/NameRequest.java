package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class NameRequest {

    private UUID memberKey;
    private String firstName;
    private String lastName;
}
