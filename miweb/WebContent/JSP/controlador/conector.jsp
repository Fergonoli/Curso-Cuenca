<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%@ page import = "java.sql.*" %>
  <%
  //Funciones para realizar la conexion con la BBDD
  Class.forName("com.mysql.jdbc.Driver");
  
  //En la url de getConnection, es importante quitarle el puerto, y direccionar a la BBDD correcta, 
  //con usuario root y sin contrseña
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "");
  
      // Connection conn =
      //    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
      
      //Con esta instruccion realizamos la conexion con la BBDD
      Statement stmt = conn.createStatement();

      //En una variable String almacenamos la instruccion SQL que queremos lanzar
      String sqlStr = "SELECT * FROM alumno";

      // Se puede quitar
      System.out.println("Query statement is " + sqlStr);
      
      //Con esta funcion ejecutamos la Instruccion SQL creada arriba, y carga la informacion en la variable rset
      ResultSet rset = stmt.executeQuery(sqlStr);
  %>
      <hr>
      <form method="get" action="order.jsp">
        <table border=1 cellpadding=5>
          <tr>
            <th>Order</th>
            <th>Author</th>
            <th>Title</th>
          </tr>
  <%
  	  // Para recorrer la tabla entera se hace un while con .next() que mientras haya elementos los vaya sacando
  	  // hasta recorrerlos todos
      while (rset.next()) {
    	  
    	//Esto es para asociar el id a los values del checkbox del ejemplo, irrelevante
        int id = rset.getInt("id");
  %>
          <tr>
            <td><input type="checkbox" name="id" value="<%= id %>"></td>
            
            <!-- con el metodo getString("Nombre de atributo") sacas el valor de cada celda  -->
            <td><%= rset.getString("dni") %></td>
            <td><%= rset.getString("nombre") %></td>
          </tr>
  <%
      }
  %>
        </table>
        <br>
        <input type="submit" value="Order">
        <input type="reset" value="Clear">
      </form>
      <a href="<%= request.getRequestURI() %>"><h3>Back</h3></a>
  <%
  
  	  //Por ultimo es importante cerrar el conector, la consulta y todo.
      rset.close();
      stmt.close();
      conn.close();
    
  %>
</body>
</html>