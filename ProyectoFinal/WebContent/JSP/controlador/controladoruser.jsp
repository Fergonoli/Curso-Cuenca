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
 
 
 
 <% 
 
	///borrar cuando arreglo
	//Para los cuadros de dialogo
 	JFrame frame = new JFrame("Circunferencia");	

	frame.setAlwaysOnTop( true );


	
	String newuser = request.getParameter("newuser");
 
    String olduser = ""+session.getAttribute("username");
 
	
 	
 	//Este cambio se hace sobre la tabla usuario
 	conector_usuario con = new conector_usuario();
 	
 	
 	try {
	    		boolean condicion = con.comprobarusername(newuser);
	    		
	        	//Se comprueba que el username no existe
	        	if(condicion)
	        	{
	        		//Hacer el update para el username
	        		con.updateusername(olduser, newuser);
	        		
	        		
	        		JOptionPane.showMessageDialog(frame, "Cambio de username correcto, vuelta a inicio para iniciar sesion con nuevas credenciales ");
	        		
	        		response.sendRedirect(url.vista+"index.jsp");
	        		
	        	}	
	        	else
	        	{
	        		JOptionPane.showMessageDialog(frame, "Username ya utilizado ");
	        		
	        		response.sendRedirect(url.vista+"cambioUsername.jsp");
	        	}
 		
 		} catch(ClassNotFoundException exception) {  System.out.println(" Error de índice en un array"); }
 	
 	
%>

</body>
</html>