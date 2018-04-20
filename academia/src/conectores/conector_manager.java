package conectores;

public class conector_manager {

	// Contiene los datos de conexion que se comparten a todos los conectores, asi, si cambia
	// alguno de los datos, solo hay que cambiarlo una sola vez aqui
	
	public String conexion = "com.mysql.jdbc.Driver";
			
	public String url = "jdbc:mysql://localhost/academia";
	
	public String user = "root";
	
	public String pass = "";
}
