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
	String especialidad;
	String despacho;
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
		String getespecialidad = "especialidad"+i;
		String getdespacho = "despacho"+i;
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
			conector_profesor co = new conector_profesor();
		    
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
			despacho= request.getParameter(getdespacho);	
			telefono = request.getParameter(gettelefono);
			especialidad = request.getParameter(getespecialidad);
			
			//Creamos un alumno vacio
			profesor aux = new profesor();
			
			aux.setid(id);
			aux.setespecialidad(especialidad);
			aux.setusername(username);
			aux.setpassword(password);
			aux.setnombre(nombre);
			aux.setapellido1(apellido1);
			aux.setapellido2(apellido2);
			aux.setdespacho(despacho);

			int auxtel = Integer.parseInt(telefono);
			aux.settelefono(auxtel);
			
		    //Update filas
		    //Generamos un conector de alumno
			conector_profesor co = new conector_profesor();
		    
			co.updateprofesor(aux);   
		}
	}

	//Ver si añades un nuevo alumno
	
	//Sacamos los datos de la fila i
	username = request.getParameter("usernamen");
	password = request.getParameter("passwordn");
	nombre = request.getParameter("nombren");
	apellido1 = request.getParameter("apellido1n");
	apellido2 = request.getParameter("apellido2n");	
	despacho= request.getParameter("despachon");	
	telefono = request.getParameter("telefonon");
	especialidad = request.getParameter("especialidadn");
	
	String n = "";
	
	if(! ( username.equals(n) && password.equals(n)))
	{
		//Creamos un alumno vacio
		profesor aux = new profesor();
	
		aux.setdespacho(despacho);
		aux.setusername(username);
		aux.setpassword(password);
		aux.setnombre(nombre);
		aux.setapellido1(apellido1);
		aux.setapellido2(apellido2);
		aux.setespecialidad(especialidad);
	
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
		conector_profesor co = new conector_profesor();
			    
		co.insertaprofesor(aux); 
	}
	
	
	response.sendRedirect(url.vista+"adminprofesores.jsp");


%>


</body>
</html>