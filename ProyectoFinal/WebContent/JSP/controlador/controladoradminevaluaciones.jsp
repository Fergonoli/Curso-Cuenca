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
	
	//Variables foraneas
	int idmatricula;
	int idprofesor;
	
	int nota;

	String nombreprofesor;

	String check;
	
	
	int len = Integer.parseInt(request.getParameter("length"));

	
	for(int i=0; i<len; i++)
	{
		
		String getid = "id"+i;
		
		String getidmatricula = "idmatricula"+i;
		String getidprofesor = "idprofesor"+i;
		
		String getnota = "nota"+i;
		
		String getnombreprofesor = "profesor"+i;
		
	
		String auxid = request.getParameter(getid);
		id = Integer.parseInt(auxid);
		
		String auxidmatricula = request.getParameter(getidmatricula);
		idmatricula = Integer.parseInt(auxidmatricula);
		
		String auxidprofesor = request.getParameter(getidprofesor);
		idprofesor = Integer.parseInt(auxidprofesor);		
		
		String auxnota = request.getParameter(getnota);
		nota = Integer.parseInt(auxnota);
		
		
		//PAra comprobar si se borra o se modifica
		String getcheck = "delete"+i;
		
		check = request.getParameter(getcheck);

		//Hacer el if de los check para decidir si se borra o se actualiza		
		if(check != null)
		{
		    //Generamos un conector de alumno
			conector_matricula co = new conector_matricula();
		    
			co.borrarFila(id);	
		}
		else
		{
			//Sacamos los datos de la fila i
			nombreprofesor = request.getParameter(getnombreprofesor);

			
			auxid = request.getParameter(getid);
			id = Integer.parseInt(auxid);
			
			auxidmatricula = request.getParameter(getidmatricula);
			idmatricula = Integer.parseInt(auxidmatricula);		
			
			auxidprofesor = request.getParameter(getidprofesor);
			idprofesor = Integer.parseInt(auxidprofesor);		
						
			
			auxnota = request.getParameter(getnota);
			nota = Integer.parseInt(auxnota);		
			
			
			//Creamos un alumno vacio
			evaluacion aux = new evaluacion();
			
			aux.setid(id);
			aux.setidmatricula(idmatricula);
			aux.setidprofesor(idprofesor);
			aux.setnota(nota);
			aux.setnombreprofesor(nombreprofesor);

			
		    //Update filas
		    //Generamos un conector de alumno
			conector_evaluacion co = new conector_evaluacion();
		    
			co.updateevaluacion(aux);   
		}
	}

	//Ver si añades un nuevo alumno
	
	System.out.println("aquiiiii");
	
	//Sacamos los datos de la fila i
	String auxnotax = request.getParameter("notan");
	
	if (auxnotax.equals(""))
	{
		nota = 0;
	}
	else
	{
		nota =  Integer.parseInt(auxnotax);
	}
	
	
	nombreprofesor = request.getParameter("nombreprofesorn");

	String n = "";
	String nu = "null";

	System.out.println("LLEGO AKI idprofesor= "+nota+"  nombre="+nombreprofesor);
	
	if(!(nombreprofesor == null))
	{
		//Creamos un alumno vacio
		evaluacion aux = new evaluacion();
		
		aux.setnombreprofesor(nombreprofesor);
		aux.setnota(nota);

	    //Update filas
	    //Generamos un conector de alumno
		conector_evaluacion co = new conector_evaluacion();
				    
		co.insertaevaluacion(aux); 
	}
	
	
	response.sendRedirect(url.vista+"adminevaluaciones.jsp");


%>


</body>
</html>