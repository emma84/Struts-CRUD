package forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import Services.ServTipoDocumento;
import models.TipoDocumento;

public class PersonaForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private Integer tipoDocumento;
	private Integer numDocumento;
	private Integer idPersona;
	private List<TipoDocumento> listadoDocumentos;
	public boolean created;

	/**
	 * This is the action called from the Struts framework.
	 * 
	 * @param mapping The ActionMapping used to select this instance.
	 * @param request The HTTP Request we are processing.
	 * @return
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (nombre == null || nombre.length() < 1) {
			errors.add("nombre", new ActionMessage("error.nombre.required"));
		}
		if (apellido == null || apellido.length() < 1) {
			errors.add("apellido", new ActionMessage("error.apellido.required"));
		}
		if (tipoDocumento == null || tipoDocumento <1) {
			errors.add("tipoDocumento", new ActionMessage("error.tipoDocumento.required"));
		}
		if (numDocumento == null || numDocumento < 1) {
			errors.add("numDocumento", new ActionMessage("error.numDocumento.required"));
		}
		ServTipoDocumento servTipoDocumento = new ServTipoDocumento();
		setListadoDocumentos(servTipoDocumento.findAll());
		setCreated(created);
		return errors;
	}

	public void setListadoDocumentos(List<TipoDocumento> listadoDocumentos) {
		this.listadoDocumentos = listadoDocumentos;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(Integer numDocumento) {
		this.numDocumento = numDocumento;
	}

	public List<TipoDocumento> getListadoDocumentos() {
		return listadoDocumentos;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}
	

}