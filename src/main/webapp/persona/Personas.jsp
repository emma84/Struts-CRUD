<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<script src="../js/bootstrap.min.js"></script>
<title>Listado de Personas</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Listado de Personas</h1>
		<div class="row mt-3 mb-3">
			<a style="text-decoration: none;" href="/persona/new.do"><button
					class="btn btn-primary" style="cursor: pointer;"
					class="button-create">
					<i class="fa fa-plus"></i><b> Nueva Persona</b>
				</button> </a>
		</div>

		<div class="row">
			<table class="table table-striped"
				style="border-collapse: collapse; font-family: arial, sans-serif;">
				<tr style="border: 1px solid black; background-color: grey">
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><b>Indice</b></td>
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><b>Nombre</b></td>
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><b>Apellido</b></td>
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><b>Tipo Documento</b></td>
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><b>Numero Documento</b></td>
					<td style="border: 1px solid black; padding: 8px; color: white;"
						class="text-center"><strong>Acciones</strong></td>
				</tr>
				<logic:iterate id="persona" name="personas">
					<tr style="border: 1px solid">
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="persona" property="idPersona" /></td>
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="persona" property="nombre" /></td>
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="persona" property="apellido" /></td>
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="persona" property="tipoDni" /></td>
						<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
								name="persona" property="dni" /></td>

						<td style="border: 1px solid; padding: 10px; text-align: center;">
							<a class="mr-3" style="text-decoration: none;"
							href="/persona/new.do?idPersona=<bean:write name="persona" property="idPersona" />">
								<i class="fa fa-pencil" style="font-size: 25px; color: #FFA500"></i>
						</a> <a style="text-decoration: none;"
							href="delete.do?idPersona=<bean:write name="persona" property="idPersona" />">
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