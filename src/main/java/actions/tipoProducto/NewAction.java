package actions.tipoProducto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServTipoProducto;
import forms.TipoDocumentoForm;
import forms.TipoProductoForm;
import models.TipoProducto;

public class NewAction extends Action {

	private static final String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TipoProductoForm tpForm = new TipoProductoForm();
		if (request.getParameter("id") != null) {
			ServTipoProducto servTipoProducto = new ServTipoProducto();
			TipoProducto tipoProducto = servTipoProducto
					.getTipoProducto(Integer.valueOf(request.getParameter("id")));
			tpForm.setIdTipoProducto(tipoProducto.getIdTipoProducto());
			tpForm.setDescripcion(tipoProducto.getDescripcion());
			tpForm.setCreated(false);
		} else {
			tpForm.setCreated(true);
		}
		request.setAttribute("tipoProductoForm", tpForm);
		return mapping.findForward(SUCCESS);
	}
}
