<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empleados</title>
</head>
<body>

	${mensajeBaja}
	
	<table>
		<tr>
			<th>ID Empleado</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Editar</th>
			<th>Eliminar</th>
		</tr>
	
		
			<c:forEach items="${listaEmpleados}" var="ele">
			<tr>
				<td>${ele.idEmpl}</td>
				<td>${ele.nombre}</td>
				<td>${ele.apellidos}</td>
				<td><a href="/empleado/editar/${ele.idEmpl}">Editar empleado</a></td>
				<td><a href="/empleado/eliminar/${ele.idEmpl}">Eliminar empleado</a></td>
			</tr>
			</c:forEach>

		
	</table>
</body>
</html>