package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProvidedServiceRequest {

    private List<ProvidedService> providedService;
}
