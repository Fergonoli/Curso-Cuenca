<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Importar la clase de fechas  -->
<%@ page import="java.util.Date" %>

<!-- Importar una clase propia del proyecto  -->
<%@ page import="usuarios.profesor" %>




<!-- Definir una variable global  -->
<%! int cuentaGlobal =0; %>

<!-- incrementar cuenta  -->
<% cuentaGlobal++; %>

<!-- Recogemos los datos del index.jsp con los request, es importante que el nombre
     de los identificadores de las variables en index, sean los mismos que los que buscamos 
     en el metodo request.getParameter()   -->
<%

	String nombre = request.getParameter("nombre");
	String password = request.getParameter("password");
	
	
	String sexo = request.getParameter("sexo");
	
	String matematicas = request.getParameter("matematicas");
	String lenguaje = request.getParameter("lenguaje");
	String ingles = request.getParameter("ingles");
	String informatica = request.getParameter("informatica");

%>

<!-- Crear un objeto de tipo profesor -->
<% 
	profesor teacher = new profesor();

	teacher.setasignatura("matematicas");
	teacher.setnombre(nombre);

%>

<!-- Llamar a los metodos del profesor -->
<p> profesor asignatura: <%= teacher.getasignatura() %> </p><br>
<p> profesor nombre: <%= teacher.getnombre() %> </p><br>

<!-- comentar esto bien -->

<p> Elegiste las asignaturas: <br> 
	<% if ( matematicas != null ) { %>
	       matematicas
    <% }%>
    
<% if (lenguaje != null) {%> lenguaje <% }%>
<% if (ingles != null) {%> ingles <% }%>
<% if (informatica != null) {%> informatica <% }%>

</p>

<!-- NOTA IMPORTANTE: fijate que para mostrar las variables se pone en la parte delantera
                      un = despues del % -->
<p> nombre: <%= nombre %> </p>

<p> password: <%= password %> </p>

<p> Sexo: <%= sexo %> </p>



<!-- Como acceder a las variables que se han creado arriba de fecha y accesos -->
<p> Acceso el dia: <%=new Date() %> </p>

<p> Acceso hechos: <%=cuentaGlobal %> </p>



<a href="calculadora.jsp">Ir a la calculadora</a>



</body>
</html>