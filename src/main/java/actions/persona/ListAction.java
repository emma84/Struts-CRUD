package actions.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServPersona;
import models.Persona;

public class ListAction extends Action {

	private static final String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ServPersona servPersona = new ServPersona();
		request.setAttribute("personas", servPersona.findAll());

		return mapping.findForward(SUCCESS);
	}

}
