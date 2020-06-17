package org.reciprocity.aaservice.siteconfig;

import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.model.ProvidedServiceRequest;
import org.reciprocity.aaservice.repository.AvailableService;
import org.reciprocity.aaservice.repository.ServiceConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.reciprocity.aaservice.siteconfig.SiteConfigMapper.SITE_CONFIG_MAPPER;

@Service
public class SiteConfigServiceImpl implements SiteConfigService {

    private ServiceConfigRepository serviceConfigRepository;

    @Autowired
    private SiteConfigServiceImpl(ServiceConfigRepository serviceConfigRepository) {
        this.serviceConfigRepository = serviceConfigRepository;
    }


    @Override
    public List<ProvidedService> retrieveAllProvidedServices() {
        List<AvailableService> results =  serviceConfigRepository.findAll();
        return results.stream()
                .map(availableService ->
                        SITE_CONFIG_MAPPER.availServiceMapToReturnProvidedService(availableService))
                .collect(Collectors.toList());
    }

    @Override
    public void saveNewProvidedService(ProvidedServiceRequest request) {
        List<AvailableService> serviceEntities = request.getProvidedService()
                .stream()
                .map(providedService -> SITE_CONFIG_MAPPER.providedServicesMapToEntity(providedService))
                .collect(Collectors.toList());

         serviceConfigRepository.saveAll(serviceEntities);
    }

    @Override
    public void deleteProvidedService(Long id) {
        serviceConfigRepository.deleteById(id);
    }
}
