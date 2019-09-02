package forms;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class PersonaForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private Integer numDocumento;
	private Integer idPersona;

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
		if (tipoDocumento == null || tipoDocumento.length() < 1) {
			errors.add("tipoDocumento", new ActionMessage("error.tipoDocumento.required"));
		}
		if (numDocumento == null || numDocumento < 1) {
			errors.add("numDocumento", new ActionMessage("error.numDocumento.required"));
		}
		return errors;
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(Integer numDocumento) {
		this.numDocumento = numDocumento;
	}

}