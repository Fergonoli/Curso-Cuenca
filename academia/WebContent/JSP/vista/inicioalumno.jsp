<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/estilo.css"/>
</head>
<body>
<h1> Bienvenido a tu academia <%= session.getAttribute("username") %></h1>

	<!--  contenido debajo del header  -->
	<nav>
		
		<ul>

			<!--  text-decoration= "none" -->

			<li class="botonactivo"><a href="alumnomatricula.jsp" class="nounderline">Matricula</a></li>
			<br>  
			<li class="botonactivo"><a href="alumnonotas.jsp" class="nounderline">Notas</a></li>   
			<br>
			<li class="botonactivo"><a href="alumnoperfil.jsp"  class="nounderline">Perfil</a></li>     
			<br>

	    </ul>
	
	</nav>

</body>
</html>