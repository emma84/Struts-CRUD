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
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<script src="../js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><logic:present name="update">
				Actualizar Producto
			</logic:present> <logic:present name="create">
				Crear Nuevo Producto
			</logic:present></title>
</head>
<body>

	<logic:present name="update">
		<h2 class="text-center">Actualizar Producto</h2>
	</logic:present>
	<logic:present name="create">
		<h2 class="text-center">Crear Nuevo Producto</h2>
	</logic:present>

	<div style="width: 300px; margin: 0 auto; margin-top: 25px">
		<html:form action="producto/createUpdate.do">
			<div class="form-group">
				<html:text property="idProducto" name="productoForm"
					style="display:none" />
				<div style="color: red">
					<html:errors property="descripcion" />
				</div>
				<label id="nombre">Descripcion:</label>
				<html:text styleClass="form-control" property="descripcion"
					name="productoForm" />
			</div>

			<div class="form-group">
				<div style="color: red">
					<html:errors property="precio" />
				</div>
				<label id="precio">Precio:</label>
				<html:text styleClass="form-control" property="precio"
					name="productoForm" />
			</div>

			<div class="form-group">
				<div style="color: red">
					<html:errors property="stock" />
				</div>
				<label id="stock">Stock:</label>
				<html:text styleClass="form-control" property="stock"
					name="productoForm" />
			</div>

			<div class="form-group">
				<div style="color: red">
					<html:errors property="idTipoProducto" />
				</div>
				<label>Tipo Producto:</label>
				<html:select styleClass="form-control" name="productoForm"
					property="idTipoProducto">
					<html:option value="0">Seleccione Tipo de Producto</html:option>
					<html:optionsCollection name="productoForm"
						property="listadoProductos" label="descripcion"
						value="idTipoProducto" />
				</html:select>
			</div>
			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<a style="text-decoration: none; cursor: pointer; width: 100%"
							href="/producto/List.do" class="btn btn-success btn-lg btn-block">
							<i class="fa fa-arrow-circle-left" style="color: white"></i> <b>Volver</b>
						</a>
					</div>
				</div>
				<div class="col-6">
					<logic:present name="update" >
						<html:submit value="Actualizar"
							styleClass="btn btn-primary btn-lg btn-block" />
					</logic:present>
					<logic:present name="create">
						<html:submit styleClass="btn btn-primary btn-lg btn-block"
							value="Crear" />
					</logic:present>
				</div>
			</div>
		</html:form>
	</div>
</body>
</html>