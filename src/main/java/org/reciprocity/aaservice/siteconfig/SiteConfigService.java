package org.reciprocity.aaservice.siteconfig;

import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.model.ProvidedServiceRequest;

import java.util.List;

public interface SiteConfigService {

    List<ProvidedService> retrieveAllProvidedServices();
    void saveNewProvidedService(ProvidedServiceRequest request);
    void deleteProvidedService(Long id);
}
