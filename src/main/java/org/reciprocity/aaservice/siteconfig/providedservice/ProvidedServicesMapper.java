package org.reciprocity.aaservice.siteconfig.providedservice;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.repository.siteconfig.ServiceEntity;

@Mapper
public abstract class ProvidedServicesMapper {

    public static ProvidedServicesMapper SITE_CONFIG_MAPPER = Mappers.getMapper(ProvidedServicesMapper.class);

    public ServiceEntity providedServicesMapToEntity(ProvidedService providedService) {
        ServiceEntity serviceEntity = new ServiceEntity();

        if(providedService.getId() != null) {
            serviceEntity.setServiceKey(providedService.getId());
        }
        serviceEntity.setCategory(providedService.getCategory());
        serviceEntity.setDescription(providedService.getDescription());
        serviceEntity.setName(providedService.getName());

        return serviceEntity;
    };
    public abstract ProvidedService availServiceMapToReturnProvidedService(ServiceEntity service);
}
