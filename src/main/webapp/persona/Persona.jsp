
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
<title><logic:equal name="personaForm" property="created" value="false">
				Actualizar Persona
			</logic:equal> <logic:equal name="personaForm" property="created" value="true">
				Crear Nueva Persona
			</logic:equal></title>
</head>
<body>
	<logic:equal name="personaForm" property="created" value="false">
		<h2 class="text-center">Actualizar Persona</h2>
	</logic:equal>
	<logic:equal name="personaForm" property="created" value="true">
		<h2 class="text-center">Crear Nueva Persona</h2>
	</logic:equal>

	<div style="width: 300px; margin: 0 auto; margin-top: 25px">
		<html:form action="persona/createUpdate">
			<div class="form-group">
				<html:text property="idPersona" name="personaForm"
					style="display:none" />
					<html:text property="created" name="personaForm"
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
					<html:errors property="descripcion" />
				</div>
				<label>Tipo Documento:</label>
				<html:select styleClass="form-control" name="personaForm"
					property="tipoDocumento">
					<html:option value="0">Seleccione Tipo de Documento</html:option>
					<html:optionsCollection name="personaForm"
						property="listadoDocumentos" label="descripcion"
						value="id" />
				</html:select>
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
							href="/persona/list.do" class="btn btn-success btn-lg btn-block">
							<i class="fa fa-arrow-circle-left" style="color: white"></i> <b>Volver</b>
						</a>
					</div>
				</div>
				<div class="col-6">
					<logic:equal name="personaForm" property="created" value="false">
						<html:submit styleClass="btn btn-primary btn-lg btn-block"
							value="Actualizar" />
					</logic:equal>

					<logic:equal name="personaForm" property="created" value="true">
						<html:submit styleClass="btn btn-primary btn-lg btn-block"
							value="Crear" />
					</logic:equal>
				</div>
			</div>
		</html:form>
	</div>
</body>
</html>