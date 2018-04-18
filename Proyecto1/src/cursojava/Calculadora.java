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
    
	public void calculadora(String nombre) throws InterruptedException
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
		    											+ "17. Vocales\n"
		    											+ "18. Reemplaza\n"
		    											+ "19. Subcadena\n"
		    											+ "20. Palabras\n"
		    											+ "21. Numerologia\n"
		    											+ "22. Cronometro\n"
		    											
		    											
														+ "99. TiposJpanel\n"
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
	        		
	        	case "Vocales": case "17": 
	        		vocales(nombre);
	        		salida=1;
	        		break;	        		
	        		
	        	case "Reemplazar": case "18": 
	        		reemplazar(nombre);
	        		salida=1;
	        		break;	

	        	case "Subcadena": case "19": 
	        		subcadena(nombre);
	        		salida=1;
	        		break;
	        		
	        	case "Palabras": case "20": 
	        		palabras(nombre);
	        		salida=1;
	        		break;	        		

	        	case "Numerologia": case "21": 
	        		numerologia(nombre);
	        		salida=1;
	        		break;
	        		
	        	case "Cronometro": case "22": 
	        		cronometro(nombre);
	        		salida=1;
	        		break;
	        			        		

	        		
	        	case "TiposJpanel": case "99": 
	        		jpanel(nombre);
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
		    JOptionPane.showMessageDialog(new JFrame(), "No es posible, raiz de un negativo", "Ecuacion de segundo grado",
		            JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(new JFrame(), nombre+" eso no es ni un dia", "Laborable o no",
                        JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(new JFrame(), " No es primo", "¿Es primo?",
				        JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(new JFrame(), " Es primo", "¿Es primo?",
			        JOptionPane.OK_OPTION);
		}
	}	

	//Ver cuantas vocales tiene un string
	public void vocales(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido ver cuantas vocales tiene un string");
		 
		frame.setAlwaysOnTop( true );
		
		String frase = JOptionPane.showInputDialog(frame, "Dame tu frase:");
		
		int vocales=0;
		
		//Lo paso a minusculas para que no de problemas
		frase = frase.toLowerCase();
		
		for(int i=0; i<frase.length(); i++)
		{
			if( (frase.charAt(i)=='a') ||
				(frase.charAt(i)=='e') ||
				(frase.charAt(i)=='i') ||
				(frase.charAt(i)=='o') ||
				(frase.charAt(i)=='u')  )
			{
				vocales++;
			}
			
		}
		
		JOptionPane.showMessageDialog(frame,"Tienes: "+vocales+" vocales");
	}	
	
	
	//Ver cuantas vocales tiene un string
	public void reemplazar(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido reemplazar letras de un string");
		 
		frame.setAlwaysOnTop( true );
		
		String frase = JOptionPane.showInputDialog(frame, "Dame tu frase:");
		
		String letranueva = JOptionPane.showInputDialog(frame, "Dame tu cadena de reemplazo:");
		
		String letravieja = JOptionPane.showInputDialog(frame, "Dame tu cadena que quieres reemplazar:");
		
		//Hacer el replace
		frase = frase.replaceAll(letravieja, letranueva);
		
		JOptionPane.showMessageDialog(frame,"Nueva frase: "+frase);
	}	
		

	//Tomar parte de una cadena
	public void subcadena(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido seccionar una cadena de texto");
		 
		frame.setAlwaysOnTop( true );
		
		String frase;
		
		String inicio;
		int inicionum;
		
		String fin;
		int finnum;
		
		do
		{
			frase = JOptionPane.showInputDialog(frame, "Dame tu frase:");
			
			inicio = JOptionPane.showInputDialog(frame, "Dame posicion de inicio:");
			inicionum = Integer.parseInt(inicio);
			
			fin = JOptionPane.showInputDialog(frame, "Dame posicion de fin:");
			finnum = Integer.parseInt(fin);
			
			//Comprobar que el inicio y el fin son correctos
			if(inicionum>finnum )
			{
				JOptionPane.showMessageDialog(new JFrame(), nombre+" posicion de inicio y fin mal introducidos", "Advertencia",
				        JOptionPane.ERROR_MESSAGE);
			}
			
			//Que la cadena no es demasiada corta
			if(frase.length()<finnum) 
			{
				JOptionPane.showMessageDialog(new JFrame(), nombre+" longitud de la frase demasiado corta", "Advertencia",
				        JOptionPane.ERROR_MESSAGE);
			}			
			
		//Mientras que los datos de entrada no sean correctos no dejar finalizar el metodo	
		}while( (inicionum>finnum) || (frase.length()<finnum) );
			
		//Hacer el substring
		frase = frase.substring(inicionum, finnum);
		
		JOptionPane.showMessageDialog(frame,"Nueva frase: "+frase);
	}		
	

	//Dividir las palabras de una frase
	public void palabras(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido dividir por palabras un texto");
		 
		frame.setAlwaysOnTop( true );
		
		//Frase que hay que separar
		String frase;
		frase = JOptionPane.showInputDialog(frame, "Dame tu frase:");
			
		
		//Array donde se almacenaran las palabras
		String palabras[];
		
		
		//Separamos el texto por palabras y lo guardamos en el string
		palabras = frase.split(" ");
		
		//El string resultado donde se almacenara el texto resultado
		String result = "\n";
		
		//Recorremos el array y imprimimos palabra a palabra en nuevas lineas
		for(int i=0; i<palabras.length; i++)
		{
			result = result + palabras[i] + "\n";
		}
		
		JOptionPane.showMessageDialog(frame,"Las palabras son: "+result);
	}		
		
	//Hacer un monton de operaciones
	public void numerologia(String nombre)
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido numerologia");
		 
		frame.setAlwaysOnTop( true );
		
		//Variables para todas las operaciones
		double mayor= Double.NEGATIVE_INFINITY;
		double menor= Double.POSITIVE_INFINITY;
		double sumatotal=0;
		double sumaposi=0;
		double sumanega=0;
		double media=0;
		double numeros=0;
		
		String consola;
		double consolanum;
		
		do
		{
			consola = JOptionPane.showInputDialog(frame, "Dame un numero (con el -1 acabara el metodo):");
			
			//Hacer el replace evita que si meten los numeros con , en vez de con punto entre igual
			consola = consola.replace(",", ".");
			
			//Comprobar que es un numero correcto y no otra cosa o nada directamente
			if(consola.matches("-?[0-9]+.?[0-9]*") && !consola.equals(""))
			{
				//Transformamos el string en un numero float
				consolanum = Double.parseDouble(consola);
	
				//Si se introduce un -1 se rompe el juego
				if(consolanum == -1)
				{
				    //Sale un cartel de advertencia con !
				    JOptionPane.showMessageDialog(new JFrame(), "Introducido un -1, se termina de recoger numeros", "Numerologia",
				            JOptionPane.CANCEL_OPTION);
					
					break;
				}
				
				//Comprobacion de menor
				if(consolanum<menor)
				{
					menor = consolanum;
				}
				
				//Comprobacion de mayo
				if(consolanum>mayor)
				{
					mayor = consolanum;
				}			
				
				//Sumar todo
				sumatotal = sumatotal+consolanum;
				
				//Suma de positivos
				if(consolanum>0)
				{
					sumaposi = sumaposi + consolanum;
				}
				
				//Suma de negativos
				if(consolanum<0)
				{
					sumanega = sumanega + consolanum;
				}
				
				//Contador de numeros
				numeros++;	
			}
			else
			{
			    JOptionPane.showMessageDialog(new JFrame(), consola+" -- No es un numero", "Numerologia",
			            JOptionPane.CANCEL_OPTION);
			}
				
		}while(true);
		
		
		//Calcular la media
		media = sumatotal/numeros;
		
		//Truncar las sumas para que devuelvan solo 2 decimales
		sumatotal=(double)((int)(sumatotal*100.0)/100.0); 
		sumaposi=(double)((int)(sumaposi*100.0)/100.0); 
		sumanega=(double)((int)(sumanega*100.0)/100.0); 
		media=(double)((int)(media*100.0)/100.0); 
		
		
		String result = "Resultado de numerologia: \n";
		
		result = result + "El menor numero: "+menor+"\n";
		result = result + "El mayor numero: "+mayor+"\n";
		result = result + "La suma de todos: "+sumatotal+"\n";
		result = result + "La suma de positivos: "+sumaposi+"\n";
		result = result + "La suma de negativos: "+sumanega+"\n";
		result = result + "La media de todo: "+media+"\n";
		
		JOptionPane.showMessageDialog(frame,nombre+" el resultado es: \n"+result);	
		
	}	
	
	
	
	//Hacer un cronometro
	@SuppressWarnings({ "static-access", "deprecation" })
	public void cronometro(String nombre) throws InterruptedException
	{
		JOptionPane.showMessageDialog(frame,nombre+" has elegido cronometro");
		
		int horas=0;
		int minutos=0;
		int segundos=0;
		
		String tiempo= horas+":"+minutos+":"+segundos;
		
        ventanaCrono V = new ventanaCrono();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
		
		while(true)
		{
			segundos++;
			
			if(segundos==60)
			{
				segundos=0;
				minutos++;
				
				if(minutos==60)
				{
					minutos=0;
					horas++;
					
					if(horas == 24)
					{
						horas=0;
					}
				}
			}
			
			tiempo = horas+":"+minutos+":"+segundos;
			
			V.texto.setText(tiempo);
			
			Thread.sleep(1000);
		}
	 
	
	}	

	
	
	
	
    
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	////           NUEVOS METODOS
	
	//Mostrar paneles
	public void jpanel(String nombre)
	{
		//Sale un cartel de prohibido con x
	    JOptionPane.showMessageDialog(new JFrame(), "ERROR_MESSAGE", "Dialog",
	            JOptionPane.ERROR_MESSAGE);
	    
	    //Sale un cartel de advertencia con !
	    JOptionPane.showMessageDialog(new JFrame(), "CANCEL_OPTION", "Dialog",
	            JOptionPane.CANCEL_OPTION);
	      
	    //Sale un cartel informativo con un simbolo de i
	    JOptionPane.showMessageDialog(new JFrame(), "INFORMATION_MESSAGE", "Dialog",
	            JOptionPane.INFORMATION_MESSAGE);
	    
	    //Sale un cartel con una interrogacion ?
	    JOptionPane.showMessageDialog(new JFrame(), "QUESTION_MESSAGE", "Dialog",
	            JOptionPane.QUESTION_MESSAGE);	    
	    
	    //Sale plano sin nada
	    JOptionPane.showMessageDialog(new JFrame(), "DEFAULT_OPTION", "Dialog",
	            JOptionPane.DEFAULT_OPTION);	    
	}	
	
	
	
	
	
}
