package Services;

import java.util.List;

import daos.ProductoDAO;
import daos.ProductoDAOImpl;
import daos.TipoProductoDAO;
import daos.TipoProductoDAOImpl;
import models.TipoProducto;

public class ServTipoProducto {
	private final TipoProductoDAO productoDAO = new TipoProductoDAOImpl();

	public TipoProducto getTipoProducto(Integer idTipoProducto) {
		return productoDAO.findById(idTipoProducto);
	}
	
	public List<TipoProducto> listadoProductos(){
		return productoDAO.findAll();
	}

}
