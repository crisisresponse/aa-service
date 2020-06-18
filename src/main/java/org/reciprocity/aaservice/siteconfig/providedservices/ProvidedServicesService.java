package org.reciprocity.aaservice.siteconfig.providedservices;

import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.model.ProvidedServiceRequest;

import java.util.List;

public interface ProvidedServicesService {

    List<ProvidedService> retrieveAllProvidedServices();
    ProvidedService retrieveProvidedService(Long id);
    void saveNewProvidedService(ProvidedServiceRequest request);
    void updateProvidedService(ProvidedServiceRequest request);
    void deleteProvidedService(Long id);
}
