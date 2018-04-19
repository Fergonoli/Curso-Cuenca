<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de calculadora</title>
<meta http-equiv="refresh" content="0.01; URL=calculadora.jsp">
</head>
<body>

<!-- Importar la clase de calculadora  -->
<%@ page import="usuarios.calculadora" %>

<!-- Importar la clase de jpanel  -->
<%@ page import="java.util.*" %>
<%@ page import="javax.swing.*" %>


<%
	double operadorIzq = Double.parseDouble(request.getParameter("operandoIzq"));
	double operadorDch = Double.parseDouble(request.getParameter("operandoDch"));
	
	String operador = request.getParameter("operador");

	//Para los cuadros de dialogo
    JFrame frame = new JFrame("Circunferencia");	
	
	calculadora calc = new calculadora();
	
	calc.setoperacion(operador);
	calc.setoperadorIzq(operadorIzq);
	calc.setoperadorDch(operadorDch);
	
	String resultado = calc.operacion();
	
	frame.setAlwaysOnTop( true );
		
	JOptionPane.showMessageDialog(frame, "Resultado: "+resultado);
	
%>


<br>
<br>
<a href="calculadora.jsp">Volver a calculadora</a>
</body>
</html>