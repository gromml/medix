package de.bittner.persistance.entities;

import javax.persistence.EntityManager;

import org.junit.Test;

import de.bittner.persistance.MedixEntityManager;

public class TrackTest {

	@Test
	public void testPersistance() {
		EntityManager em = MedixEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(new Track(1L, "Bla"));
		em.persist(new Track(2L, "Blabla"));
		em.getTransaction().commit();
		em.close();
	}
}
