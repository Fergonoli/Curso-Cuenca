<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="0.01; URL=../vista/insertar.jsp">
<title>Insert title here</title>
</head>
<body>


  <%@ page import = "conectores.conector_alumno" %>
  <%
      //Recoger los datos del alumno a ingresar
      String nombre = request.getParameter("nombre");
	  String dni = request.getParameter("dni");
	  String fecha_nacimiento = request.getParameter("fecha_nacimiento");
      
	  //Creamos un objeto conector para alumnos
	  conector_alumno conect = new conector_alumno();
	  
	  //Hacemos la insercion
	  conect.insert(nombre, dni, fecha_nacimiento);
    
  %>


</body>
</html>