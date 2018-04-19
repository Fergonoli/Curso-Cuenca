package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conector_usuario {

	private String password;
	
	
	public String delvolverPass(String user) throws SQLException, ClassNotFoundException
	{
		  //Funciones para realizar la conexion con la BBDD
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  //En la url de getConnection, es importante quitarle el puerto, y direccionar a la BBDD correcta, 
		  //con usuario root y sin contrseña
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "");
		  
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
