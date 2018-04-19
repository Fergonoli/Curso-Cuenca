<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="bienvenida.jsp" method="post">

<input type="text" name="nombre" id="nombre" placeholder="Introduce usuario" required>

<br>
<br>

<input type="password" name="password" id="password" placeholder="Introduce password" required>

<p>Asignatura</p><br>
<input type="checkbox" name="matematicas" value="Matematicas">Matematicas<br>
<input type="checkbox" name="lenguaje" value="Lenguaje">Lenguaje<br>
<input type="checkbox" name="ingles" value="Ingles">Ingles<br>
<input type="checkbox" name="informatica" value="Informatica">Informatica<br>

<br>

<p>Sexo</p><br>
<input type="radio" name="sexo" value="Hombre">Hombre<br>
<input type="radio" name="sexo" value="Mujer">Mujer<br>




<br>
<br>

<!-- El tipo de button debe ser un submit, para que al clickear los datos
     de los inputs de arriba se tomen correctamente -->
<input type="submit" id="login" value="Acceder">

 

</form>

</body>
</html>