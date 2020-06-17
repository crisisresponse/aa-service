package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProvidedService {

    private Long id;
    private String name;
    private String description;
    private String category;
}
