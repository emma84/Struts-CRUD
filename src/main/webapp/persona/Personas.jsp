<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Tabla de Personas</h1>
	<a href="/persona/new.do"><button style="cursor: pointer;"
			class="button-create">Nueva Persona</button></a>

	<table
		style="border-collapse: collapse; font-family: arial, sans-serif;">
		<tr style="border: 1px solid; padding: 8px;">
			<td style="border: 1px solid; padding: 8px; background-color: grey;">Indice</td>
			<td style="border: 1px solid; padding: 8px; background-color: grey">Nombre</td>
			<td style="border: 1px solid; padding: 8px; background-color: grey">Apellido</td>
			<td style="border: 1px solid; padding: 8px; background-color: grey">Tipo
				Documento</td>
			<td style="border: 1px solid; padding: 8px; background-color: grey">Numero
				Documento</td>
			<br>
			<td style="border: 1px solid; padding: 15px; background-color: grey"><strong>Acciones</strong></td>
			<br>
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
					<a style="text-decoration: none;"
					href="delete.do?idPersona=<bean:write name="persona" property="idPersona" />">
						<button
							style="cursor: pointer; text-decoration: none; color: red;"
							class="button-delete">Delete</button>
				</a> <a style="text-decoration: none;"
					href="/persona/new.do?idPersona=<bean:write name="persona" property="idPersona" />">
						<button style="cursor: pointer; text-decoration: none; color: blue;"
							class="button-delete">Edit</button>
				</a>
				</td>
			</tr>
		</logic:iterate>
	</table>

</body>
</html>