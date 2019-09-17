<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<title>Listado de Tipos de Productos</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Listado de Tipos de Productos</h1>
		<div class="row mt-3 mb-3">
			<a style="text-decoration: none;" href="/tipoProducto/new.do">
				<button class="btn btn-primary" style="cursor: pointer;"
					class="button-delete">
					<i class="fa fa-plus"></i><b> Nuevo Tipo de Producto</b>
				</button>
			</a>
		</div>

		<div class="row">
			<table class="table table-striped"
				style="border-collapse: collapse; font-family: arial, sans-serif;">
				<tr style="border: 1px solid black; background-color: grey">
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><b>Indice</b></td>
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><b>Descripcion</b></td>
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><strong>Acciones</strong></td>
				</tr>
				<logic:iterate id="tipoProducto" name="tiposProductos">
					<tr style="border: 1px solid">
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="tipoProducto" property="idTipoProducto" /></td>
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="tipoProducto" property="descripcion" /></td>

						<td style="border: 1px solid; padding: 10px; text-align: center;">
							<a class="mr-3" style="text-decoration: none;"
							href="/tipoProducto/new.do?id=<bean:write name="tipoProducto" property="idTipoProducto" />">
								<i class="fa fa-pencil" style="font-size: 25px; color: #FFA500"></i>
						</a> <a style="text-decoration: none;"
							href="delete.do?id=<bean:write name="tipoProducto" property="idTipoProducto" />">
								<i class="fa fa-trash" style="font-size: 25px; color: red"></i>
						</a>
						</td>
					</tr>
				</logic:iterate>
			</table>
		</div>
		<div class="row mt-3 mb-3">
			<a style="text-decoration: none;" href="/Index.jsp">
				<button class="btn btn-success"
					style="cursor: pointer; width: 165.81px;" class="button-delete">
					<i class="fa fa-arrow-circle-left" style="color: white"></i><b>
						Volver</b>
				</button>
			</a>
		</div>
	</div>
</body>
</html>