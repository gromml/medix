package de.bittner.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MedixEntityManager {

	private static final String UNIT_NAME = "de.bittner.medix.persistance.jpa";

	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(UNIT_NAME);
		return entityManagerFactory.createEntityManager();
	}

}
