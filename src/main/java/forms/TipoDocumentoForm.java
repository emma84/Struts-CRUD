package forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import Services.ServTipoDocumento;
import models.TipoDocumento;

public class TipoDocumentoForm extends ActionForm {

	private Integer idTipodocumento;
	private String descripcion;
	private List<TipoDocumento> listadoDocumentos;
	public boolean created;


	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if (descripcion == null || descripcion.length() < 1) {
			errors.add("descripcion", new ActionMessage("error.descripcion.required"));
		}
		
		ServTipoDocumento servTipoDocumento= new ServTipoDocumento();
		setListadoDocumentos(servTipoDocumento.findAll());
		setCreated(created);
		return errors;
	}

	public Integer getIdTipodocumento() {
		return idTipodocumento;
	}

	public void setIdTipodocumento(Integer idTipodocumento) {
		this.idTipodocumento = idTipodocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TipoDocumento> getListadoDocumentos() {
		return listadoDocumentos;
	}

	public void setListadoDocumentos(List<TipoDocumento> listadoDocumentos) {
		this.listadoDocumentos = listadoDocumentos;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}
	
	
}
