package org.reciprocity.aaservice.siteconfig;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reciprocity.aaservice.repository.siteconfig.ServiceConfigRepository;
import org.reciprocity.aaservice.repository.siteconfig.Services;
import org.reciprocity.aaservice.util.MCRPostgresqlContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvidedServicesIntegrationTest {

    @Autowired
    ServiceConfigRepository serviceConfigRepository;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = MCRPostgresqlContainer.getInstance();

    @Test
    @Transactional
    public void saveToDB() {
        Services services = new Services();
        services.setName("food-service");
        services.setCategory("food");
        services.setDescription("Just food");
        Services response = serviceConfigRepository.save(services);

        Assert.assertNotNull(response);
    }



}


