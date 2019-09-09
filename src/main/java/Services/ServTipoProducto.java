package Services;

import java.util.List;

import daos.TipoProductoDAO;
import models.TipoProducto;

public class ServTipoProducto {
	private final TipoProductoDAO productoDAO = new TipoProductoDAO();

	public TipoProducto getTipoProducto(Integer idTipoProducto) {
		return productoDAO.findById(idTipoProducto);
	}
	
	public List<TipoProducto> listadoProductos(){
		return productoDAO.findAll();
	}

}
