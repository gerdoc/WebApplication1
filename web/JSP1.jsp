<%-- 
    Document   : JSP1
    Created on : 1/04/2022, 12:18:34 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form id="form1" action="Servlet1">
            Dame tu nombre:
            <input id="nombre1" name="nombre1" type="text" />
            <br/>
            Dame tu calificación:
            <input id="calificacion1" name="calificacion1" type="number" />
            <br/>
            <input id="send" type="submit" value="Enviar" />
            <input id="send" type="reset" value="Limpiar" />
            
        </form>
    </body>
</html>
