package org.reciprocity.aaservice.util;

import org.testcontainers.containers.PostgreSQLContainer;

public class MCRPostgresqlContainer extends PostgreSQLContainer<MCRPostgresqlContainer> {

    private static final String IMAGE_VERSION = "postgres:12.3";
    private static MCRPostgresqlContainer container;

    private MCRPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static MCRPostgresqlContainer getInstance() {
        if (container == null) {
            container = new MCRPostgresqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", "jdbc:postgresql://localhost:5432/postgres");
        System.setProperty("DB_USERNAME", "postgres");
        System.setProperty("DB_PASSWORD", "rootpassword");
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
