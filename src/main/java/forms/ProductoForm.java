package forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import Services.ServTipoProducto;
import models.TipoProducto;

public class ProductoForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private Long idProducto;
	private String descripcion;
	private double precio;
	private int stock;
	private int idTipoProducto;
	private List<TipoProducto> listadoTipoProductos;
	private boolean created;

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (descripcion == null || descripcion.length() < 1) {
			errors.add("descripcion", new ActionMessage("error.descripcion.required"));
		}
		if ((String.valueOf(precio).isEmpty()) || precio <= 0) {
			errors.add("precio", new ActionMessage("error.precio.required"));
		}
		if ((String.valueOf(stock).isEmpty()) || stock < 0) {
			errors.add("stock", new ActionMessage("error.stock.required"));
		}
		if (idTipoProducto == -1 || idTipoProducto == 0) {
			errors.add("idTipoProducto", new ActionMessage("error.idTipoProducto.required"));
		}

		ServTipoProducto servTipoProducto = new ServTipoProducto();
		setListadoTipoProductos(servTipoProducto.findAll());
		setCreated(created);
		return errors;
	}

	public List<TipoProducto> getListadoTipoProductos() {
		return listadoTipoProductos;
	}

	public void setListadoTipoProductos(List<TipoProducto> listadoTipoProductos) {
		this.listadoTipoProductos = listadoTipoProductos;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}

	
}
