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
	
	//Creamos un arralist de alumnos para la recogida de datos de la tabla
	ArrayList<alumno> recogido = new ArrayList<alumno>();

	
	//Variables para extraccion
	int id;
	
	String username;
	String password;
	
	String nombre;
	String apellido1;
	String apellido2;
	Date fecha = new Date();
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
		
		id = Integer.parseInt(request.getParameter(getid));
		
		//PAra comprobar si se borra o se modifica
		String getcheck = "check"+i;
		
		check = request.getParameter(getusername);
		
		//Hacer el if de los check para decidir si se borra o se actualiza
		
		//Sacamos los datos de la fila i
		username = request.getParameter(getusername);
		password = request.getParameter(getpassword);
		nombre = request.getParameter(getnombre);
		apellido1 = request.getParameter(getapellido1);
		apellido2 = request.getParameter(getapellido2);
		
		
		fecha.parse(request.getParameter(getfecha));
		
		
		telefono = request.getParameter(gettelefono);
		dni = request.getParameter(getdni);
		
		//Creamos un alumno vacio
		alumno aux = new alumno();
			
		aux.setdni(dni);
		aux.setusername(username);
		aux.setpassword(password);
		aux.setnombre(nombre);
		aux.setapellido1(apellido1);
		aux.setapellido2(apellido2);
		aux.setfecha(fecha);
		aux.settelefono(Integer.parseInt(telefono));
		

	    //Añadimos este alumno a el arraylist de solucion
	    recogido.add(aux);

	}
	
	//Consultar la sesion para obtener el username del usuario
    HttpSession sesion = request.getSession();    
    String user = ""+sesion.getAttribute("username");
    
    //Generamos un conector de profesor
	conector_profesor co = new conector_profesor();
    
	co.modificarCalificaciones(user, recogido);
	
	
	response.sendRedirect(url.vista+"profesorcalificaciones.jsp");


%>


</body>
</html>