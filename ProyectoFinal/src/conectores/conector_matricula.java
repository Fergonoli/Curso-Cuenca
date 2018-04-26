package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import academia.alumno;
import academia.matricula;

public class conector_matricula {

		
	public ArrayList<matricula> devolverTodos() throws SQLException, ClassNotFoundException{
		
		//Creamos un arralist de alumnos para la devolucion
		ArrayList<matricula> result = new ArrayList<matricula>();
		
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
		String sqlStr = "SELECT mat.id, asi.id as idasignatura, alu.id as idalumno, asi.nombre as asignatura, alu.nombre as alumno FROM alumno alu, asignatura asi, matricula mat WHERE mat.id_alumno = alu.id AND mat.id_asignatura = asi.id ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		while(rset.next()) {
		
			//creamos un objeto alumno donde volcar la informacion de la bbdd
			matricula aux = new matricula();
			
			//Id del usuario
			aux.setid(Integer.parseInt(rset.getString("id")));
			
			//Id foraneas
			aux.setidasignatura(Integer.parseInt(rset.getString("idasignatura")));
			aux.setidalumno(Integer.parseInt(rset.getString("idalumno")));
						
			
			
			//Recoger informacion del alumno
			aux.setnombrealumno(rset.getString("alumno"));
			aux.setnombreasignatura(rset.getString("asignatura"));

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
	
	public void updatematricula(matricula entrada) throws ClassNotFoundException, SQLException{
		
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
		String sqlStr = "UPDATE matricula SET "
			+ "matricula.id_alumno= '"+entrada.getidalumno()+"', "
			+ "matricula.id_asignatura ='"+entrada.getidasignatura()+"' "
		    + "WHERE matricula.id = '"+entrada.getid()+"' ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
	}
		
	public void insertamatricula(matricula entrada) throws ClassNotFoundException, SQLException{
		
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
		String sqlStr = "INSERT INTO matricula (id_alumno, id_asignatura) VALUES ( "		
			+ "( SELECT id FROM alumno WHERE alumno.nombre ='"+entrada.getnombreasignatura()+"' ) , "		
			+ "( SELECT id FROM asignatura WHERE asignatura.nombre = '"+entrada.getnombrealumno()+"' ) )";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);				
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();		
	}
	
}

