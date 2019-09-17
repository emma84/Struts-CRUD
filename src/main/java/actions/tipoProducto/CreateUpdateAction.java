package actions.tipoProducto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServTipoProducto;
import forms.TipoProductoForm;
import models.TipoProducto;

public class CreateUpdateAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		TipoProductoForm tpForm = (TipoProductoForm) form;
		ServTipoProducto servTipoProducto = new ServTipoProducto();
		try {
			if (tpForm.getIdTipoProducto() != null && tpForm.getIdTipoProducto() > 0) {
				servTipoProducto.update(tpForm);
			} else {
				servTipoProducto.create(tpForm);
			}
			request.setAttribute("tiposProductos", servTipoProducto.findAll());
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			tpForm.setListadoProductos(servTipoProducto.findAll());
			request.setAttribute("tipoProductoForm", tpForm);
			return mapping.findForward("failure");
		}
	}
}
