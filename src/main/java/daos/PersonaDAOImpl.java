package daos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Persona;

public class PersonaDAOImpl implements PersonaDAO {

	@Override
	public void save(Persona persona) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		// System.out.println("Is opened connection :: "+
		// factory.createEntityManager().isOpen());
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(persona);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}

	@Override
	public void delete(Integer idPersona) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Persona persona = em.find(Persona.class, idPersona);
			em.remove(persona);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}

	@Override
	public void update(Persona persona) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(persona);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> findAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		List<Persona> personas = null;
		try {
			em.getTransaction().begin();
			personas = em.createQuery("from Persona p").getResultList();
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
		return personas;
	}

	@Override
	public Persona findById(Integer idPersona) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		Persona persona = null;
		try {
			em.getTransaction().begin();
			persona = em.find(Persona.class, idPersona);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
		return persona;
	}

}
