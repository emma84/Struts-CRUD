<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<script src="../js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title><logic:equal name="tipoProductoForm" property="created"
		value="false">
				Actualizar Tipo de Producto
			</logic:equal> <logic:equal name="tipoProductoForm" property="created" value="true">
				Crear Tipo de Producto
			</logic:equal></title>
</head>
<body>
	<logic:equal name="tipoProductoForm" property="created" value="false">
		<h2 class="text-center">Actualizar Tipo de Producto</h2>
	</logic:equal>
	<logic:equal name="tipoProductoForm" property="created" value="true">
		<h2 class="text-center">Crear Tipo de Producto</h2>
	</logic:equal>

	<div style="width: 300px; margin: 0 auto; margin-top: 25px">
		<html:form action="/tipoProducto/createUpdate.do">
				<html:text property="idTipoProducto" name="tipoProductoForm"
					style="display:none" />
			<html:text property="created" name="tipoProductoForm"
				style="display:none" />

			<div class="form-group">
				<div style="color: red">
					<html:errors property="descripcion" />
				</div>
				<label id="descripcion">Descripcion:</label>
				<html:text styleClass="form-control" property="descripcion"
					name="tipoProductoForm" />
			</div>
			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<a style="text-decoration: none; cursor: pointer; width: 100%"
							href="/tipoProducto/list.do"
							class="btn btn-success btn-lg btn-block"> <i
							class="fa fa-arrow-circle-left" style="color: white"></i> <b>Volver</b>
						</a>
					</div>
				</div>
				<div class="col-6">
					<logic:equal name="tipoProductoForm" property="created"
						value="false">
						<html:submit value="Actualizar"
							styleClass="btn btn-primary btn-lg btn-block" />
					</logic:equal>
					<logic:equal name="tipoProductoForm" property="created"
						value="true">
						<html:submit styleClass="btn btn-primary btn-lg btn-block"
							value="Crear" />
					</logic:equal>
				</div>
			</div>
		</html:form>
	</div>
</body>
</html>