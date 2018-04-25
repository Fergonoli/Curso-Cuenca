package academia;


public class usuario {
	
	//Id de usuario
	private int id;
	
	//Atributos de usuario
	private String username;
	private String password;
	private String tipo;
	
	//Atributos compartidos de alumnos y profesores
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int telefono;
	
	
	//Metodos get
	public int getid() {
		return this.id;
	}
	
	public String getusername() {
		return this.username;
	}
	
	public String getpassword() {
		return this.password;
	}
	
	public String gettipo() {
		return this.tipo;
	}
	
	public String getnombre() {
		return this.nombre;
	}
	
	public String getapellido1() {
		return this.apellido1;
	}
	
	public String getapellido2() {
		return this.apellido2;
	}	
	
	public int gettelefono() {
		return this.telefono;
	}
	
	
	//Metodos set
	public void setid(int i) {
		this.id = i;
	}
	
	public void setusername(String user) {
		this.username = user;
	}
	
	public void setpassword(String pass) {
		this.password = pass;
	}
	
	public void settipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setnombre(String nom) {
		this.nombre = nom;
	}
	
	public void setapellido1(String ape) {
		this.apellido1 = ape;
	}
	
	public void setapellido2(String ape) {
		this.apellido2 = ape;
	}	
	
	public void settelefono(int tel) {
		this.telefono = tel;
	}
	
}
