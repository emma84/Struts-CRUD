package actions.tipoProducto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServTipoProducto;

public class DeleteAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ServTipoProducto servTipoProducto = new ServTipoProducto();
		String id = request.getParameter("id");
		servTipoProducto.delete(Integer.valueOf(id));
		request.setAttribute("tiposProductos", servTipoProducto.findAll());
		return mapping.findForward("success");
	}
}
