<%-- 
    Document   : Formulario
    Created on : 1/04/2022, 01:25:14 PM
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
        <form id="form1" action="MayorMenorServlet" >
            <h2>Escribe un nombre 1</h2>
            <input id="nombre1" name="nombre1" type="text" />
            <h2>Escribe la edad 1</h2>
            <input id="edad1" name="edad1" type="number" />
            <h2>Escribe un nombre 2</h2>
            <input id="nombre2" name="nombre2" type="text" />
            <h2>Escribe la edad 2</h2>
            <input id="edad2" name="edad2" type="number" />
            <br/><br/><br/>
            <input id="ok" name="ok" type="submit" value="Enviar" />
            <input id="ok" name="clean" type="reset" value="Limpiar"/>
            
        
            
        </form>
    </body>
</html>
