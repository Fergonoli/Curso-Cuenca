package academia;

public class matricula {

	private String nombrealumno;
	private String dni;
	private int id;
	private int id_alumno;
	private int id_asignatura;
	
	
	private String nombreasignatura;
	
	
	//Metodos SET
	public void setnombrealumno(String nombre) {
		this.nombrealumno = nombre;
	}
	
	public void setdni(String dni) {
		this.dni = dni;
	}
	
	public void setnombreasignatura(String nombre) {
		this.nombreasignatura=nombre;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public void setidalumno(int id) {
		this.id_alumno = id;
	}
	
	public void setidasignatura(int id) {
		this.id_asignatura = id;
	}
	
	//Metodos GET
	public String getnombrealumno() {
		return this.nombrealumno;
	}
	
	public String getdni() {
		return this.dni;
	}
	
	public int getid() {
		return this.id;
	}
	
	public String getnombreasignatura() {
		return this.nombreasignatura;
	}

	public int getidalumno() {
		return this.id_alumno;
	}
	
	public int getidasignatura() {
		return this.id_asignatura;
	}
	
}
