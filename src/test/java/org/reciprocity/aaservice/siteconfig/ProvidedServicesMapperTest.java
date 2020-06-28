package org.reciprocity.aaservice.siteconfig;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.repository.siteconfig.ServiceEntity;
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
        ServiceEntity serviceEntity = mapper.providedServicesMapToEntity(providedService);

        ServiceEntity expected = new ServiceEntity();
        expected.setCategory("WH");
        expected.setDescription("test");
        expected.setName("test-name");

        assertEquals(expected.getCategory(), serviceEntity.getCategory());
        assertEquals(expected.getDescription(), serviceEntity.getDescription());
        assertEquals(expected.getName(), serviceEntity.getName());
    }

    @Test
    public void testAvailServiceMapToReturnProvidedService() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("test-name");
        serviceEntity.setDescription("test");
        serviceEntity.setServiceKey(1L);
        serviceEntity.setCategory("WH");
        ProvidedService actual = mapper.availServiceMapToReturnProvidedService(serviceEntity);


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
