
package actions.producto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServProducto;

public class ListAction extends Action {

	private static final String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ServProducto servProducto = new ServProducto();
		request.setAttribute("productos", servProducto.findAll());

		return mapping.findForward(SUCCESS);
	}
}
