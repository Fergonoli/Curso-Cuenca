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



<h1>Perfil de alumno</h1>

<% 
	//Crear un objeto conector usuario
	conector_alumno co = new conector_alumno();
	
	//Consultar la sesion para obtener el username del usuario
    HttpSession sesion = request.getSession();    
    String user = ""+sesion.getAttribute("username");

    //Hacerle la consulta al conector usuario para que te devuelva el perfil
	alumno alum = co.devolverPerfil(user);
	
%>


<form action="<%=url.controlador%>controladoralumno.jsp" method="post">

	Nombre <input type="text" name="nombre" id="nombre" value="<%=alum.getnombre()%>" required>
	<br>
	
	Apellido 1<input type="text" name="apellido1" id="apellido1" value="<%=alum.getapellido1()%>" required>
	<br>

	Apellido 2<input type="text" name="apellido2" id="apellido2" value="<%=alum.getapellido2()%>" required>
	<br>
	
	Dni<input type="text" name="dni" id="dni" value="<%=alum.getdni()%>" required>
	<br>
	
	Fecha de nacimiento<input type="date" name="fecha" id="fecha" value="<%=alum.getfecha()%>" required>
	<br>
	
	Telefono <input type="number" name="telefono" id="telefono" value="<%=alum.gettelefono()%>" required>
	<br>
	<br>

	<br>
	<br>
	
	
	<!-- El tipo de button debe ser un submit, para que al clickear los datos
	     de los inputs de arriba se tomen correctamente -->
	<input type="submit" id="modificar" value="Modificar">

</form>

	<input type="button" name="username" id="usenamer" value="Cambiar Username" onclick="cambiousername(<%=user%>)">
	<br>	

	<input type="button" name="password" id="password" value="Cambiar password" onclick="cambicontrasena(<%=user%>)">



 <SCRIPT LANGUAGE="JavaScript">

 	function cambiousername(String user) {
     
 	JFrame frame = new JFrame("username");
	
		frame.setAlwaysOnTop( true );
	
		String username;
	
 	String us = JOptionPane.showInputDialog(frame, "Username nuevo:");
 	username = us;	 
 	
 	//Este cambio se hace sobre la tabla usuario
 	conector_usuario con = new conector_usuario();
 	
 	
 	try {
	    		boolean condicion = con.comprobarusername(us);
	    		
	        	//Se comprueba que el username no existe
	        	if(condicion)
	        	{
	        		//Hacer el update para el username
	        		con.updateusername(user, username);
	        	}		
 		
 		} catch (SQLException exception) {  System.out.println(" Error de índice en un array");  } 
 	      catch(ClassNotFoundException exception) {  System.out.println(" Error de índice en un array"); }

 	
 }

	function cambicontrasena(String user) {
		
 	JFrame frame = new JFrame("password");
 	
		frame.setAlwaysOnTop( true );
	
		String passwordact;
		String passwordnue;
	
 	String pass = JOptionPane.showInputDialog(frame, "Contraseña actual:");
 	passwordact = pass;
 	
 	
 	pass = JOptionPane.showInputDialog(frame, "Contraseña nueva:");
 	passwordnue = pass;
		
 	
 	//Este cambio se hace sobre la tabla usuario
 	conector_usuario con = new conector_usuario();
 	
 	
 	try {
	    		boolean condicion = con.comprobarpassword(user, passwordact);
	    		
	        	//Se comprueba que el username no existe
	        	if(condicion)
	        	{
	        		//Cambiar la contraseña
	        		con.updatepassword(passwordnue, user);        		
	        		
	        	}		
 		
 		} catch (SQLException exception) {  System.out.println(" Error de índice en un array");  } 
 	      catch(ClassNotFoundException exception) {  System.out.println(" Error de índice en un array"); }


 	
	}
 </SCRIPT>




</body>
</html>