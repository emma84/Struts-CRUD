package actions.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import Services.ServPersona;
import forms.PersonaForm;
import models.Persona;

public class NewAction extends Action {

	private static final String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("idPersona") != null) {
			ServPersona servPersona = new ServPersona();
			Persona persona = servPersona.getPersona(Integer.valueOf(request.getParameter("idPersona")));
			PersonaForm pForm = new PersonaForm();
			pForm.setIdPersona(persona.getIdPersona());
			pForm.setNombre(persona.getNombre());
			pForm.setApellido(persona.getApellido());
			pForm.setTipoDocumento(persona.getTipoDni());
			pForm.setNumDocumento(persona.getDni());
			request.setAttribute("personaForm", pForm);
			request.setAttribute("update", true);
		} else {
			request.setAttribute("create", true);
		}
		return mapping.findForward(SUCCESS);
	}

}
