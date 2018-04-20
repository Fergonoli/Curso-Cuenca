package academia;

public class usuario {
	
	private String username;
	private String password;
	private String tipo;
	
	//Metodos get
	public String getusername() {
		return this.username;
	}
	
	
	public String getpassword() {
		return this.password;
	}
	
	public String gettipo() {
		return this.tipo;
	}
	
	//Metodos set
	public void setusername(String user) {
		this.username = user;
	}
	
	public void setpassword(String pass) {
		this.password = pass;
	}
	
	public void settipo(String tipo) {
		this.tipo = tipo;
	}
	
}
