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
	int idasignatura;
	int idalumno;

	String nombrealumno;
	String nombreasignatura;

	String check;
	
	
	int len = Integer.parseInt(request.getParameter("length"));

	
	for(int i=0; i<len; i++)
	{
		
		String getid = "id"+i;
		
		String getidalumno = "idalumno"+i;
		String getidasignatura = "idasignatura"+i;
		
		String getnombrealumno = "nombrealumno"+i;
		String getnombreasignatura = "nombreasignatura"+i;
		
	
		String auxid = request.getParameter(getid);
		id = Integer.parseInt(auxid);
		
		String auxidasignatura = request.getParameter(getidasignatura);
		idasignatura = Integer.parseInt(auxidasignatura);
		
		String auxidalumno = request.getParameter(getidalumno);
		idalumno = Integer.parseInt(auxidalumno);
		
		
		
		
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
			nombrealumno = request.getParameter(getnombrealumno);
			nombreasignatura = request.getParameter(getnombreasignatura);

			
			auxid = request.getParameter(getid);
			id = Integer.parseInt(auxid);
			
			auxidalumno = request.getParameter(getidalumno);
			idalumno = Integer.parseInt(auxidalumno);		
			
			auxidasignatura = request.getParameter(getidasignatura);
			idasignatura = Integer.parseInt(auxidasignatura);		
			
			
			//Creamos un alumno vacio
			matricula aux = new matricula();
			
			aux.setid(id);
			aux.setidalumno(idalumno);
			aux.setidasignatura(idasignatura);
			aux.setnombrealumno(nombrealumno);
			aux.setnombreasignatura(nombreasignatura);

			
		    //Update filas
		    //Generamos un conector de alumno
			conector_matricula co = new conector_matricula();
		    
			co.updatematricula(aux);   
		}
	}

	//Ver si añades un nuevo alumno
	
	//Sacamos los datos de la fila i
	nombrealumno = request.getParameter("nombrealumnon");
	nombreasignatura = request.getParameter("nombreasignaturan");

	String n = "";
	String nu = "null";

	System.out.println("LLEGO AKI idprofesor= "+nombrealumno+"  nombre="+nombreasignatura);
	
	if(!(nombrealumno==null))
	{
		if(!nombreasignatura.equals(n))
		{
			//Creamos un alumno vacio
			matricula aux = new matricula();
		
			aux.setnombrealumno(nombrealumno);
			aux.setnombreasignatura(nombreasignatura);
	
	
		    //Update filas
		    //Generamos un conector de alumno
			conector_matricula co = new conector_matricula();
				    
			co.insertamatricula(aux); 
		}
	}
	
	
	response.sendRedirect(url.vista+"adminmatriculas.jsp");


%>


</body>
</html>