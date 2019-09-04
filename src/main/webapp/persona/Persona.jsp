
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
<title><logic:present name="update">
				Actualizar Persona
			</logic:present> <logic:present name="create">
				Crear Nueva Persona
			</logic:present></title>
</head>
<body>
	<logic:present name="update">
		<h2 class="text-center">Actualizar Persona</h2>
	</logic:present>
	<logic:present name="create">
		<h2 class="text-center">Crear Nueva Persona</h2>
	</logic:present>

	<div style="width: 300px; margin: 0 auto; margin-top: 25px">
		<html:form action="persona/createUpdate">
			<div class="form-group">
				<html:text property="idPersona" name="personaForm"
					style="display:none" />
				<div style="color: red">
					<html:errors property="nombre" />
				</div>
				<label id="nombre">Nombre:</label>
				<html:text styleClass="form-control" property="nombre"
					name="personaForm" />
			</div>


			<div class="form-group">
				<div style="color: red">
					<html:errors property="apellido" />
				</div>
				<label id="apellido">Apellido:</label>
				<html:text styleClass="form-control" property="apellido"
					name="personaForm" />
			</div>

			<div class="form-group">
				<div style="color: red">
					<html:errors property="tipoDocumento" />
				</div>
				<label id="tipoDocumento">Tipo Documento:</label>
				<html:text styleClass="form-control" property="tipoDocumento"
					name="personaForm" />
			</div>
			<div class="form-group">
				<div style="color: red">
					<html:errors property="numDocumento" />
				</div>
				<label id="numDocumento">Numero de Documento:</label>
				<html:text styleClass="form-control" property="numDocumento"
					name="personaForm" />
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
					<logic:present name="update">
						<html:submit styleClass="btn btn-primary btn-lg btn-block"
							value="Actualizar" />
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