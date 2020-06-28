package org.reciprocity.aaservice.siteconfig;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.reciprocity.aaservice.util.MCRPostgresqlContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvailableTimeSlotsIntegrationTest {

    @Autowired


    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = MCRPostgresqlContainer.getInstance();


    
}


