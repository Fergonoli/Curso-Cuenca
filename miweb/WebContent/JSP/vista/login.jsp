<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="../controlador/conectorlogin.jsp" method="post">

	<input type="text" name="nombre" id="nombre" placeholder="Introduce usuario" required>
	
	<br>
	<br>
	
	<input type="password" name="password" id="password" placeholder="Introduce password" required>
	
	
	<br>
	<br>
	
	<!-- El tipo de button debe ser un submit, para que al clickear los datos
	     de los inputs de arriba se tomen correctamente -->
	<input type="submit" id="login" value="Acceder">

</form>


</body>
</html>