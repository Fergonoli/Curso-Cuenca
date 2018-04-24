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

</head>
<body>


  <%@ page import = "conectores.conector_usuario" %>
  <%@ page import = "academia.usuario" %>

	
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
	
	usuario user = conect.delvolverUsuario(nombre);
	
	if(user == null) {
		
		//No darle acceso
		JOptionPane.showMessageDialog(frame, "ACCESO DENEGADO ");
		
		response.sendRedirect(url.vista+"index.jsp");
	}
	else
	{
		
		String passwordbbdd = user.getpassword();
		
		//Comprobar si el usuario existe, mirando el resultado de password
		
		if(passwordteclado.equals(passwordbbdd))
		{
			
			String tipo = user.gettipo().toString();
	
			
			//Datos de sesion
            HttpSession sesion = request.getSession();  
            sesion.setAttribute("username", user.getusername());
            sesion.setAttribute("tipo", user.gettipo());
                       
			
			if(tipo.equals("alumno"))
			{
				response.sendRedirect(url.vista+"inicioalumno.jsp");
			}
			else
			{
				if(tipo.equals("profesor"))
				{
					response.sendRedirect(url.vista+"inicioprofesor.jsp");
				}
				else
				{
					if(tipo.equals("administrador"))
					{
						response.sendRedirect(url.vista+"saludoAdministrador.jsp");
					}
				}
			}          
		}
		else
		{
			//No darle acceso
			JOptionPane.showMessageDialog(frame, "ACCESO DENEGADO ");
			
			response.sendRedirect(url.vista+"login.jsp");
		}
	}
	
%>
</body>
</html>