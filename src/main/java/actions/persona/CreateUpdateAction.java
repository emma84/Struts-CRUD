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

public class CreateUpdateAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ServTipoDocumento servTipoDocumento = new ServTipoDocumento();
		PersonaForm pForm = (PersonaForm) form;
		try {
			ServPersona servPersona = new ServPersona();
			if (pForm.getIdPersona() != null) {
				servPersona.update(pForm);
			} else {
				servPersona.create(pForm);
			}
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			pForm.setListadoDocumentos(servTipoDocumento.findAll());
			request.setAttribute("personaForm", pForm);
			return mapping.findForward("failure");
		}
	}
}