package org.reciprocity.aaservice.siteconfig.providedservice;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.repository.siteconfig.Services;

@Mapper
public abstract class ProvidedServicesMapper {

    public static ProvidedServicesMapper SITE_CONFIG_MAPPER = Mappers.getMapper(ProvidedServicesMapper.class);

    public Services providedServicesMapToEntity(ProvidedService providedService) {
        Services services = new Services();

        if(providedService.getId() != null) {
            services.setServiceKey(providedService.getId());
        }
        services.setCategory(providedService.getCategory());
        services.setDescription(providedService.getDescription());
        services.setName(providedService.getName());

        return services;
    };
    public abstract ProvidedService availServiceMapToReturnProvidedService(Services service);
}
