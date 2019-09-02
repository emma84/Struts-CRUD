package actions.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServPersona;
import models.Persona;

public class DeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ServPersona servPersona = new ServPersona();
		String id = request.getParameter("idPersona");
		servPersona.delete(Integer.valueOf(id));
		request.setAttribute("personas", servPersona.findAll());
		return mapping.findForward("success");
	}

}
