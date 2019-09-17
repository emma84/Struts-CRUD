package actions.tipoDocumento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServTipoDocumento;

public class DeleteAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ServTipoDocumento servTipoDocumento = new ServTipoDocumento();
		String id = request.getParameter("id");
		servTipoDocumento.delete(Integer.valueOf(id));
		request.setAttribute("tiposDocumentos", servTipoDocumento.findAll());
		return mapping.findForward("success");
	}
}
