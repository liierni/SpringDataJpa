<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${mensajeAlta}

	<form action="/empleado/alta" method="post">
		<label for="idEmpl">Introduce el ID</label> 
			<input type="number" name="idEmpl" required><br> 
		<label for="nombre">Introduce el nombre</label> 
			<input type="text" name="nombre"><br> 
		<label for="apellidos">Introduce los apellidos</label> 
			<input type="text" name="apellidos"><br> 
		
		
		<label for="correo">Introduce el correo</label> 
			<input type="text" name="correo"><br> 
		<label for="password">Introduce la contraseña</label> 
			<input type="password" name="password"><br> 
		<label for="salario">Introduce el salario</label> 
			<input type="text" name="salario"><br> 

		<label for="fechaNacimiento">Introduce la fecha nacimiento</label> 
			<input type="date" name="fechaNacimiento"><br>

		<select name="perfil.idPerfil">
			<c:forEach items="${listaPerfiles}" var="ele">
				<option value="${ele.idPerfil}">${ele.nombre}</option>
			</c:forEach>
		</select>
		
		<select name="departamento.idDepar">
			<c:forEach items="${listaDepartamentos}" var="ele">
				<option value="${ele.idDepar}">${ele.nombre}</option>
			</c:forEach>
		</select>

		<br>
		<button type="submit">Dar de alta</button>
	</form>

</body>
</html>