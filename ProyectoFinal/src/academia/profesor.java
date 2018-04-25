package academia;

public class profesor extends usuario {

	String especialidad;
	String despacho;
	int telefono;
	
	//Metodos set
	public void setespecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public void setdespacho(String despacho) {
		this.despacho = despacho;
	}
	
	
	
	//Metodos get
	public String getespecilidad() {
		return this.especialidad;
	}
	
	public String getdespacho() {
		return this.despacho;
	}	
	
}
