<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "conectores.url_manager" %>
 
 <%  
 	//Creamos un objeto url_manager que contiene las urls de todos los elementos necesarios, vista, controlador, css y clases
 	url_manager url = new url_manager();
 
 %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href=<%=url.css%>>
</head>
<body>
<h1> Bienvenido a tu academia <%= session.getAttribute("username") %></h1>

	<!--  contenido debajo del header  -->
	<nav>
		
		<ul>

			<!--  text-decoration= "none" -->

			<li class="botonactivo"><a href="profesorcalificaciones.jsp" class="nounderline">Calificaciones</a></li>
			<br>  
			<li class="botonactivo"><a href="profesormenores.jsp" class="nounderline">Menores de edad</a></li>   
			<br>
			<li class="botonactivo"><a href="profesorperfil.jsp"  class="nounderline">Perfil</a></li>     
			<br>

	    </ul>
	
	</nav>

</body>
</html>