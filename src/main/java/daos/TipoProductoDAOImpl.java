package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.jpa.rs.PersistenceContextFactory;

import models.Producto;
import models.TipoProducto;

public class TipoProductoDAOImpl implements TipoProductoDAO {

	@Override
	public TipoProducto findById(Integer idTipoProducto) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		TipoProducto tp = null;
		try {
			em.getTransaction().begin();
			tp = em.find(TipoProducto.class, idTipoProducto);
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
		return tp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoProducto> findAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts-jpa");
		EntityManager em = factory.createEntityManager();
		List<TipoProducto> listado = null;
		try {
			em.getTransaction().begin();
			listado = em.createQuery("from TipoProducto p").getResultList();
			em.getTransaction().commit();
		} finally {
			em.close();
			factory.close();
		}
		return listado;
	}

}
