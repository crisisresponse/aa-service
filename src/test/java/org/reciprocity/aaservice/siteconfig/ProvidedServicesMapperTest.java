package org.reciprocity.aaservice.siteconfig;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.repository.siteconfig.AvailableService;
import org.reciprocity.aaservice.siteconfig.providedservices.ProvidedServicesMapper;

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
        AvailableService availableService = mapper.providedServicesMapToEntity(providedService);

        AvailableService expected = new AvailableService();
        expected.setCategory("WH");
        expected.setDescription("test");
        expected.setName("test-name");

        assertEquals(expected.getCategory(), availableService.getCategory());
        assertEquals(expected.getDescription(), availableService.getDescription());
        assertEquals(expected.getName(), availableService.getName());
    }

    @Test
    public void testAvailServiceMapToReturnProvidedService() {
        AvailableService availableService = new AvailableService();
        availableService.setName("test-name");
        availableService.setDescription("test");
        availableService.setServiceKey(1L);
        availableService.setCategory("WH");
        ProvidedService actual = mapper.availServiceMapToReturnProvidedService(availableService);


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
