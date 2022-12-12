<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>

${mensaje}

	<form action="/inicio" method="post">
		<label for="correo" >Correo</label> 
		<input type="text" name="correo" /> 
		
		<label for="password">Password</label>
		<input type="password" name="password" />

		<input type="submit">
	</form>

</body>
</html>