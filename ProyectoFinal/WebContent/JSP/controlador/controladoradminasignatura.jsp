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
	
	String nombre;
	String idprofesor;

	String check;
	
	
	int len = Integer.parseInt(request.getParameter("length"));

	
	for(int i=0; i<len; i++)
	{
		
		String getid = "id"+i;
		
		String getnombre = "nombre"+i;
		String getidprofesor = "idprofesor"+i;
		
	
		String auxid = request.getParameter(getid);
		id = Integer.parseInt(auxid);
		
		
		//PAra comprobar si se borra o se modifica
		String getcheck = "delete"+i;
		
		check = request.getParameter(getcheck);

		//Hacer el if de los check para decidir si se borra o se actualiza		
		if(check != null)
		{
		    //Generamos un conector de alumno
			conector_asignatura co = new conector_asignatura();
		    
			co.borrarFila(id);	
		}
		else
		{
			//Sacamos los datos de la fila i
			nombre = request.getParameter(getnombre);
			idprofesor = request.getParameter(getidprofesor);

			
			//Creamos un alumno vacio
			asignatura aux = new asignatura();
			
			aux.setid(id);
			aux.setidprofesor(idprofesor);
			aux.setnombre(nombre);

			
		    //Update filas
		    //Generamos un conector de alumno
			conector_asignatura co = new conector_asignatura();
		    
			co.updateasignatura(aux);   
		}
	}

	//Ver si añades un nuevo alumno
	
	//Sacamos los datos de la fila i
	idprofesor = request.getParameter("idprofesorn");
	nombre = request.getParameter("nombren");

	String n = "";
	String nu = "null";

	String idpro = idprofesor;
	
	System.out.println("LLEGO AKI idprofesor= "+idprofesor+"  nombre="+nombre);
	
	if(!(idpro==null))
	{
		if(!nombre.equals(n))
		{
			//Creamos un alumno vacio
			asignatura aux = new asignatura();
		
			aux.setidprofesor(idprofesor);
			aux.setnombre(nombre);
	
	
		    //Update filas
		    //Generamos un conector de alumno
			conector_asignatura co = new conector_asignatura();
				    
			co.insertaasignatura(aux); 
		}
	}
	
	
	response.sendRedirect(url.vista+"adminasignaturas.jsp");


%>


</body>
</html>