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
	
	
<% 
	
	conector_profesor co = new conector_profesor();
	
    HttpSession sesion = request.getSession();  

    String user = ""+sesion.getAttribute("username");

	//Creamos un arralist de alumnos para la devolucion
	ArrayList<alumno> res = new ArrayList<alumno>();
    
	res = co.devolverCalificaciones(user);
	

%>

      <form method="get" action="<%=url.controlador %>controladorcalificaciones.jsp" method="post">
        <table border=1 cellpadding=5>
          <tr>
            <th>Nombre de alumno</th>
            <th>Apellido 1</th>
            <th>Apellido 2</th>
            <th>Dni</th>
            <th>Nota</th>
          </tr>
          <tr>
            
            
            <!-- con el metodo getString("Nombre de atributo") sacas el valor de cada celda  -->           
            <%
            
            int lentgh = 0;
            
            for(int i=0; i<res.size(); i++){ lentgh++; %>
           		<td><input type='text' name=<%="nombre"+i%> value=<%= res.get(i).getnombre() %> disabled></td>
           		<td><input type='text' name=<%="apellido1"+i%> value=<%= res.get(i).getapellido1() %> disabled></td>
           		<td><input type='text' name=<%="apellido2"+i%> value=<%= res.get(i).getapellido2() %> disabled></td>
           		<td><input type='text' name=<%="dni"+i%> value=<%= res.get(i).getdni() %> readonly></td>
           		
           		<td><input type='text' name=<%="nota"+i%> value=<% if(res.get(i).notas.get(0).getnota()==0)
           			   { %>
           				<%="No_presentado"   %>
           			 <%}
           		       else
           			   {%>
           				<%=res.get(i).notas.get(0).getnota()%>        				
           			 <%}%>
           			></td>
          </tr>

      <% }    
      %>
          </tr>
          
        </table>
        
        <br>
        <br>
        
        <input type="number" name="length" id="lenght" value=<%= lentgh %> hidden>
        
        <input type="submit" id="modificar" value="Modificar">
        
      </form>
	

</body>
</html>