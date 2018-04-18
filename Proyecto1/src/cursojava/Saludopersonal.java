package cursojava;

import java.util.*;
import javax.swing.*;


public class Saludopersonal {
	
	//Para los cuadros de dialogo
    JFrame frame = new JFrame("Saludo");
	
	public void saludo() {
		
		String nombre;
	
		String pass = "123456";
		String introducida;
		
		int intentos=0;
		
		int salida = 0;
		
		//Para poner el Jframe por delante de otras ventanas, que si no se puede quedar detras
		frame.setAlwaysOnTop( true );
		
		
	    nombre = JOptionPane.showInputDialog(frame, "Introduce tu nombre:");
	
	    do
	    {
	    	
	    	introducida = JOptionPane.showInputDialog(frame, "Introduce tu contraseña:");
	    	
	    	if(introducida.equals(pass))
	    	{
	    		//Entras al sistema
	    		salida = 1;
	    	}
	    	else
	    	{
	    		intentos++;
	    	}
	    	
	    	if(intentos == 3)
	    	{
	    		//No entras al sistema
	    		salida = 2;
	    	}
	    	
	    }while(salida == 0);
	    
	    if(salida == 1)
	    {
	    	JOptionPane.showMessageDialog(frame,"Bienvenido "+nombre);
	    	
			//Lanzar calculadora
			Calculadora calc = new Calculadora();
			calc.calculadora(nombre);
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(frame,"Acceso no permitido, superado maximo de intentos ");
	    	
	    	saludo();
	    }
	}

}
