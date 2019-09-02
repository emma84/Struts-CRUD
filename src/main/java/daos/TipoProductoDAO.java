package daos;

import java.util.List;

import models.TipoProducto;

public interface TipoProductoDAO {
	public TipoProducto findById(Integer idTipoProducto);

	public List<TipoProducto> findAll();
}
