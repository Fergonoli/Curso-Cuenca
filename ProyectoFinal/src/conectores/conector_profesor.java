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
		String sqlStr = "select A.*, B.*"+
						"from (SELECT alu.id, alu.nombre, alu.apellido1, alu.apellido2, alu.dni, mat.id as matri "+
						"FROM usuario u, profesor prof, asignatura asi, matricula mat, alumno alu "+ 
						"WHERE u.username='"+user+"' AND"+
						"      u.id = prof.id_usuario AND"+
						"      prof.id = asi.id_profesor AND"+
						"      asi.id = mat.id_asignatura AND "+
						"      mat.id_alumno = alu.id)  as A left join"+
						"(SELECT eva.nota, eva.id_matricula as evalu "+
						"FROM usuario u, profesor prof, asignatura asi, matricula mat, alumno alu, evaluaciones eva "+
						"WHERE u.username='Pepe' AND"+
						"      u.id = prof.id_usuario AND"+
						"      prof.id = asi.id_profesor AND"+
						"      asi.id = mat.id_asignatura AND "+
						"      mat.id_alumno = alu.id AND"+
						"      mat.id = eva.id_matricula) as B "+
						"on A.matri = B.evalu";

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
			boolean inser = comprobarEvaluacion(user,alumnos.get(i).getdni());
			
			//Si es true es porque hay una coincidendia
			if(inser)
			{
				//Hacer update
				//En una variable String almacenamos la instruccion SQL que queremos lanzar
				String sqlStr = "UPDATE `evaluaciones` SET `nota` = "+alumnos.get(i).notas.get(0).nota+" "
						+ "      WHERE evaluaciones.id_matricula = SELECT matricula.id \\\\r\\\\n\\\" + \\r\\n\" + \r\n" + 
						"						\"						\\\"                            FROM alumno, matricula, profesor, usuario, asignatura\\\\r\\\\n\\\" + \\r\\n\" + \r\n" + 
						"						\"						\\\"                            WHERE alumno.dni = '\\\"+alumnos.get(i).getdni()+\\\"' AND\\\\r\\\\n\\\" + \\r\\n\" + \r\n" + 
						"						\"						\\\"                                  alumno.id = matricula.id_alumno AND\\\\r\\\\n\\\" + \\r\\n\" + \r\n" + 
						"						\"						\\\"                                  usuario.username = '\\\"+user+\\\"' AND\\\\r\\\\n\\\" + \\r\\n\" + \r\n" + 
						"						\"						\\\"                                  usuario.id = profesor.id_usuario AND\\\\r\\\\n\\\" + \\r\\n\" + \r\n" + 
						"						\"						\\\"                                  asignatura.id_profesor = profesor.id AND\\\\r\\\\n\\\" + \\r\\n\" + \r\n" + 
						"						\"						\\\"                                  asignatura.id = matricula.id_asignatura"
						+ "											AND "
						+ "            evaluaciones.id_profesor = (SELECT profesor.id \\r\\n\" + \r\n" + 
						"						\"                 FROM profesor, usuario\\r\\n\" + \r\n" + 
						"						\"                 WHERE usuario.username = '\"+user+\"' AND\\r\\n\" + \r\n" + 
						"						\"                       usuario.id = profesor.id_usuario)";

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
				String sqlStr = "INSERT INTO `evaluaciones`( `id_matricula`, `nota`, `id_profesor`) VALUES ((SELECT matricula.id \r\n" + 
						"                                                                            FROM alumno, matricula, profesor, usuario, asignatura\r\n" + 
						"                                                                            WHERE alumno.dni = '"+alumnos.get(i).getdni()+"' AND\r\n" + 
						"                                                                                  alumno.id = matricula.id_alumno AND\r\n" + 
						"                                                                                  usuario.username = '"+user+"' AND\r\n" + 
						"                                                                                  usuario.id = profesor.id_usuario AND\r\n" + 
						"                                                                                  asignatura.id_profesor = profesor.id AND\r\n" + 
						"                                                                                  asignatura.id = matricula.id_asignatura\r\n" + 
						"                                                                            \r\n" + 
						"                                                                       ),5,\r\n" + 
						"                                                                          (SELECT profesor.id \r\n" + 
						"                                                                            FROM profesor, usuario\r\n" + 
						"                                                                            WHERE usuario.username = '"+user+"' AND\r\n" + 
						"                                                                                  usuario.id = profesor.id_usuario      \r\n" + 
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
		String sqlStr = "SELECT * FROM alumno al, matricula mat, evaluaciones eva, profesor prof, usuario usu\r\n" + 
				"WHERE al.dni = '"+dni+"' AND \r\n" + 
				"	   al.id = mat.id_alumno AND \r\n" + 
				"	   usu.username = '"+username+"' AND \r\n" + 
				"	   usu.id = prof.id_usuario AND \r\n" + 
				"	   mat.id = eva.id_matricula AND \r\n" + 
				"	   eva.id_profesor = prof.id";

		// Se puede quitar
		System.out.println("Query statement is " + sqlStr);
		      
		//Con esta funcion ejecutamos la Instruccion SQL creada arriba
		ResultSet rset = stmt.executeQuery(sqlStr);		
		
		//Comprobar que se devolvio algo
		if (!rset.first()) {

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
}
