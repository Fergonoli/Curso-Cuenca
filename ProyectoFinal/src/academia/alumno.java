package academia;

import java.util.*;
import academia.*;


public class alumno extends usuario {
	
	private String dni;
	private Date fecha_nacimiento;
	
	
	//Un array list que contiene las notas de un alumno
	public ArrayList<evaluacion> notas = new ArrayList<evaluacion>();
	
	//Metodos get
	public String getdni() {
		return this.dni;
	}
	
	public Date getfecha() {
		return this.fecha_nacimiento;
	}
	
	
	//Metodos set
	public void setdni(String dni) {
		this.dni = dni;
	}
	
	public void setfecha(Date fecha) {
		this.fecha_nacimiento = fecha;
	}

}
