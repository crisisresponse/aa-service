package org.reciprocity.aaservice.siteconfig.providedservices;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.repository.siteconfig.AvailableService;

@Mapper
public abstract class ProvidedServicesMapper {

    public static ProvidedServicesMapper SITE_CONFIG_MAPPER = Mappers.getMapper(ProvidedServicesMapper.class);

    public AvailableService providedServicesMapToEntity(ProvidedService providedService) {
        AvailableService availableService = new AvailableService();

        if(providedService.getId() > 0) {
            availableService.setServiceId(providedService.getId());
        }
        availableService.setCategory(providedService.getCategory());
        availableService.setDescription(providedService.getDescription());
        availableService.setName(providedService.getName());

        return availableService;
    };
    public abstract ProvidedService availServiceMapToReturnProvidedService(AvailableService service);
}
