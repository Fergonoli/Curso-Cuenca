package conectores;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import academia.*;

public class conector_profesor {

	
	//Metodos de conexion con BBDD
	public ArrayList<alumno> devolverCalificaciones(String user)  throws SQLException, ClassNotFoundException
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
		String sqlStr = "select A.*, B.* from (SELECT alu.id, alu.nombre, alu.apellido1, alu.apellido2, alu.dni, mat.id as matri FROM usuario u, profesor prof, asignatura asi, matricula mat, alumno alu WHERE u.username='"+user+"' AND u.id = prof.id_usuario AND prof.id = asi.id_profesor AND asi.id = mat.id_asignatura AND mat.id_alumno = alu.id) as A left join (SELECT eva.nota, eva.id_matricula as evalu FROM usuario u, profesor prof, asignatura asi, matricula mat, alumno alu, evaluaciones eva WHERE u.username='"+user+"' AND u.id = prof.id_usuario AND prof.id = asi.id_profesor AND asi.id = mat.id_asignatura AND mat.id_alumno = alu.id AND mat.id = eva.id_matricula) as B on A.matri = B.evalu";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Creamos un arralist de alumnos para la devolucion
		ArrayList<alumno> result = new ArrayList<alumno>();
		
		
    	String nombreaux;
    	String apellido1aux;
    	String apellido2aux;
    	String dniaux;
    	
    	int notaaux;
		
		//Hay que recorrer la lista de asignaturas que a cursado el alumno para tomar los datos que buscamos        
	    while (rset.next()) {
	    	  
			//Creamos un objeto alumno
			evaluacion eva = new evaluacion();
			
			//Creamos un objeto alumno
			alumno alu = new alumno();
			
	    	nombreaux = rset.getString("nombre");
	    	apellido1aux = rset.getString("apellido1");
	    	apellido2aux = rset.getString("apellido2");
	    	dniaux = rset.getString("dni");
	    	  	
	    	notaaux = rset.getInt("nota");
	    	
	    	//Rellenamos el alumno
	    	alu.setnombre(nombreaux);
	    	alu.setapellido1(apellido1aux);
	    	alu.setapellido2(apellido2aux);
	    	alu.setdni(dniaux);  	
	    	
	    	//Cargamos los datos de la evalucion de cada asignatura
	    	eva.setnota(notaaux);
	    	
	    	//Y las añadimos al arraylist de alumno
	    	alu.notas.add(eva);	
	    	
	    	//Añadimos este alumno a el arraylist de solucion
	    	result.add(alu);
	    }  
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();		
		  
		return result;
	}	

	public void modificarCalificaciones(String user, ArrayList<alumno> alumnos)  throws SQLException, ClassNotFoundException
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
		 
		//Hay que recorrer el arraylist para cada alumno
		for(int i=0; i<alumnos.size(); i++)
		{
			// Una vez recorrido la tabla sabemos que alumnos estan calificados, ahora toca saber si hay que hacer un insert o un update
			// Para ello se hara una comprobacion en la tabla evaluaciones, mirando si para este profesor y con ese dni hay alguna coincidencia
			boolean inser = comprobarEvaluacion(alumnos.get(i).getdni(), user);
			
			//Si es true es porque hay una coincidendia
			if(inser)
			{
				//Hacer update
				//En una variable String almacenamos la instruccion SQL que queremos lanzar
				String sqlStr = "UPDATE `evaluaciones` SET `nota` = "+alumnos.get(i).notas.get(0).getnota()+" "+
					    "        WHERE evaluaciones.id_matricula = (SELECT matricula.id "+ 
						"					                       FROM alumno, matricula, profesor, usuario, asignatura " + 
						"						                   WHERE alumno.dni = '"+alumnos.get(i).getdni()+"' AND " + 
						"						                         alumno.id = matricula.id_alumno AND " + 
						"						                         usuario.username = '"+user+"' AND " + 
						"						                         usuario.id = profesor.id_usuario AND " + 
						"						                         asignatura.id_profesor = profesor.id AND " + 
						"					                             asignatura.id = matricula.id_asignatura) "+
						"		 AND "+
						"             evaluaciones.id_profesor = (SELECT profesor.id " + 
						"						                  FROM profesor, usuario " + 
						"						                  WHERE usuario.username = '"+user+"' AND " + 
						"						                        usuario.id = profesor.id_usuario)";

				// Se puede quitar
				System.out.println("Query statement is " + sqlStr);
				      
				//Con esta funcion ejecutamos la Instruccion SQL creada arriba
				stmt.executeUpdate(sqlStr);	
			}
			else
			{
				//Hacer insert
				//Hacer update
				//En una variable String almacenamos la instruccion SQL que queremos lanzar
				String sqlStr = "INSERT INTO `evaluaciones`( `id_matricula`, `nota`, `id_profesor`) VALUES ((SELECT matricula.id " + 
						"                                                                            FROM alumno, matricula, profesor, usuario, asignatura " + 
						"                                                                            WHERE alumno.dni = '"+alumnos.get(i).getdni()+"' AND " + 
						"                                                                                  alumno.id = matricula.id_alumno AND " + 
						"                                                                                  usuario.username = '"+user+"' AND " + 
						"                                                                                  usuario.id = profesor.id_usuario AND " + 
						"                                                                                  asignatura.id_profesor = profesor.id AND " + 
						"                                                                                  asignatura.id = matricula.id_asignatura )"+
						"                                                                       , "+alumnos.get(i).notas.get(0).getnota()+", " + 
						"                                                                          (SELECT profesor.id  " + 
						"                                                                            FROM profesor, usuario " + 
						"                                                                            WHERE usuario.username = '"+user+"' AND " + 
						"                                                                                  usuario.id = profesor.id_usuario " + 
						"                                                                       ))";

				// Se puede quitar
				System.out.println("Query statement is " + sqlStr);
				      
				//Con esta funcion ejecutamos la Instruccion SQL creada arriba
				stmt.executeUpdate(sqlStr);					
			}
			
			

		}
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();		

	}	
	
	
	public boolean comprobarEvaluacion(String dni, String username) throws SQLException, ClassNotFoundException {
		
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
		String sqlStr = "SELECT * FROM alumno al, matricula mat, evaluaciones eva, profesor prof, usuario usu " + 
				"WHERE al.dni = '"+dni+"' AND  " + 
				"	   al.id = mat.id_alumno AND  " + 
				"	   usu.username = '"+username+"' AND  " + 
				"	   usu.id = prof.id_usuario AND  " + 
				"	   mat.id = eva.id_matricula AND  " + 
				"	   eva.id_profesor = prof.id";

		// Se puede quitar
		//System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		if (rset.first()) {

			//Por ultimo es importante cerrar el conector, la consulta y todo.
			rset.close();
			stmt.close();
			conn.close();
			
			return true;		  
		}	
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();
		
		return false;
	}
	
	
	
	
	public profesor devolverPerfil(String username) throws SQLException, ClassNotFoundException {
		
		//creamos un objeto profesor donde volcar la informacion de la bbdd
		profesor auxi = new profesor();
		
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
		String sqlStr = "SELECT * FROM usuario, profesor WHERE usuario.id=profesor.id_usuario AND usuario.username='"+username+"'";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		if (!rset.first()) {
			  
			return null;		  
		}
		 
		
		auxi.setnombre(rset.getString("nombre"));
		auxi.setapellido1(rset.getString("apellido1"));
		auxi.setapellido2(rset.getString("apellido2"));
		auxi.settelefono(rset.getInt("telefono"));
		auxi.setdespacho(rset.getString("despacho"));
		auxi.setespecialidad(rset.getString("especialidad"));
		
		
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();		
		
		return auxi;
	}
	
	public void updateprofesor(	String nombre,
			String apellido1,
			String apellido2,
			String despacho,
			String especialidad,
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
		String sqlStr = "UPDATE profesor, usuario SET "
			+ "profesor.nombre='"+nombre+"',"
			+ "profesor.apellido1='"+apellido1+"',"
			+ "profesor.apellido2='"+apellido2+"',"
			+ "profesor.telefono="+telefono+","
			+ "profesor.despacho='"+despacho+"',"
			+ "profesor.especialidad='"+especialidad+"'"
					+ "WHERE usuario.username ='"+user+"' AND "
					      + "usuario.id = profesor.id_usuario";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();		
	}

	//Metodos de conexion con BBDD
	public ArrayList<alumno> devolverMenores(String user)  throws SQLException, ClassNotFoundException
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
		String sqlStr = "SELECT alu.id, alu.nombre, alu.apellido1, alu.apellido2, alu.dni, alu.fecha_nacimiento "+
						"FROM usuario u, profesor prof, asignatura asi, matricula mat, alumno alu "+ 
						"WHERE u.username='"+user+"' AND"+
						"      u.id = prof.id_usuario AND"+
						"      prof.id = asi.id_profesor AND"+
						"      asi.id = mat.id_asignatura AND "+
						"      mat.id_alumno = alu.id AND "+
					    "      YEAR(alu.fecha_nacimiento) BETWEEN ( YEAR(now() )- 18 ) AND YEAR (now())";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Creamos un arralist de alumnos para la devolucion
		ArrayList<alumno> result = new ArrayList<alumno>();
		
		
    	String nombreaux;
    	String apellido1aux;
    	String apellido2aux;
    	String dniaux;
    	String fechaaux;
    
		//Hay que recorrer la lista de asignaturas que a cursado el alumno para tomar los datos que buscamos        
	    while (rset.next()) {
	    	  
			//Creamos un objeto alumno
			alumno alu = new alumno();
			
	    	nombreaux = rset.getString("nombre");
	    	apellido1aux = rset.getString("apellido1");
	    	apellido2aux = rset.getString("apellido2");
	    	dniaux = rset.getString("dni");
	    	fechaaux = rset.getString("fecha_nacimiento");  	

	    	//Rellenamos el alumno
	    	alu.setnombre(nombreaux);
	    	alu.setapellido1(apellido1aux);
	    	alu.setapellido2(apellido2aux);
	    	alu.setdni(dniaux);  
	    	alu.setfecha(fechaaux);
	    	
	    	
	    	//Añadimos este alumno a el arraylist de solucion
	    	result.add(alu);
	    }  
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		rset.close();
		stmt.close();
		conn.close();		
		  
		return result;
	}	

	public ArrayList<profesor> devolverTodos() throws SQLException, ClassNotFoundException{
		
		//Creamos un arralist de alumnos para la devolucion
		ArrayList<profesor> result = new ArrayList<profesor>();
	    
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
				"       pro.nombre, pro.apellido1, pro.apellido2, pro.especialidad, " + 
				"       pro.despacho, pro.telefono " + 
				"FROM usuario u, profesor pro " + 
				"WHERE u.tipo='profesor' AND u.id = pro.id_usuario ";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		while(rset.next()) {
		
			//creamos un objeto alumno donde volcar la informacion de la bbdd
			profesor aux = new profesor();
			
			//Id del usuario
			aux.setid(Integer.parseInt(rset.getString("id")));
			
			//Recoger informacion del alumno
			aux.setespecialidad(rset.getString("especialidad"));
			aux.setdespacho(rset.getString("despacho"));
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
	
	public void updateprofesor(profesor entrada) throws ClassNotFoundException, SQLException{

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
		
		String fecha = entrada.getespecilidad();
		
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "UPDATE profesor, usuario SET "
			+ "profesor.nombre='"+entrada.getnombre()+"',"
			+ "profesor.apellido1='"+entrada.getapellido1()+"',"
			+ "profesor.apellido2='"+entrada.getapellido2()+"',"
			+ "profesor.telefono="+entrada.gettelefono()+","
			+ "profesor.despacho='"+entrada.getdespacho()+"',"
			+ "profesor.especialidad='"+fecha+"',"
			+ "usuario.username='"+entrada.getusername()+"', "
			+ "usuario.password='"+entrada.getpassword()+"' "
					+ "WHERE usuario.id ='"+entrada.getid()+"' AND "
					      + "usuario.id = profesor.id_usuario";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);			
		
		//Por ultimo es importante cerrar el conector, la consulta y todo.
		stmt.close();
		conn.close();
	}
	
	public void insertaprofesor(profesor entrada) throws ClassNotFoundException, SQLException{

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
		
		String fecha = entrada.getespecilidad();		
		
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		String sqlStr = "INSERT INTO usuario (username, password, tipo) VALUES ( "
			+ "'"+entrada.getusername()+"', "
			+ "'"+entrada.getpassword()+"', 2) ";
		
		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		stmt.executeUpdate(sqlStr);				
		
		
		//En una variable String almacenamos la instruccion SQL que queremos lanzar
		sqlStr = "INSERT INTO profesor (nombre, apellido1, apellido2, despacho,  especialidad, telefono, id_usuario) VALUES ("
			+ "'"+entrada.getnombre()+"',"
			+ "'"+entrada.getapellido1()+"',"
			+ "'"+entrada.getapellido2()+"',"
			+ "'"+entrada.getdespacho()+"',"
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
