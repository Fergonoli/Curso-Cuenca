package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import academia.alumno;
import academia.evaluacion;

public class conector_evaluacion {

		
	public ArrayList<evaluacion> devolverTodos() throws SQLException, ClassNotFoundException{
		
		//Creamos un arralist de alumnos para la devolucion
		ArrayList<evaluacion> result = new ArrayList<evaluacion>();
		
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
		String sqlStr = "SELECT eva.id, eva.id_matricula, eva.nota, eva.id_profesor, prof.nombre as profesor FROM evaluaciones eva, profesor prof WHERE eva.id_profesor=prof.id";
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		while(rset.next()) {
		
			//creamos un objeto alumno donde volcar la informacion de la bbdd
			evaluacion aux = new evaluacion();
			
			//Id del usuario
			aux.setid(Integer.parseInt(rset.getString("id")));
			
			//Id foraneas
			aux.setidmatricula(Integer.parseInt(rset.getString("id_matricula")));
			aux.setidprofesor(Integer.parseInt(rset.getString("id_profesor")));
			aux.setnota(Integer.parseInt(rset.getString("nota")));
			aux.setnombreprofesor(rset.getString("profesor"));

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
		//con usuario root y sin contrseña
		Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
		  
		// Connection conn =
		//    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
		      
		//Con esta instruccion realizamos la conexion con la BBDD
		Statement stmt = conn.createStatement();		      
		      
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "DELETE FROM matricula WHERE id='"+id+"' ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);		
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();		
	}
	
	public void updateevaluacion(evaluacion entrada) throws ClassNotFoundException, SQLException{
		
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
		String sqlStr = "UPDATE evaluaciones SET "
			+ "evaluaciones.nota= '"+entrada.getnota()+"', "
			+ "evaluaciones.id_profesor = (SELECT id FROM profesor WHERE nombre='"+entrada.getnombreprofesor()+"') "
		    + "WHERE evaluaciones.id = '"+entrada.getid()+"' ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
	}
		
	public void insertaevaluacion(evaluacion entrada) throws ClassNotFoundException, SQLException{
		
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
		String sqlStr = "INSERT INTO evaluaciones( id_matricula, nota, id_profesor)VALUES ( "		
			+ "'"+entrada.getidmatricula()+"' , "	
			+ "'"+entrada.getnota()+"' ) , "	
			+ "'"+entrada.getidprofesor()+"' ) ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);				
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();		
	}
	
}

