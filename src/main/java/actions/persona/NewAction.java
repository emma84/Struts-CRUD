package actions.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServPersona;
import Services.ServTipoDocumento;
import forms.PersonaForm;
import models.Persona;

public class NewAction extends Action {

	private static final String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PersonaForm pForm = new PersonaForm();
		if (request.getParameter("idPersona") != null) {
			ServPersona servPersona = new ServPersona();
			Persona persona = servPersona.getPersona(Integer.valueOf(request.getParameter("idPersona")));
			
			pForm.setIdPersona(persona.getIdPersona());
			pForm.setNombre(persona.getNombre());
			pForm.setApellido(persona.getApellido());
			pForm.setTipoDocumento(persona.getTipoDni().getId());
			pForm.setNumDocumento(persona.getDni());
			pForm.setCreated(false);
			request.setAttribute("update", true);
		} else {
			pForm.setCreated(true);
			request.setAttribute("create", true);
		}
		ServTipoDocumento servTipoDocumento = new ServTipoDocumento();
		pForm.setListadoDocumentos(servTipoDocumento.findAll());
		request.setAttribute("personaForm", pForm);
		return mapping.findForward(SUCCESS);
	}

}
