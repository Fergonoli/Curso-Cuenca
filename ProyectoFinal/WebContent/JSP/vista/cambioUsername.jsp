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

  <%@ page import = "conectores.*" %>
  <%@ page import = "academia.*" %>


  <%@ page import="java.util.*" %>
  <%@ page import="javax.swing.*" %>  
 
 
 
 	<form action="<%=url.controlador%>controladoruser.jsp" method="post">
	
		<input type="text" name="newuser" id="newuser" placeholder="Introduce nuevo Username" required>
	
	
	<br>
	<br>
	
	<!-- El tipo de button debe ser un submit, para que al clickear los datos
	     de los inputs de arriba se tomen correctamente -->
	<input type="submit" id="cambiouser" value="Cambiar">

</form>
</body>
</html>