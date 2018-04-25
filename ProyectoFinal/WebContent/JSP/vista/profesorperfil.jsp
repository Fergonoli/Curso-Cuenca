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


  <%@ page import="java.util.*" %>
  <%@ page import="java.sql.*" %>
  <%@ page import="javax.swing.*" %>  
  <%@ page import="conectores.*" %>
  <%@ page import="academia.*" %>



<h1>Perfil de profesor</h1>

<% 
	//Crear un objeto conector usuario
	conector_profesor co = new conector_profesor();
	
	//Consultar la sesion para obtener el username del usuario
    HttpSession sesion = request.getSession();    
    String user = ""+sesion.getAttribute("username");

    //Hacerle la consulta al conector usuario para que te devuelva el perfil
	profesor prof = co.devolverPerfil(user);
	
%>


<form action="<%=url.controlador%>controladorprofesor.jsp" method="post">

	Nombre <input type="text" name="nombre" id="nombre" value="<%=prof.getnombre()%>" required>
	<br>
	
	Apellido 1<input type="text" name="apellido1" id="apellido1" value="<%=prof.getapellido1()%>" required>
	<br>

	Apellido 2<input type="text" name="apellido2" id="apellido2" value="<%=prof.getapellido2()%>" required>
	<br>
	
	Despacho<input type="text" name="despacho" id="despacho" value="<%=prof.getdespacho()%>" required>
	<br>
	
	Especialidad<input type="text" name="especialidad" id="especialidad" value="<%=prof.getespecilidad()%>" required>
	<br>
	
	Telefono <input type="number" name="telefono" id="telefono" value="<%=prof.gettelefono()%>" required>
	<br>
	<br>

	<br>
	<br>
	
	
	<!-- El tipo de button debe ser un submit, para que al clickear los datos
	     de los inputs de arriba se tomen correctamente -->
	<input type="submit" id="modificar" value="Modificar">

</form>

	<a href="cambioUsername.jsp">Cambiar username</a></li>   
	<br>
	<a href="cambioPassword.jsp">Cambiar password</a></li>   

</body>
</html>