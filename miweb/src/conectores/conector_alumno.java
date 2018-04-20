package conectores;

//Imports para herramientas de java
import  java.sql.*;
import java.util.*;

//Import para tener el objeto alumno
import usuarios.alumno;

public class conector_alumno {

	//Un objeto alumno para realizar operacion, o devoluciones
	private alumno alu;

	//Notas
	class Notas
	{
	    public String asignatura; 
	    public String nota;  
	 };
	 
	 
	public int insert(String nombre, String dni, String fecha_nacimiento) throws SQLException, ClassNotFoundException
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
		  String sqlStr = "INSERT INTO alumno (nombre, dni, fecha_nacimiento) VALUES ('"+nombre+"', '"+dni+"', '"+fecha_nacimiento+"')";

		  // Se puede quitar
		  System.out.println("Query statement is " + sqlStr);
		      
		  //Con esta funcion ejecutamos la Instruccion SQL creada arriba
		  stmt.executeUpdate(sqlStr);
		  
		  //Por ultimo es importante cerrar el conector, la consulta y todo.
		  stmt.close();
		  conn.close();		

		  return 0;
	}
	
	
	public ArrayList<Notas> MostrarNotas(String dni)
	{
		ArrayList<Notas> notas = new ArrayList<Notas>();
		
		//Hacer el select de las notas del alumno combinando las tablas
		
		
		//Devolver las notas
		return notas;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	//		NUEVAS CONSULTAS
	//
	
}
