package org.reciprocity.aaservice.siteconfig;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.repository.AvailableService;

@Mapper
public interface SiteConfigMapper {

    public static SiteConfigMapper SITE_CONFIG_MAPPER = Mappers.getMapper(SiteConfigMapper.class);

    AvailableService providedServicesMapToEntity(ProvidedService providedService);
    ProvidedService availServiceMapToReturnProvidedService(Object service);
}
