package conectores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import academia.*;

public class conector_usuario {

	private String password;
	

	public boolean comprobarusername(String username) throws SQLException, ClassNotFoundException {
		
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
		String sqlStr = "SELECT * FROM usuario WHERE usuario.username='"+username+"'";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		if (!rset.first()) {
			  
			return true;		  
		}	
		
		return false;
	}	
	
	
	public boolean comprobarpassword(String username, String pass) throws SQLException, ClassNotFoundException {
		
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
		String sqlStr = "SELECT * FROM usuario WHERE usuario.username='"+username+"' AND usuario.password='"+pass+"'";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		if (rset.first()) {
			  
			return true;		  
		}	
		
		return false;
	}
	
	public void updateusername(String lastuser, String newuser) throws SQLException, ClassNotFoundException {
		
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
		String sqlStr = "UPDATE usuario SET "
						+ "usuario.username='"+newuser+"' "
								+ "WHERE usuario.username = '"+lastuser+"' ";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
		
	}
	
	
	
	public void updatepassword(String pass, String user) throws SQLException, ClassNotFoundException {
		
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
		String sqlStr = "UPDATE usuario SET "
						+ "usuario.password='"+pass+"' "
								+ "WHERE usuario.username = '"+user+"' ";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
		
	}
	
	
	public usuario delvolverUsuario(String user) throws SQLException, ClassNotFoundException
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
		  String sqlStr = "SELECT * FROM usuario u WHERE u.username = '"+user+"'";

		  // Se puede quitar
		  System.out.println("Query statement is " + sqlStr);
		      
		  //Con esta funcion ejecutamos la Instruccion SQL creada arriba
		  ResultSet rset = stmt.executeQuery(sqlStr);

		  
		  //Comprobar que se devolvio algo
		  if (!rset.first()) {
			  
			  return null;		  
		  }
		  
		  //Creamos un usuario
		  usuario usu = new usuario();
		  
		  String username = rset.getString("username");
		  String pass = rset.getString("password");
		  String tip = rset.getString("tipo");
		  
		  //introducimos los datos del usuario
		  usu.setusername(username);
		  usu.setpassword(pass);
		  usu.settipo(tip);
		  
		 
		  
		  //Por ultimo es importante cerrar el conector, la consulta y todo.
		  rset.close();
		  stmt.close();
		  conn.close();		
		  
		  return usu;
	}	
	
	
	public String delvolverPass(String user) throws SQLException, ClassNotFoundException
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
		  String sqlStr = "SELECT u.password FROM usuario u WHERE u.username = '"+user+"'";

		  // Se puede quitar
		  System.out.println("Query statement is " + sqlStr);
		      
		  //Con esta funcion ejecutamos la Instruccion SQL creada arriba
		  ResultSet rset = stmt.executeQuery(sqlStr);

		  rset.next();
		  
		  //rset solo debe contener el password del usuario ni mas ni menos
		  String resultado = rset.getString("password");
		  
		 
		  
		  //Por ultimo es importante cerrar el conector, la consulta y todo.
		  rset.close();
		  stmt.close();
		  conn.close();		
		  
		  return resultado;
	}

	
	//Metodos de conexion con BBDD
	public int devolverExpediente(String user)
	{
		System.out.println("Entro ");
		
		return 1;
		
		/*
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
		
		
		//Creamos un objeto evaluacion para cargar los datos en las notas
		evaluacion aux = new evaluacion();
		
		
		//Creamos un objeto alumno
		alumno alu = new alumno();
		
		//Hay que recorrer la lista de asignaturas que a cursado el alumno para tomar los datos que buscamos        
	    while (rset.next()) {
	    	  
	    	//Cargamos los datos de la evalucion de cada asignatura
	    	aux.asignatura.setnombre(rset.getString("nombre"));
	    	aux.nota = rset.getInt("nota");
	    	
	    	//Y las añadimos al arraylist de alumno
	    	alu.notas.add(aux);
	            
	    }  
		
		
		
		return alu;*/
	}
	
}
