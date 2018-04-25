package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
	
	
	public alumno devolverPerfil(String username) throws SQLException, ClassNotFoundException {
		
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
		
		//Comprobar que se devolvio algo
		if (!rset.first()) {
			  
			return null;		  
		}
		  
		
		//Recoger informacion del alumno
		aux.setnombre(rset.getString("nombre"));
		aux.setapellido1(rset.getString("apellido1"));
		aux.setapellido2(rset.getString("apellido2"));
		aux.setfecha(rset.getDate("fecha_nacimiento"));
		aux.setdni(rset.getString("dni"));
		aux.settelefono(rset.getInt("telefono"));
		
		//Atributos como usuario
		aux.setusername(rset.getString("username"));
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();		
		
		return aux;
	}
	
	public boolean comprobardni(String dni, String username) throws SQLException, ClassNotFoundException {
		
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
		String sqlStr = "SELECT * FROM alumno, usuario WHERE alumno.dni='"+dni+"' AND alumno.id_usuario=usuario.id AND usuario.username<>'"+username+"'";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		if (!rset.first()) {
			  
			System.out.println(" entro al fin ");
			//Por ultimo es importante cerrar el conector, la consulta y todo.
			rset.close();
			stmt.close();
			conn.close();
			
			return true;		  
		}	
		
		System.out.println("No entro al if " );
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();
		
		return false;
	}
	
	public void updatealumno(	String nombre,
								String apellido1,
								String apellido2,
								String fecha_nacimiento,
								String dni,
								String telefono,
								String user) throws ClassNotFoundException, SQLException{
		
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
		String sqlStr = "UPDATE alumno, usuario SET "
						+ "alumno.nombre='"+nombre+"',"
						+ "alumno.apellido1='"+apellido1+"',"
						+ "alumno.apellido2='"+apellido2+"',"
						+ "alumno.telefono="+telefono+","
						+ "alumno.dni='"+dni+"',"
						+ "alumno.fecha_nacimiento='"+fecha_nacimiento+"'"
								+ "WHERE usuario.username ='"+user+"' AND "
								      + "usuario.id = alumno.id_usuario";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
	}
			
	public ArrayList<alumno> devolverTodos() throws SQLException, ClassNotFoundException{
		
		//Creamos un arralist de alumnos para la devolucion
		ArrayList<alumno> result = new ArrayList<alumno>();
	    
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
		String sqlStr = "SELECT u.id, u.password, u.username, " + 
				"       al.nombre, al.apellido1, al.apellido2, al.dni, " + 
				"       al.telefono, \r\n" + 
				"       (CASE WHEN al.fecha_nacimiento = '0000-00-00' THEN null " + 
				"            ELSE al.fecha_nacimiento END) AS fecha " + 
				"FROM usuario u, alumno al " + 
				"WHERE u.tipo='alumno' AND u.id = al.id_usuario ";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		while(rset.next()) {
		
			//creamos un objeto alumno donde volcar la informacion de la bbdd
			alumno aux = new alumno();
			
			//Id del usuario
			aux.setid(Integer.parseInt(rset.getString("id")));
			
			//Recoger informacion del alumno
			aux.setfecha(rset.getDate("fecha"));
			aux.setdni(rset.getString("dni"));
			aux.settelefono(rset.getInt("telefono"));
			
			//Atributos como usuario
			aux.setusername(rset.getString("username"));
			aux.setpassword(rset.getString("password"));
			aux.setnombre(rset.getString("nombre"));
			aux.setapellido1(rset.getString("apellido1"));
			aux.setapellido2(rset.getString("apellido2"));	
			
			result.add(aux);
			
		}
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();		
		
		
		
		
		return result;
	}
}
