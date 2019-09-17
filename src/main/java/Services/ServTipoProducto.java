package Services;

import java.util.List;

import daos.TipoProductoDAO;
import forms.TipoProductoForm;
import models.TipoProducto;

public class ServTipoProducto {
	private final TipoProductoDAO tipoProductoDAO = new TipoProductoDAO();

	public TipoProducto getTipoProducto(Integer idTipoProducto) {
		return tipoProductoDAO.findById(idTipoProducto);
	}

	public List<TipoProducto> findAll() {
		return tipoProductoDAO.findAll();
	}

	public void create(TipoProductoForm tpForm) {
		try {
			TipoProducto tipoProducto = new TipoProducto();
			tipoProducto.setDescripcion(tpForm.getDescripcion());
			tipoProductoDAO.save(tipoProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(TipoProductoForm tpForm) {
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setIdTipoProducto(tpForm.getIdTipoProducto());
		tipoProducto.setDescripcion(tpForm.getDescripcion());
		tipoProductoDAO.update(tipoProducto);
	}

	public void delete(Integer id) {
		tipoProductoDAO.delete(id);

	}
}
