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
  <%@ page import="javax.swing.*" %>  
  <%@ page import="conectores.*" %>
  <%@ page import="academia.*" %>




<h1>Matricula</h1>

		<ul>

			<!--  text-decoration= "none" -->

			<li class="botonactivo"><a href="alumnomatricula.jsp" class="nounderline">Matricula</a></li>
			<br>  
			<li class="botonactivo"><a href="alumnonotas.jsp" class="nounderline">Notas</a></li>   
			<br>
			<li class="botonactivo"><a href="alumnoperfil.jsp"  class="nounderline">Perfil</a></li>     
			<br>

	    </ul>







<% 
	//Crear un objeto conector usuario
	conector_alumno co = new conector_alumno();
	
	//Consultar la sesion para obtener el username del usuario
    HttpSession sesion = request.getSession();    
    String user = ""+sesion.getAttribute("username");

    //Hacerle la consulta al conector usuario para que te devuelva el expediente
	alumno alum = co.devolverExpediente(user);
%>



      <form method="get" action="order.jsp">
        <table border=1 cellpadding=5>
          <tr>
            <th>Asignatura</th>
          </tr>
          <tr>
            
            
            <!-- con el metodo getString("Nombre de atributo") sacas el valor de cada celda  -->           
            <% for(int i=0; i<alum.notas.size(); i++){ %>
           		<td><%= alum.notas.get(i).getasignatura() %></td>
          </tr>

      <% }%>
          </tr>
          
        </table>
      </form>
</body>
</html>