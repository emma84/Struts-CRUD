<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Productos</title>
</head>
<body>
	<h1>Listado de Productos</h1>
	<a style="text-decoration: none;" href="/producto/new.do">
		<button style="cursor: pointer;" class="button-delete">Nuevo
			Producto</button>
	</a>
	<table
		style="border-collapse: collapse; font-family: arial, sans-serif;">
		<tr style="border: 1px solid; padding: 8px;">
			<td style="border: 1px solid; padding: 8px; background-color: grey;">Indice</td>
			<td style="border: 1px solid; padding: 8px; background-color: grey">Descripcion</td>
			<td style="border: 1px solid; padding: 8px; background-color: grey">Precio</td>
			<td style="border: 1px solid; padding: 8px; background-color: grey">Stock</td>
			<td style="border: 1px solid; padding: 8px; background-color: grey">Tipo
				de Producto</td>
			<br>
			<td style="border: 1px solid; padding: 15px; background-color: grey"><strong>Acciones</strong></td>
			<br>
		</tr>
		<logic:iterate id="producto" name="productos">
			<tr style="border: 1px solid">
				<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
						name="producto" property="idProducto" /></td>
				<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
						name="producto" property="descripcion" /></td>
				<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
						name="producto" property="precio" /></td>
				<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
						name="producto" property="stock" /></td>
				<td style="border: 1px solid; padding: 10px; text-align: center;"><bean:write
						name="producto" property="tipoProducto.descripcion" /></td>

				<td style="border: 1px solid; padding: 10px; text-align: center;">
					<a style="text-decoration: none;"
					href="delete.do?idProducto=<bean:write name="producto" property="idProducto" />">
						<button
							style="cursor: pointer; text-decoration: none; color: red;"
							class="button-delete">Delete</button>
				</a> <a style="text-decoration: none;"
					href="/producto/new.do?idProducto=<bean:write name="producto" property="idProducto" />">
						<button
							style="cursor: pointer; text-decoration: none; color: blue;"
							class="button-delete">Edit</button>
				</a>
				</td>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>