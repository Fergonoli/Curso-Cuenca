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


	String nombre = request.getParameter("nombre");	
	String apellido1 = request.getParameter("apellido1");
	String apellido2 = request.getParameter("apellido2");
	String despacho = request.getParameter("despacho");
	String especialidad = request.getParameter("especialidad");
	String telefono = request.getParameter("telefono");

	
	
	//mostrar datos
	System.out.println(nombre);
	System.out.println(apellido1);
	System.out.println(apellido2);
	System.out.println(despacho);
	System.out.println(especialidad);
	System.out.println(telefono);
	
	
	
	//Crear un objeto conector profesor
	conector_profesor co = new conector_profesor();
	
	//Consultar la sesion para obtener el username del usuario
    HttpSession sesion = request.getSession();    
    String user = ""+sesion.getAttribute("username");


	//Hacer el update
	co.updateprofesor(nombre, apellido1, apellido2, despacho, especialidad, telefono, user);
	
	JOptionPane.showMessageDialog(frame, "Cambios realizados con exito");
	
	response.sendRedirect(url.vista+"inicioprofesor.jsp");
						
%>


</body>
</html>