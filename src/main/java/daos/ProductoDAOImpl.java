package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Producto;

@SuppressWarnings("unchecked")
public class ProductoDAOImpl implements ProductoDAO {
	public List<Producto> findAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		List<Producto> productos = null;
		try {
			em.getTransaction().begin();
			productos = em.createQuery("from Producto p").getResultList();
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
		return productos;
	}

	@Override
	public void delete(Long idProducto) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Producto producto = em.find(Producto.class, idProducto);
			em.remove(producto);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}

	@Override
	public Producto findById(Long idProducto) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		Producto producto = null;
		try {
			em.getTransaction().begin();
			producto = em.find(Producto.class, idProducto);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
		return producto;
	}

	@Override
	public void save(Producto producto) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(producto);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}

	@Override
	public void update(Producto producto) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(producto);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
	}
}
