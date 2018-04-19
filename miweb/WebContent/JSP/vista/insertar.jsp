<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="../controlador/conectorinserta.jsp" method="post">

		<input type="text" name="dni" id="dni" placeholder="Introduce dni" required>
		<br>
		<br>
		<input type="date" name="fecha_nacimiento" id="fecha_nacimiento" required>
		<br>
		<br>
		<input type="text" name="nombre" id="nombre" placeholder="Introduce nombre" required>
		<br>
		<br>
		
		<input type="submit" id="insertar" value="Insertar">
		
</form>

</body>
</html>