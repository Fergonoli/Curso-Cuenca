package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import academia.alumno;

public class conector_asignatura {

		
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
			aux.setfecha(rset.getString("fecha"));
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
	
	public void borrarFila(int id) throws SQLException, ClassNotFoundException{
		
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
		String sqlStr = "DELETE FROM usuario WHERE id='"+id+"' ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);		
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();		
	}
	
	public void updatealumno(alumno entrada) throws ClassNotFoundException, SQLException{
		
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
		
		String fecha = entrada.getfecha();
		if(entrada.getfecha().equals("null"))
		{
			fecha = "0000-00-00";
		}
		
		
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "UPDATE alumno, usuario SET "
			+ "alumno.nombre='"+entrada.getnombre()+"',"
			+ "alumno.apellido1='"+entrada.getapellido1()+"',"
			+ "alumno.apellido2='"+entrada.getapellido2()+"',"
			+ "alumno.telefono="+entrada.gettelefono()+","
			+ "alumno.dni='"+entrada.getdni()+"',"
			+ "alumno.fecha_nacimiento='"+fecha+"',"
			+ "usuario.username='"+entrada.getusername()+"', "
			+ "usuario.password='"+entrada.getpassword()+"' "
					+ "WHERE usuario.id ='"+entrada.getid()+"' AND "
					      + "usuario.id = alumno.id_usuario";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
	}
		
	public void insertalumno(alumno entrada) throws ClassNotFoundException, SQLException{
		
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
		
		String fecha = entrada.getfecha();
		if(entrada.getfecha().equals(""))
		{
			fecha = "0000-00-00";
		}
		
		
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "INSERT INTO usuario (username, password, tipo) VALUES ( "
			+ "'"+entrada.getusername()+"', "
			+ "'"+entrada.getpassword()+"', 1) ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);				
		
		
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		sqlStr = "INSERT INTO alumno (nombre, apellido1, apellido2, dni,  fecha_nacimiento, telefono, id_usuario) VALUES ("
			+ "'"+entrada.getnombre()+"',"
			+ "'"+entrada.getapellido1()+"',"
			+ "'"+entrada.getapellido2()+"',"
			+ "'"+entrada.getdni()+"',"
			+ "'"+fecha+"',"
			+ ""+entrada.gettelefono()+","	
		
		    + "(SELECT id FROM usuario WHERE usuario.username='"+entrada.getusername()+"'))";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
		
	}


	
}
