package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import academia.alumno;
import academia.asignatura;

public class conector_asignatura {

		
	public ArrayList<asignatura> devolverTodos() throws SQLException, ClassNotFoundException{
		
		//Creamos un arralist de alumnos para la devolucion
		ArrayList<asignatura> result = new ArrayList<asignatura>();
		
		//Crear un objeto conector para obtener los datos de conexion
		conector_manager con = new conector_manager();
		
		//Funciones para realizar la conexion con la BBDD
		Class.forName(con.conexion);
		  
		//En la url de getConnection, es importante quitarle el puerto, y direccionar a la BBDD correcta, 
		//con usuario root y sin contrse�a
		Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
		  
		// Connection conn =
		//    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
		      
		//Con esta instruccion realizamos la conexion con la BBDD
		Statement stmt = conn.createStatement();		      
		      
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "SELECT asi.id, asi.nombre as asignatura, prof.nombre as profesor "+
				        "FROM profesor prof, asignatura asi " + 
				        "WHERE asi.id_profesor = prof.id ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		while(rset.next()) {
		
			//creamos un objeto alumno donde volcar la informacion de la bbdd
			asignatura aux = new asignatura();
			
			//Id del usuario
			aux.setid(Integer.parseInt(rset.getString("id")));
			
			//Recoger informacion del alumno
			aux.setidprofesor(rset.getString("profesor"));
			aux.setnombre(rset.getString("asignatura"));

			result.add(aux);
			
		}
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();		
		
		return result;
	}
	
	public void borrarFila(int id) throws SQLException, ClassNotFoundException{
		
		//Crear un objeto conector para obtener los datos de conexion
		conector_manager con = new conector_manager();
		
		//Funciones para realizar la conexion con la BBDD
		Class.forName(con.conexion);
		  
		//En la url de getConnection, es importante quitarle el puerto, y direccionar a la BBDD correcta, 
		//con usuario root y sin contrse�a
		Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
		  
		// Connection conn =
		//    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
		      
		//Con esta instruccion realizamos la conexion con la BBDD
		Statement stmt = conn.createStatement();		      
		      
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "DELETE FROM asignatura WHERE id='"+id+"' ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);		
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();		
	}
	
	public void updateasignatura(asignatura entrada) throws ClassNotFoundException, SQLException{
		
		//Crear un objeto conector para obtener los datos de conexion
		conector_manager con = new conector_manager();
		
		//Funciones para realizar la conexion con la BBDD
		Class.forName(con.conexion);
		
		//En la url de getConnection, es importante quitarle el puerto, y direccionar a la BBDD correcta, 
		//con usuario root y sin contrse�a
		Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
		
		// Connection conn =
		//    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
		
		//Con esta instruccion realizamos la conexion con la BBDD
		Statement stmt = conn.createStatement();		      
		
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "UPDATE asignatura SET "
			+ "asignatura.nombre='"+entrada.getnombre()+"',"
			+ "asignatura.id_profesor= (SELECT profesor.id FROM profesor WHERE profesor.nombre ='"+entrada.getidprofesor()+"' )"
		    + "WHERE asignatura.id = '"+entrada.getid()+"' ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
	}
		
	public void insertaasignatura(asignatura entrada) throws ClassNotFoundException, SQLException{
		
		//Crear un objeto conector para obtener los datos de conexion
		conector_manager con = new conector_manager();
		
		//Funciones para realizar la conexion con la BBDD
		Class.forName(con.conexion);
		
		//En la url de getConnection, es importante quitarle el puerto, y direccionar a la BBDD correcta, 
		//con usuario root y sin contrse�a
		Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
		
		// Connection conn =
		//    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
		
		//Con esta instruccion realizamos la conexion con la BBDD
		Statement stmt = conn.createStatement();		      
		
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "INSERT INTO asignatura (nombre, idprofesor) VALUES ( "
			+ "'"+entrada.getnombre()+"', "
			+ "(SELECT profesor.nombre FROM profesor WHERE profesor.nombre ='"+entrada.getidprofesor()+"' ) ) ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);				
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();		
	}
	
}
