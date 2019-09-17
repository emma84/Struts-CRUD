package Services;

import java.util.List;

import daos.TipoDocumentoDAO;
import forms.TipoDocumentoForm;
import models.TipoDocumento;

public class ServTipoDocumento {

	private final TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();

	public TipoDocumento getTipoDocumento(Integer id) {
		return tipoDocumentoDAO.findById(id);
	}

	public List<TipoDocumento> findAll() {
		return tipoDocumentoDAO.findAll();
	}

	public void delete(Integer id) {
		tipoDocumentoDAO.delete(id);
	}

	public void create(TipoDocumentoForm tdForm) {
		try {
			TipoDocumento tipoDocumento = new TipoDocumento();
			tipoDocumento.setDescripcion(tdForm.getDescripcion());
			tipoDocumentoDAO.save(tipoDocumento);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(TipoDocumentoForm tdForm) {
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setId(tdForm.getIdTipodocumento());
		tipoDocumento.setDescripcion(tdForm.getDescripcion());
		tipoDocumentoDAO.update(tipoDocumento);
	}

}
