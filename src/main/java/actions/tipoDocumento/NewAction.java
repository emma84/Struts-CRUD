package actions.tipoDocumento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServTipoDocumento;
import forms.TipoDocumentoForm;
import models.TipoDocumento;

public class NewAction extends Action {

	private static final String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TipoDocumentoForm tdForm = new TipoDocumentoForm();
		if (request.getParameter("id") != null) {
			ServTipoDocumento servTipoDocumento = new ServTipoDocumento();
			TipoDocumento tipoDocumento = servTipoDocumento
					.getTipoDocumento(Integer.valueOf(request.getParameter("id")));
			tdForm.setIdTipodocumento(tipoDocumento.getId());
			tdForm.setDescripcion(tipoDocumento.getDescripcion());
			tdForm.setCreated(false);
		} else {
			tdForm.setCreated(true);
		}
		request.setAttribute("tipoDocumentoForm", tdForm);
		return mapping.findForward(SUCCESS);
	}
}
