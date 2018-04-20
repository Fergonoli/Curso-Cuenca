package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import academia.usuario;

public class conector_usuario {

	private String password;
	
	
	
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
		  
		  //introducimos los datos del usuario
		  usu.setusername(rset.getString("username"));
		  usu.setpassword(rset.getString("password"));
		  usu.settipo(rset.getString("tipo"));
		  
		 
		  
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
	
}
