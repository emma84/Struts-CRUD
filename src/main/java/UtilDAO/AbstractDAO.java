package UtilDAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDAO <T, K> {
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		List<T> entities = null;
		try {
			em.getTransaction().begin();
			entities = em.createQuery("from "+ entityClass.getName() + " e ").getResultList();
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
		return entities;
	}

	public void save(T entity) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}
	
	public void delete(K primaryKey) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			T entity = em.find(entityClass, primaryKey);
			em.remove(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}
	
	public void update(T entity) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}
	
	public T findById(K primaryKey) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		T t = null;
		try {
			em.getTransaction().begin();
			t = em.find(entityClass, primaryKey);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
		return t;
	}
	
	
}
