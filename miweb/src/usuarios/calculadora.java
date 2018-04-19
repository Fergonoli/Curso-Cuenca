package usuarios;

public class calculadora {

	private double operadorIzq;
	private double operadorDch;
	
	private String operacion;
	
	
	// Metodos GET
	public double getoperadorIzq() {
		return this.operadorIzq;
	}
	
	public double getoperadorDch() {
		return this.operadorDch;
	}
	
	public String getoperacion() {
		return this.operacion;
	}
	
	
	// Metodos SET
	public void setoperadorIzq(double operadorIzq) {
		this.operadorIzq = operadorIzq;
	}
	
	public void setoperadorDch(double operadorDch) {
		this.operadorDch = operadorDch;
	}
	
	public void setoperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
	// Metodos de la clase
	
	//Metodo para realizar las operaciones
	public String operacion()
	{
		String resultado = "";
		
		switch (this.operacion) {
		
			case "suma":  
				resultado = ""+(this.operadorIzq+this.operadorDch);
                break;
  
			case "resta":  
				resultado = ""+(this.operadorIzq-this.operadorDch);
                break;
                
			case "multiplicacion":  
				resultado = ""+(this.operadorIzq*this.operadorDch);
                break;
                
			case "division":  
				
				if(this.operadorDch != 0)
				{
					resultado = ""+(this.operadorIzq/this.operadorDch);
				}
				else
				{
					resultado = "No division por 0";
				}
                
				break;
            
			case "exponencial":  
				resultado = ""+Math.pow(this.operadorIzq,this.operadorDch);
                break;

			case "divisible": 

					if(this.operadorIzq%this.operadorDch == 0)
					{
						resultado = "Es divisible";
					}
					else
					{
						resultado = "No es divisible";
					}
					
                break;                    
		}
		
		return resultado;
	}
	
	
}
