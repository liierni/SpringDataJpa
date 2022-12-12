<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel de RRHH</title>
</head>
<body>

	${mensaje}
	${mensajeAlta}
	${mensajeBaja}
	${mensajeEditar}
	
	<h3>Bienvenido ${usuarioLogeado.nombre}</h3>
	
	<p><a href="/empleado/alta">Alta empleado</a></p>
	<p><a href="/empleado/lista">Editar empleados</a></p>
	<p><a href="/cerrarSesion">Salir</a></p>

</body>
</html>