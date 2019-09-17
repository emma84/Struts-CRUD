package forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import Services.ServTipoProducto;
import models.TipoProducto;

public class TipoProductoForm extends ActionForm {

	private Integer idTipoProducto;
	private String descripcion;
	private List<TipoProducto> listadoProductos;
	private boolean created;

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (descripcion == null || descripcion.isEmpty()) {
			errors.add("descripcion", new ActionMessage("error.descripcion.required"));
		}
		ServTipoProducto servTipoProducto = new ServTipoProducto();
		setListadoProductos(servTipoProducto.findAll());
		setCreated(created);
		return errors;
	}

	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TipoProducto> getListadoProductos() {
		return listadoProductos;
	}

	public void setListadoProductos(List<TipoProducto> listadoProductos) {
		this.listadoProductos = listadoProductos;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}

}
