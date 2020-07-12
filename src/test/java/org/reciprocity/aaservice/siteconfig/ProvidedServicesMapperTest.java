package org.reciprocity.aaservice.siteconfig;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.repository.siteconfig.Services;
import org.reciprocity.aaservice.siteconfig.providedservice.ProvidedServicesMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProvidedServicesMapperTest {

    private ProvidedServicesMapper mapper
            = Mappers.getMapper(ProvidedServicesMapper.class);

    @Test
    public void testProvidedServicesMapToEntity() {
        ProvidedService providedService = new ProvidedService();

        providedService.setCategory("WH");
        providedService.setDescription("test");
        providedService.setName("test-name");
        Services services = mapper.providedServicesMapToEntity(providedService);

        Services expected = new Services();
        expected.setCategory("WH");
        expected.setDescription("test");
        expected.setName("test-name");

        assertEquals(expected.getCategory(), services.getCategory());
        assertEquals(expected.getDescription(), services.getDescription());
        assertEquals(expected.getName(), services.getName());
    }

    @Test
    public void testAvailServiceMapToReturnProvidedService() {
        Services services = new Services();
        services.setName("test-name");
        services.setDescription("test");
        services.setServiceKey(1L);
        services.setCategory("WH");
        ProvidedService actual = mapper.availServiceMapToReturnProvidedService(services);


        ProvidedService expected = new ProvidedService();
        expected.setName("test-name");
        expected.setCategory("WH");
        expected.setDescription("test");


        assertEquals(expected.getCategory(), actual.getCategory());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
    }


}
