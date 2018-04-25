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
  

<h1> Administacion </h1>

	<!--  contenido debajo del header  -->
	<nav>
		
		<ul>

			<!--  text-decoration= "none" -->

			<li class="botonactivo"><a href="adminalumnos.jsp" class="nounderline">Alumnos</a></li>
			<br>  
			<li class="botonactivo"><a href="adminprofesores.jsp" class="nounderline">Profesores</a></li>   
			<br>
			<li class="botonactivo"><a href="adminasignaturas.jsp"  class="nounderline">Asignaturas</a></li>     
			<br>
			<li class="botonactivo"><a href="adminmatriculas.jsp" class="nounderline">Matriculas</a></li>
			<br>  
			<li class="botonactivo"><a href="adminevaluaciones.jsp" class="nounderline">Evaluaciones</a></li>   
			<br>

	    </ul>
	
	</nav>

<% 
	//Crear un objeto conector usuario
	conector_alumno co = new conector_alumno();

	//Creamos un arralist de alumnos para la devolucion
	ArrayList<alumno> tabla = new ArrayList<alumno>();
    
    //Hacerle la consulta al conector usuario para que te devuelva el expediente
	tabla = co.devolverTodos();
%>

      <form method="get" action="<%=url.controlador %>controladoradminalumno.jsp" method="post">
        <table border=1 cellpadding=5>
          <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Dni</th>
            <th>Fecha de nacimiento</th>
            <th>Nombre</th>
            <th>Apellido 1</th>
            <th>Apellido 2</th>   
            <th>¿Borrar fila?</th>         
          </tr>
          <tr>
          <!-- con el metodo getString("Nombre de atributo") sacas el valor de cada celda  -->           
            <%
            
            int lentgh = 0;
            
            for(int i=0; i<tabla.size(); i++){ lentgh++; %>
            <tr>
            	<td><input type='text' name=<%="id"+i%> value=<%= tabla.get(i).getid() %> disabled></td>
           		<td><input type='text' name=<%="username"+i%> value=<%= tabla.get(i).getusername() %>></td>
            	<td><input type='text' name=<%="password"+i%> value=<%= tabla.get(i).getpassword() %>></td>
            	<td><input type='text' name=<%="dni"+i%> value=<%= tabla.get(i).getdni() %>></td>
            	<td><input type='date' name=<%="fecha"+i%> value=<%= tabla.get(i).getfecha() %>></td>
            	<td><input type='text' name=<%="nombre"+i%> value=<%= tabla.get(i).getnombre() %>></td>
               	<td><input type='text' name=<%="apellido1"+i%> value=<%= tabla.get(i).getapellido1() %>></td>
            	<td><input type='text' name=<%="apellido2"+i%> value=<%= tabla.get(i).getapellido2() %>></td>
            	<td><input type='checkbox' name=<%="delete"+i%> value="borrar"></td>
            	</tr>	
      <% }%>

          </tr>   
        </table>
        
        	<input type="number" name="length" id="lenght" value=<%= lentgh %> hidden>
                
        	<input type="submit" id="modificar" value="Modificar">
            
   </form>
   
   
   <a href="adminaddalumno.jsp">Añadir nuevo alumno</a></li>   
</body>
</html>