package daos;

import java.util.List;
import models.Producto;

public interface ProductoDAO {

	public List<Producto> findAll();

	public void delete(Long idProducto);

	public Producto findById(Long idProducto);

	public void save(Producto producto);

	public void update(Producto producto);
}
