package org.reciprocity.aaservice.siteconfig.providedservice;

import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.model.ProvidedServiceRequest;
import org.reciprocity.aaservice.repository.siteconfig.ServiceEntity;
import org.reciprocity.aaservice.repository.siteconfig.ServiceConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.reciprocity.aaservice.siteconfig.providedservice.ProvidedServicesMapper.SITE_CONFIG_MAPPER;

@Service
public class ProvidedServicesServiceImpl implements ProvidedServicesService {

    private ServiceConfigRepository serviceConfigRepository;

    @Autowired
    private ProvidedServicesServiceImpl(ServiceConfigRepository serviceConfigRepository) {
        this.serviceConfigRepository = serviceConfigRepository;
    }


    @Override
    public List<ProvidedService> retrieveAllProvidedServices() {
        List<ServiceEntity> results =  serviceConfigRepository.findAll();
        return results.stream()
                .map(availableService ->
                        SITE_CONFIG_MAPPER.availServiceMapToReturnProvidedService(availableService))
                .collect(Collectors.toList());
    }

    @Override
    public ProvidedService retrieveProvidedService(Long id) {
        Optional<ServiceEntity> result =  serviceConfigRepository.findById(id);
        if(result.isPresent()) {
           return SITE_CONFIG_MAPPER.availServiceMapToReturnProvidedService(result.get());
        }
        throw new RuntimeException("Service does not exist");
    }

    @Override
    public void saveNewProvidedService(ProvidedServiceRequest request) {
        List<ServiceEntity> serviceEntities = request.getProvidedService()
                .stream()
                .map(SITE_CONFIG_MAPPER::providedServicesMapToEntity)
                .collect(Collectors.toList());

         serviceConfigRepository.saveAll(serviceEntities);
    }

    @Override
    public void updateProvidedService(ProvidedServiceRequest request) {
        List<ServiceEntity> serviceEntities = request.getProvidedService()
                .stream()
                .map(SITE_CONFIG_MAPPER::providedServicesMapToEntity)
                .collect(Collectors.toList());
        serviceConfigRepository.saveAll(serviceEntities);
    }


    @Override
    public void deleteProvidedService(Long id) {
        serviceConfigRepository.deleteById(id);
    }
}
