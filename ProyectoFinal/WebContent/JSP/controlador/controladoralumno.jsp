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
	String fecha_nacimiento = request.getParameter("fecha");
	String dni = request.getParameter("dni");
	String telefono = request.getParameter("telefono");
	
	//Atributos como usuario
	String username = request.getParameter("username");
	
	String passwordact = request.getParameter("passwordact");
	String passwordnue = request.getParameter("passwordnue");
	String passwordrep = request.getParameter("passwordrep");
	
	String che = request.getParameter("cambio");
	
	
	//mostrar datos
	System.out.println(nombre);
	System.out.println(apellido1);
	System.out.println(apellido2);
	System.out.println(fecha_nacimiento);
	System.out.println(dni);
	System.out.println(telefono);
	
	
	
	//Crear un objeto conector usuario
	conector_alumno co = new conector_alumno();
	
	//Consultar la sesion para obtener el username del usuario
    HttpSession sesion = request.getSession();    
    String user = ""+sesion.getAttribute("username");

    boolean condicion = co.comprobardni(dni, user);
    
	System.out.println("La condicion valdra "+condicion);
	
    
    //Comprobar que el dni nuevo es unico
	if(condicion)
	{

		//Hacer el update
		co.updatealumno(nombre, apellido1, apellido2, fecha_nacimiento, dni, telefono, user);
		
		JOptionPane.showMessageDialog(frame, "Cambios realizados con exito");
		
		response.sendRedirect(url.vista+"inicioalumno.jsp");
						
	}
	else
	{
		JOptionPane.showMessageDialog(frame, "Ese dni ya existe");
		response.sendRedirect(url.vista+"alumnoperfil.jsp");	
	}

%>


</body>
</html>