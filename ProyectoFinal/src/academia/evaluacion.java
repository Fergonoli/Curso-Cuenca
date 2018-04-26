package academia;

import academia.*;

public class evaluacion {	
	
	private int id;
	private int idmatricula;
	private int idprofesor;
	
	private String nombreprofesor;
	
	private String asignatura;
	private int nota;
	
	public void setasignatura(String nombre) {
		this.asignatura = nombre;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public void setidmatricula(int id) {
		this.idmatricula = id;
	}
	
	public void setidprofesor(int id) {
		this.idprofesor = id;
	}
	
	public void setnombreprofesor(String nombre) {
		this.nombreprofesor = nombre;
	}
	
	public void setnota(int not) {
		this.nota = not;
	}
	
	
	
	public int getnota() {
		return this.nota;
	}
	
	public String getasignatura() {
		return this.asignatura;
	}
	
	
	public int getid() {
		return this.id;
	}
	
	public int getidmatricula() {
		return this.idmatricula;
	}
	
	public int getidprofesor() {
		return this.idprofesor;
	}
	
	public String getnombreprofesor() {
		return this.nombreprofesor;
	}
	
}
