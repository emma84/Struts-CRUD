package Services;

import java.util.List;

import daos.ProductoDAO;
import daos.ProductoDAOImpl;
import forms.ProductoForm;
import models.Producto;

public class ServProducto {
	private final ProductoDAO productoDAO = new ProductoDAOImpl();

	public List<Producto> findAll() {
		return productoDAO.findAll();
	}

	public void delete(Long idProducto) {
		productoDAO.delete(idProducto);
	}

	public void create(ProductoForm pForm)

	{
		try {
			ServTipoProducto servTipoProducto = new ServTipoProducto();
			Producto producto = new Producto();
			producto.setDescripcion(pForm.getDescripcion());
			producto.setPrecio(pForm.getPrecio());
			producto.setStock(pForm.getStock());
			producto.setTipoProducto(servTipoProducto.getTipoProducto(pForm.getIdTipoProducto()));
			productoDAO.save(producto);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Producto getProducto(Long idProducto) {
		return productoDAO.findById(idProducto);

	}

	public void update(ProductoForm pForm) {
		ServTipoProducto servTipoProducto = new ServTipoProducto();
		Producto producto = new Producto();
		producto.setIdProducto(pForm.getIdProducto());
		producto.setDescripcion(pForm.getDescripcion());
		producto.setPrecio(pForm.getPrecio());
		producto.setStock(pForm.getStock());
		producto.setTipoProducto(servTipoProducto.getTipoProducto(pForm.getIdTipoProducto()));
		productoDAO.update(producto);
	}

}
