<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


  <%@ page import = "conectores.conector_usuario" %>

	
  <%@ page import="java.util.*" %>
  <%@ page import="javax.swing.*" %>
	 

<%

	///borrar cuando arreglo
	//Para los cuadros de dialogo
    JFrame frame = new JFrame("Circunferencia");	

	frame.setAlwaysOnTop( true );


	String nombre = request.getParameter("nombre");
	String passwordteclado = request.getParameter("password");
	
	conector_usuario conect = new conector_usuario();
	
	String passwordbbdd = conect.delvolverPass(nombre);
	
	//Comprobar si el usuario existe, mirando el resultado de password
	
	if(passwordteclado.equals(passwordbbdd))
	{
		//Darle acceso
		JOptionPane.showMessageDialog(frame, "ACCESO PERMITIDO ");
		
		response.sendRedirect("../vista/calculadora.jsp");
	}
	else
	{
		//No darle acceso
		JOptionPane.showMessageDialog(frame, "ACCESO DENEGADO ");
		
		response.sendRedirect("../vista/login.jsp");
	}
	
%>



</body>
</html>