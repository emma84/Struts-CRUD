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
<title>Nueva Persona</title>
</head>
<body>
	<html:form action="persona/createUpdate">
		<html:text property="idPersona" name="personaForm" style="display:none" />
		<div>
			<div style="color: red">
				<html:errors property="nombre" />
			</div>
			<label id="nombre">Nombre:</label>
			<html:text property="nombre" name="personaForm" />
			
		</div>

		<div>
			<div style="color: red">
				<html:errors property="apellido" />
			</div>
			<label id="apellido">Apellido:</label>
			<html:text property="apellido" name="personaForm" />
		</div>

		<div>
			<div style="color: red">
				<html:errors property="tipoDocumento" />
			</div>
			<label id="tipoDocumento">Tipo Documento:</label>
			<html:text property="tipoDocumento" name="personaForm" />

		</div>

		<div>
			<div style="color: red">
				<html:errors property="numDocumento" />
			</div>
			<label id="numDocumento">Numero de Documento:</label>
			<html:text property="numDocumento" name="personaForm" />
		</div>
		<logic:present name="update">
				<html:submit value="Actualizar" />
		</logic:present>
		
		<logic:present name="create">
				<html:submit value="Crear"/>
		</logic:present>

	</html:form>
</body>
</html>