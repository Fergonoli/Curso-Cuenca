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
	//para los select de asignaturas
	//Crear un objeto conector asignatura
	conector_asignatura co = new conector_asignatura();

	//Creamos un arralist de alumnos para la devolucion
	ArrayList<asignatura> tablaasig = new ArrayList<asignatura>();
    
    //Hacerle la consulta al conector usuario para que te devuelva el expediente
	tablaasig = co.devolverTodos();
    
    
    //para los select de alumnos
	conector_alumno con = new conector_alumno();

	//Creamos un arralist de alumnos para la devolucion
	ArrayList<alumno> tablaalu = new ArrayList<alumno>();
    
    //Hacerle la consulta al conector usuario para que te devuelva el expediente
	tablaalu = con.devolverTodos();
    
    //La tabla para mostar las matricular
	conector_matricula cone = new conector_matricula();

	//Creamos un arralist de alumnos para la devolucion
	ArrayList<matricula> tabla = new ArrayList<matricula>();
    
    //Hacerle la consulta al conector usuario para que te devuelva el expediente
	tabla = cone.devolverTodos();
        
%>

      <form method="get" action="<%=url.controlador %>controladoradminmatriculas.jsp" method="post">
        <table border=1 cellpadding=5>
          <tr>
            <th>ID</th>
            <th>IDALUMNO</th>
            <th>IDASIGNATURA</th>
            <th>Nombre Alumno</th>
			<th>Nombre Asignatura</th>
            <th>¿Borrar fila?</th>         
          </tr>
          <!-- con el metodo getString("Nombre de atributo") sacas el valor de cada celda  -->           
            <%
            
            int lentgh = 0;
            
            for(int i=0; i<tabla.size(); i++){ lentgh++; %>
            <tr>
            
            <td><input type='text' name=<%="id"+i%> value=<%= tabla.get(i).getid() %> readonly></td>
            <td><input type='text' name=<%="idalumno"+i%> value=<%= tabla.get(i).getidalumno() %> readonly></td>
            <td><input type='text' name=<%="idasignatura"+i%> value=<%= tabla.get(i).getidasignatura() %> readonly></td>
            
            <td>
					<select type='text' name=<%="nombrealumno"+i%>  >
					
					  <% for(int j=0; j<tablaalu.size();j++){ %>
					  
					  <option value=<%= tablaalu.get(j).getnombre() %>
					  <%= tablaalu.get(j).getnombre() %> 
					  <%if( tablaalu.get(j).getnombre().equals(tabla.get(i).getnombrealumno())){
						%> <%= "selected"%> 
					  <%} 
		  
					  %>> <%= tablaalu.get(j).getnombre() %> </option>

					  <%} %>
					  
					</select>
            	
            	
            	</td>
            	<td>
					<select type='text' name=<%="nombrealumno"+i%>  >
					
					  <% for(int j=0; j<tablaasig.size();j++){ %>
					  
					  <option value=<%= tablaasig.get(j).getnombre() %>
					  <%= tablaasig.get(j).getnombre() %> 
					  <%if( tablaasig.get(j).getnombre().equals(tabla.get(i).getnombreasignatura())){
						%> <%= "selected"%> 
					  <%} 
		  
					  %>> <%= tablaasig.get(j).getnombre() %> </option>

					  <%} %>
					  
					</select>
            	
            	
            	</td>
            	
            	<td><input type='checkbox' name=<%="delete"+i%>></td>
            </tr>	
      <% }%>

            <tr>
            
                <td><input type='text' name=<%="idn"%> placeholder="Añadir nuevo" readonly></td>
                <td><input type='text' name=<%="idalumnon"%> placeholder="Añadir nuevo" readonly></td>
                <td><input type='text' name=<%="idasignaturan"%> placeholder="Añadir nuevo" readonly></td>
            
            
                <td>
					<select type='text' name="nombreasignaturan" >
					  <option value="Añadir nuevo">
					  <% for(int j=0; j<tablaalu.size();j++){ %>
					  
					  <option value=<%= tablaalu.get(j).getnombre() %>
					  <%= tablaalu.get(j).getnombre() %>> <%= tablaalu.get(j).getnombre() %> </option>

					  <%} %>
					  
					</select>
            	
            	
            	</td>
            	<td>
					<select type='text' name="nombrealumnon"  >
					  <option value="Añadir nuevo">
					  <% for(int j=0; j<tablaasig.size();j++){ %>
					  
					  <option value=<%= tablaasig.get(j).getnombre() %>> <%= tablaasig.get(j).getnombre() %> </option>

					  <%} %>
					  
					</select>	
   				</td>
   			</tr>
        </table>
        
        	<input type="number" name="length" id="lenght" value=<%= lentgh %> hidden>
                
        	<input type="submit" id="modificar" value="Modificar">
            
   </form>
    
</body>
</html>