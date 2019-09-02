<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<html:form action="producto/createUpdate.do">
		<html:text property="idProducto" name="productoForm"
			style="display:none" />
		<div>
			<div style="color: red">
				<html:errors property="descripcion" />
			</div>
			<label id="nombre">Descripcion:</label>
			<html:text property="descripcion" name="productoForm" />

		</div>

		<div>
			<div style="color: red">
				<html:errors property="precio" />
			</div>
			<label id="precio">Precio:</label>
			<html:text property="precio" name="productoForm" />
		</div>

		<div>
			<div style="color: red">
				<html:errors property="stock" />
			</div>
			<label id="stock">Stock:</label>
			<html:text property="stock" name="productoForm" />

		</div>

		<div>
			<div style="color: red">
				<html:errors property="idTipoProducto" />
			</div>
			<label>Tipo Producto:</label>
			<html:select name="productoForm" property="idTipoProducto">
				<html:option value="0">Seleccione Tipo de Producto</html:option>
				<html:optionsCollection name="productoForm" property="listadoProductos"
					label="descripcion" value="idTipoProducto" />
			</html:select>
		</div>

		<logic:present name="update">
			<html:submit value="Actualizar" />
		</logic:present>

		<logic:present name="create">
			<html:submit value="Crear" />
		</logic:present>

	</html:form>
</body>
</html>