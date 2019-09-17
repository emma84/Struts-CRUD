<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<script src="../js/bootstrap.min.js"></script>
<title>Tipos de Documentos</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Listado de Tipos de Documentos</h1>
		<div class="row mt-3 mb-3">
			<a style="text-decoration: none;" href="/tipoDocumento/new.do"><button
					class="btn btn-primary" style="cursor: pointer;"
					class="button-create">
					<i class="fa fa-plus"></i><b> Nuevo Tipo de Documento</b>
				</button> </a>
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
				<logic:iterate id="tipoDocumento" name="tiposDocumentos">
					<tr style="border: 1px solid">
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="tipoDocumento" property="id" /></td>
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="tipoDocumento" property="descripcion" /></td>

						<td style="border: 1px solid; padding: 10px; text-align: center;">
							<a class="mr-3" style="text-decoration: none;"
							href="/tipoDocumento/new.do?id=<bean:write name="tipoDocumento" property="id" />">
								<i class="fa fa-pencil" style="font-size: 25px; color: #FFA500"></i>
						</a> <a style="text-decoration: none;"
							href="delete.do?id=<bean:write name="tipoDocumento" property="id" />">
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