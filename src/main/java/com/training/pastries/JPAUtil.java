package com.training.pastries;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "pu";
    private static EntityManagerFactory factory;

    private JPAUtil(){

    }

    public final static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
