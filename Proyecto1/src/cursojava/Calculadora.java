package cursojava;

import java.util.*;
import javax.swing.*;


public class Calculadora {

	//Sumandos para operadores
	public int a;
	public int b;
	public int c;
	
	//Para seleccionar la opcion de calculadora
	String opcion;
	
	//Para las lecturas por teclado
	Scanner sc = new Scanner(System.in);
	
	//Para los cuadros de dialogo
    JFrame frame = new JFrame("Circunferencia");
    
	public void calculadora(String nombre)
	{	
		
		int salida = 0;				
		
		do
		{
			
			//Para poner el Jframe por delante de otras ventanas, que si no se puede quedar detras
			frame.setAlwaysOnTop( true );
			
			
		    opcion = JOptionPane.showInputDialog(frame, "Que operacion quiere realizar "+nombre+":\n"
		    											+ "1. Sumar\n"
		    											+ "2. Restar\n"
		    											+ "3. Multiplicar\n"
		    											+ "4. Dividir\n"
		    											+ "5. Comparar\n"
		    											+ "6. Circunferencia\n"
		    											+ "7. Par\n"
		    											+ "8. Iva\n"
		    											+ "9. Contando\n"
		    											+ "10. Divisor 2 y 3\n"
		    											+ "11. Comprando\n"
		    											+ "12. Ecuacion\n"
		    											+ "13. Calendario\n"
		    											+ "14. Aleatorios\n"
		    											+ "15. Cifras\n"
		    											+ "16. Primos\n"
		    											
		    											);
			
			switch (opcion) 
			{
	        	case "Sumar": case "1":  
	        		sumar(nombre);
	        		salida=1;
	                break;
	                
	        	case "Restar": case "2":  
	        		restar(nombre);
	        		salida=1;
	                break;
	                 
	        	case "Multiplicar": case "3":
	        		multiplicar(nombre);
	        		salida=1;
	                break;
	                 
	        	case "Dividir": case "4": 
	        		dividir(nombre);
	        		salida=1;
	                break;
	                
	        	case "Comparar": case "5":  	        		
	        		comparar(nombre);
	        		salida=1;
	                break;
	                 
	        	case "Circunferencia": case "6": 
	        		circunferencia(nombre);
	        		salida=1;
	        		break;
	        		
	        	case "Par": case "7": 
	        		par(nombre);
	        		salida=1;
	        		break;	        		
	
	        	case "Iva": case "8": 
	        		iva(nombre);
	        		salida=1;
	        		break;	        		
	        		
	        	case "Contando": case "9": 
	        		contando(nombre);
	        		salida=1;
	        		break;	        		

	        	case "Divisor 2 y 3": case "10": 
	        		divisor(nombre);
	        		salida=1;
	        		break;	  
	        		
	        	case "Comprando": case "11": 
	        		comprando(nombre);
	        		salida=1;
	        		break;	        		

	        	case "Ecuacion": case "12": 
	        		ecuacion(nombre);
	        		salida=1;
	        		break;
	        		
	        	case "Calendario": case "13": 
	        		calendario(nombre);
	        		salida=1;
	        		break;	        		
	        		
	        	case "Aleartorios": case "14": 
	        		aleatorio(nombre);
	        		salida=1;
	        		break;	        		
	        		
	        	case "Cifras": case "15": 
	        		cifra(nombre);
	        		salida=1;
	        		break;	        		
	        		
	        	case "Primos": case "16": 
	        		primo(nombre);
	        		salida=1;
	        		break;	        		
	        		
	        		
	        	default:  
	        		JOptionPane.showMessageDialog(frame,"No entendi el comando ");
			}
		}while(salida == 0);
		
		calculadora(nombre);
	}
	

	//Operaciones basicas
	public void sumar(String nombre) {
		JOptionPane.showMessageDialog(frame,  nombre+" has elegido sumar dos numeros");

		frame.setAlwaysOnTop( true );
		
		
	    String num = JOptionPane.showInputDialog(frame, "Dame el primer sumando:");
		a = Integer.parseInt(num);

		num = JOptionPane.showInputDialog(frame, "Dame el segundo sumando:");
		b = Integer.parseInt(num);	
		
		JOptionPane.showMessageDialog(frame,nombre+" el resultado es :"+(a+b));
		
	}
	
	
	public void restar(String nombre) {
		JOptionPane.showMessageDialog(frame, nombre+" has elegido restar dos numeros");

		frame.setAlwaysOnTop( true );
		
		
	    String num = JOptionPane.showInputDialog(frame, "Dame el primer sumando:");
		a = Integer.parseInt(num);

		num = JOptionPane.showInputDialog(frame, "Dame el segundo sumando:");
		b = Integer.parseInt(num);	
		
		JOptionPane.showMessageDialog(frame, nombre+" el resultado es :"+(a-b));
		
	}
	
	
	public void multiplicar(String nombre) {
		JOptionPane.showMessageDialog(frame, nombre+" has elegido multiplicar dos numeros");

		frame.setAlwaysOnTop( true );
		
		
	    String num = JOptionPane.showInputDialog(frame, "Dame el primer numero:");
		a = Integer.parseInt(num);

		num = JOptionPane.showInputDialog(frame, "Dame el segundo numero:");
		b = Integer.parseInt(num);	
		
		JOptionPane.showMessageDialog(frame, nombre+" el resultado es :"+(a*b));
		
	}
	
	
	public void dividir(String nombre) {
		JOptionPane.showMessageDialog(frame, nombre+" has elegido dividir dos numeros");

		frame.setAlwaysOnTop( true );
		
		
	    String num = JOptionPane.showInputDialog(frame, "Dame el dividendo:");
		a = Integer.parseInt(num);

		num = JOptionPane.showInputDialog(frame, "Dame el divisor:");
		b = Integer.parseInt(num);	
		
		JOptionPane.showMessageDialog(frame, nombre+ " el resultado es :"+(a+b));
		
	}
	
	
	public void circunferencia(String nombre) {
		
		JOptionPane.showMessageDialog(frame, nombre+" has elegido calcular el area de circunferencia");

		//Para poner el Jframe por delante de otras ventanas, que si no se puede quedar detras
		frame.setAlwaysOnTop( true );
		
		
	    String num = JOptionPane.showInputDialog(frame, "Dame el radio de la circunferencia:");
		

	    a = Integer.parseInt(num);
		double area = Math.pow(a,2)*Math.PI;
		
		JOptionPane.showMessageDialog(frame, nombre+ "el area es "+area);
	}

	public void par(String nombre) {
		
		JOptionPane.showMessageDialog(frame, nombre+" has elegido par o impar");

		//Para poner el Jframe por delante de otras ventanas, que si no se puede quedar detras
		frame.setAlwaysOnTop( true );
		
		
	    String num = JOptionPane.showInputDialog(frame, "Dame el numero para comparar:");
		

	    a = Integer.parseInt(num);
		
	    //Si no hay resto es par
	    if(a%2 == 0)
	    {
	    	JOptionPane.showMessageDialog(frame, nombre+ " el numero "+a+" es par");
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(frame,nombre+" el numero "+a+" es impar");
	    }
		
	}
			
	
	public void iva(String nombre) {
		
		JOptionPane.showMessageDialog(frame, nombre+" has elegido calcular el IVA");

		//Para poner el Jframe por delante de otras ventanas, que si no se puede quedar detras
		frame.setAlwaysOnTop( true );
		
		
	    String num = JOptionPane.showInputDialog(frame, "Dame el numero para aplicarselo:");
		

	    a = Integer.parseInt(num);
		
	    //aplicar el iva
	    JOptionPane.showMessageDialog(frame,"Aplicando el iva "+(double)(a+a*0.2)+" es impar");
	}	
	
	public void contando(String nombre) {
		
		JOptionPane.showMessageDialog(frame,nombre+" vamos a aprender a contar hasta el 100");
		
		int i = 0;
		String result = "";
		
		//Para poner el Jframe por delante de otras ventanas, que si no se puede quedar detras
		frame.setAlwaysOnTop( true );
		
		while(i<=100)
		{
			if(i%10 == 0)
			{
				result = result+"\n";
			}
			result = result+i+", ";
			i++;
		}
		
		
	    //mostrar resultados
	    JOptionPane.showMessageDialog(frame,result);
	}	
		
	public void divisor(String nombre) {
		
		JOptionPane.showMessageDialog(frame,nombre+" has elegido Divisores de 2 y 3 hasta el 100");
		
		int i = 0;
		String result = "";
		
		//Para poner el Jframe por delante de otras ventanas, que si no se puede quedar detras
		frame.setAlwaysOnTop( true );
		
		while(i<=100)
		{
			if( (i%2 == 0) || (i%3 == 0) )
			{
				result = result+i+", ";
			}

			i++;
		}
		
		
	    //mostrar resultados
	    JOptionPane.showMessageDialog(frame,result);
	}	
	
	public void comprando(String nombre) {
		
		String num = JOptionPane.showInputDialog(frame, nombre+" estas comprando articulos, ¿cuantos has comprado?");
		int articulos = Integer.parseInt(num);
		
		//Para poner el Jframe por delante de otras ventanas, que si no se puede quedar detras
		frame.setAlwaysOnTop( true );
		
		float precio = 0;
		float preciototal = 0;
		int i = 1;
		
		while(articulos >= i)
		{	
			num = JOptionPane.showInputDialog(frame, "precio del articulo "+i);
			
			//Hacer el replace evita que si meten los numeros con , en vez de con punto entre igual
			num = num.replaceAll(",", ".");
			
			precio = Float.parseFloat(num);
			
			preciototal = preciototal + precio;
				
			i++;		
		}
		
		
	    //mostrar resultados
	    JOptionPane.showMessageDialog(frame,"El precio total es "+preciototal);
	}	
	
	
	
	// Para realizar la comparacion
	public void comparar(String nombre)
	{
		JOptionPane.showMessageDialog(frame, nombre+ " has elegido comparar dos numeros ");
		 
		 
		frame.setAlwaysOnTop( true );
			
			
		String num = JOptionPane.showInputDialog(frame, "Dame el primer numero:");
		a = Integer.parseInt(num);

		num = JOptionPane.showInputDialog(frame, "Dame el segundo numero:");
		b = Integer.parseInt(num);	
		
		if(a<b)
		{
			JOptionPane.showMessageDialog(frame,"numero: "+a+" es menos que numero: "+b);
		}
		else
		{
			//Si no, comparar si son iguales
			if(a==b)
			{
				JOptionPane.showMessageDialog(frame,"numero: "+a+" es igual que numero: "+b);
			}
			else
			{
				//Si no ya solo queda una ultima posibilidad
				JOptionPane.showMessageDialog(frame,"numero: "+b+" es menos que numero: "+a);
			}
		}
		
	}
	
	
	// Para realizar la ecuacion de 2º grado
	public void ecuacion(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido hacer la ecuacion de 2º grado ");
		 
		String num;
		frame.setAlwaysOnTop( true );
			
		//Evitar division por 0
		do
		{			
			num = JOptionPane.showInputDialog(frame, "Dame A:");
			a = Integer.parseInt(num);
			
		}while(a == 0);
		
		num = JOptionPane.showInputDialog(frame, "Dame B:");
		b = Integer.parseInt(num);	
		
		num = JOptionPane.showInputDialog(frame, "Dame C:");
		c = Integer.parseInt(num);		
		
		double raiz = Math.pow(b, 2) - 4*a*c;
			
		if(raiz < 0)
		{
			JOptionPane.showMessageDialog(frame,"No es posible, raiz de un negativo");
		}
		else
		{
			double x1 = ( -b+Math.sqrt(raiz) ) / 2*a;
			
			double x2 = ( -b-Math.sqrt(raiz) ) / 2*a;	
			
			JOptionPane.showMessageDialog(frame,"Resultados:  X1 = "+x1+"  y  X2 = "+x2);
		}	
		
	}	
	
	
	// Para comprobar si es festivo o laborable
	public void calendario(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido ver laborable o festivo");
		 
		frame.setAlwaysOnTop( true );
		
		String dia = JOptionPane.showInputDialog(frame, "Nombre del dia:");
		
		//Lo paso a minusculas para que no de problemas
		dia = dia.toLowerCase();
		
		switch (dia) 
		{
        	case "lunes": case "martes": case "miercoles": case "jueves": case "viernes":
        		
        		JOptionPane.showMessageDialog(frame,nombre+" ese dia es laborable");
        		
                break;
                
        	case "sabado": case "domingo":
        		
        		JOptionPane.showMessageDialog(frame,nombre+" ese dia es festivo");
        		
                break;	
                
            default:
            	
            	JOptionPane.showMessageDialog(frame,nombre+" eso no es ni un dia");
		}		
	}	
	
	//Generar numeros aleatorios
	public void aleatorio(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido generar numeros aleatorios");
		 
		frame.setAlwaysOnTop( true );
		
		String num = JOptionPane.showInputDialog(frame, "Dame el minimo:");
		int min = Integer.parseInt(num);		
		
		num = JOptionPane.showInputDialog(frame, "Dame el maximo:");
		int max = Integer.parseInt(num);		
		
		String result ="";
		int aleatorio;
		
		for(int i=0; i<=10; i++) {
			
			//Generar numero aleatorio
			aleatorio = (int)(Math.random()*max + min);
			
			result = result + aleatorio+"  ";
			
		}
		
    	JOptionPane.showMessageDialog(frame,nombre+" estos son tus numeros aleatorios: "+result);
		
		
	}	
	
	//Contar cifras
	public void cifra(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido contar cifras");
		 
		frame.setAlwaysOnTop( true );
		
		String num = JOptionPane.showInputDialog(frame, "Dame el numero:");
		double numero = Float.parseFloat(num);		
		
		double dividido = numero;
		
		//Evitar negativos
		dividido = Math.abs(dividido);
		
		int cifra = 1;		
		
		while(dividido/10 > 1 ){
			dividido = dividido/10;
			cifra++;		
		}
		
    	JOptionPane.showMessageDialog(frame,nombre+" las cifras del numero "+numero+" son: "+cifra);		
	}	
		

	//Ver si es primo
	public void primo(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido ver si es primo");
		 
		frame.setAlwaysOnTop( true );
		
		String num = JOptionPane.showInputDialog(frame, "Dame el numero:");
		int numero = Integer.parseInt(num);
		
		int primo = 0;
		
		for(int i=1; i<=numero; i++)
		{
			if(numero%i==0)
			{
				primo++;
			}
			
			if(primo>2) break;
		}
		
		if(primo>2)
		{
			JOptionPane.showMessageDialog(frame," No es primo");
		}
		else
		{
			JOptionPane.showMessageDialog(frame," Es primo");
		}
	}	
		
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	////           NUEVOS METODOS
	
	
	
}
