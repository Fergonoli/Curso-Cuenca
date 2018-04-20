<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora</title>
</head>
<body>

<!-- Importar la clase de calculadora  -->
<%@ page import="usuarios.calculadora" %>

<!-- Importar la clase de jpanel  -->
<%@ page import="java.util.*" %>
<%@ page import="javax.swing.*" %>


<h1>Calculadora</h1>

<form action="resultado.jsp" method="post">

		<input type="number" name="operandoIzq" id="operandoIzq" placeholder="Introduce numero" required>
		<br>
		<br>
		<input type="number" name="operandoDch" id="operandoDch" placeholder="Introduce numero" required>
		<br>
		<br>
		<select name="operador">
		   <option value="suma">Suma</option> 
		   <option value="resta">Resta</option> 
		   <option value="multiplicacion">Multiplicacion</option> 
		   <option value="division">Division</option>
		   <option value="exponencial">Exponencial</option>
		   <option value="divisible">Divisible</option>
		</select>
		<br>
		<br>
		
		<input type="submit" id="calcular" value="Calcular">
		
</form>
<br>
<br>
<a href="bienvenida.jsp">Volver a principal</a>
</body>
</html>