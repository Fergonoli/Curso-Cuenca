package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import academia.*;

public class conector_alumno{
	
	
	//Metodos de conexion con BBDD
	public alumno devolverExpediente(String user)  throws SQLException, ClassNotFoundException
	{
		//Crear un objeto conector para obtener los datos de conexion
		conector_manager con = new conector_manager();
		
		//Funciones para realizar la conexion con la BBDD
		Class.forName(con.conexion);
		  
		//En la url de getConnection, es importante quitarle el puerto, y direccionar a la BBDD correcta, 
		//con usuario root y sin contrseña
		Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
		  
		// Connection conn =
		//    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
		      
		//Con esta instruccion realizamos la conexion con la BBDD
		Statement stmt = conn.createStatement();		      
		      
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "SELECT asignatura.nombre, evaluaciones.nota \r\n" + 
		         		"FROM asignatura LEFT jOIN matricula ON matricula.id_asignatura = asignatura.id \r\n" + 
		  		        "                LEFT JOIN evaluaciones ON evaluaciones.id_matricula = matricula.id \r\n" + 
		  		        "                LEFT jOIN alumno ON alumno.id = matricula.id_alumno \r\n" + 
		  		        "                LEFT jOIN usuario ON usuario.id = alumno.id_usuario\r\n" + 
		  		        "WHERE usuario.username = '"+user+"'";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Creamos un objeto alumno
		alumno alu = new alumno();
		
    	String nombreaux;
    	int notaaux;
		
		//Hay que recorrer la lista de asignaturas que a cursado el alumno para tomar los datos que buscamos        
	    while (rset.next()) {
	    	  
			//Creamos un objeto alumno
			evaluacion eva = new evaluacion();
	    	
	    	nombreaux = rset.getString("nombre");
	    	notaaux = rset.getInt("nota");
	    	
	    	System.out.println("Nombre asignatura "+nombreaux+"   nota "+notaaux);
	    	
	    	//Cargamos los datos de la evalucion de cada asignatura
	    	eva.setasignatura(nombreaux);
	    	eva.setnota(notaaux);
	    	
	    	//Y las añadimos al arraylist de alumno
	    	alu.notas.add(eva);	            
	    }  
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();		
		  
		return alu;
	}
	
	
	public alumno devolverPerfil(String username) {
		
		//creamos un objeto alumno donde volcar la informacion de la bbdd
		alumno aux = new alumno();
		
		//Crear un objeto conector para obtener los datos de conexion
		conector_manager con = new conector_manager();
		
		//Funciones para realizar la conexion con la BBDD
		Class.forName(con.conexion);
		  
		//En la url de getConnection, es importante quitarle el puerto, y direccionar a la BBDD correcta, 
		//con usuario root y sin contrseña
		Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
		  
		// Connection conn =
		//    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
		      
		//Con esta instruccion realizamos la conexion con la BBDD
		Statement stmt = conn.createStatement();		      
		      
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "SELECT * FROM usuario, alumno WHERE usuario.id=alumno.id_usuario AND usuario.username='"+username+"'";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		
    	String nombreaux;
    	int notaaux;
		
		//Hay que recorrer la lista de asignaturas que a cursado el alumno para tomar los datos que buscamos        
	    while (rset.next()) {
	    	  
			//Creamos un objeto alumno
			evaluacion eva = new evaluacion();
	    	
	    	nombreaux = rset.getString("nombre");
	    	notaaux = rset.getInt("nota");
	    	
	    	System.out.println("Nombre asignatura "+nombreaux+"   nota "+notaaux);
	    	
	    	//Cargamos los datos de la evalucion de cada asignatura
	    	eva.setasignatura(nombreaux);
	    	eva.setnota(notaaux);
	    	
	    	//Y las añadimos al arraylist de alumno
	    	alu.notas.add(eva);	            
	    }  
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();		
		  
		
		return aux;
	}
	
}
