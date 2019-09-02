package actions.producto;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServProducto;
import Services.ServTipoProducto;
import forms.ProductoForm;
import models.Producto;
import models.TipoProducto;

public class NewAction extends Action {
	private static final String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProductoForm pForm = new ProductoForm();
		// Buscar todos los productos
		ServProducto servProducto = new ServProducto();
		ServTipoProducto servTipoProducto = new ServTipoProducto();
		pForm.setListadoProductos(servTipoProducto.listadoProductos());
		if (request.getParameter("idProducto") != null) {

			// ServTipoProducto servTipoProducto = new ServTipoProducto();

			Producto producto = servProducto.getProducto(Long.valueOf(request.getParameter("idProducto")));

			pForm.setIdProducto(producto.getIdProducto());
			pForm.setDescripcion(producto.getDescripcion());
			pForm.setPrecio(producto.getPrecio());
			pForm.setStock(producto.getStock());
			pForm.setIdTipoProducto(producto.getTipoProducto().getIdTipoProducto());
			request.setAttribute("update", true);
		} else {
			request.setAttribute("create", true);
		}
		request.setAttribute("productoForm", pForm);
		return mapping.findForward(SUCCESS);
	}

}
