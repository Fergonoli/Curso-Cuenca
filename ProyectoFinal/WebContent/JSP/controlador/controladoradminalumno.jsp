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
	//Variables para extraccion
	int id;
	
	String username;
	String password;
	
	String nombre;
	String apellido1;
	String apellido2;
	String fecha;
	String dni;
	String telefono;

	String check;
	
	
	int len = Integer.parseInt(request.getParameter("length"));
	
	
	
	
	//Mientras encuentres dnis, es porque hay filas en la tabla
	for(int i=0; i<len; i++)
	{
		
		String getid = "id"+i;
		
		String getusername = "username"+i;
		String getpassword = "password"+i;
		
		String getnombre = "nombre"+i;
		String getapellido1 = "apellido1"+i;
		String getapellido2 = "apellido2"+i;
		String getfecha = "fecha"+i;
		String getdni = "dni"+i;
		String gettelefono = "telefono"+i;
		
	
		String auxid = request.getParameter(getid);
		id = Integer.parseInt(auxid);
		
		//PAra comprobar si se borra o se modifica
		String getcheck = "delete"+i;
		
		check = request.getParameter(getcheck);

		//Hacer el if de los check para decidir si se borra o se actualiza		
		if(check != null)
		{
		    //Generamos un conector de alumno
			conector_alumno co = new conector_alumno();
		    
			co.borrarFila(id);	
		}
		else
		{
			//Sacamos los datos de la fila i
			username = request.getParameter(getusername);
			password = request.getParameter(getpassword);
			nombre = request.getParameter(getnombre);
			apellido1 = request.getParameter(getapellido1);
			apellido2 = request.getParameter(getapellido2);	
			fecha= request.getParameter(getfecha);	
			telefono = request.getParameter(gettelefono);
			dni = request.getParameter(getdni);
			
			//Creamos un alumno vacio
			alumno aux = new alumno();
			
			aux.setid(id);
			aux.setdni(dni);
			aux.setusername(username);
			aux.setpassword(password);
			aux.setnombre(nombre);
			aux.setapellido1(apellido1);
			aux.setapellido2(apellido2);
			aux.setfecha(fecha);

			int auxtel = Integer.parseInt(telefono);
			aux.settelefono(auxtel);
			
		    //Update filas
		    //Generamos un conector de alumno
			conector_alumno co = new conector_alumno();
		    
			co.updatealumno(aux);   
		}
	}

	//Ver si a�ades un nuevo alumno
	
	//Sacamos los datos de la fila i
	username = request.getParameter("usernamen");
	password = request.getParameter("passwordn");
	nombre = request.getParameter("nombren");
	apellido1 = request.getParameter("apellido1n");
	apellido2 = request.getParameter("apellido2n");	
	fecha= request.getParameter("fechan");	
	telefono = request.getParameter("telefonon");
	dni = request.getParameter("dnin");
	
	String n = "";
	
	if(! (dni.equals(n) && username.equals(n) && password.equals(n)))
	{
		//Creamos un alumno vacio
		alumno aux = new alumno();
	
		aux.setdni(dni);
		aux.setusername(username);
		aux.setpassword(password);
		aux.setnombre(nombre);
		aux.setapellido1(apellido1);
		aux.setapellido2(apellido2);
		aux.setfecha(fecha);
	
		if(!telefono.equals(n))
		{
			int auxtel = Integer.parseInt(telefono);
			aux.settelefono(auxtel);
		}
		else
		{
			aux.settelefono(0);
		}

	    //Update filas
	    //Generamos un conector de alumno
		conector_alumno co = new conector_alumno();
			    
		co.insertalumno(aux); 
	}
	
	
	response.sendRedirect(url.vista+"adminalumnos.jsp");


%>


</body>
</html>