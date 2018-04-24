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
	String dni;
	String nota;
	
	
	int len = Integer.parseInt(request.getParameter("length"));
	
	
	//Mientras encuentres dnis, es porque hay filas en la tabla
	for(int i=0; i<len-1; i++)
	{
		String getdni = "dni"+i;
		String getnota = "nota"+i;
		
		//Sacamos los datos de la fila i
		dni = request.getParameter(getdni);
		nota = request.getParameter(getnota);
		
		System.out.println("Usuario "+dni+"   nota"+nota);
		
		
		if(nota.equals("No_presentado"))
		{
		    // No hacer nada porque no se quiere calificar ni modificar su calificacion, ni siquiera tendra inserccion en la
		    // tabla evaluaciones
		}
		else
		{
			//Creamos un alumno vacio
			alumno aux = new alumno();
			
			aux.setdni(dni);
			
			//Creamos un objeto alumno
			evaluacion eva = new evaluacion();
			
			//Hacemos el casting para pasar la nota de string a int
			int not = Integer.parseInt(nota);
			
	    	//Cargamos los datos de la evalucion de cada asignatura
	    	eva.setnota(not);
	    	
	    	//Y las añadimos al arraylist de alumno
	    	aux.notas.add(eva);	
	    	
	    	//Añadimos este alumno a el arraylist de solucion
	    	recogido.add(aux);
		}
		
		//Consultar la sesion para obtener el username del usuario
	    HttpSession sesion = request.getSession();    
	    String user = ""+sesion.getAttribute("username");
	    
	    //Generamos un conector de profesor
		conector_profesor co = new conector_profesor();
	    
		co.modificarCalificaciones(user, recogido);
		
	}
	
	//mostrar datos


%>


</body>
</html>