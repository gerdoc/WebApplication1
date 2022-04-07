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
            <%
                for( int i =0; i< 5; i++)
                {
            %>
                    Dame tu nombre <%=i+1%>:
                    <input id="nombre<%=i+1%>" name="nombre<%=i+1%>" type="text" />
                    <br/>
                    Dame tu calificación <%=i+1%>:
                    <input id="calificacion<%=i+1%>" name="calificacion<%=i+1%>" type="number" />
                    <br/>                    
            <%
                }
            %>
            
            <input id="send" type="submit" value="Enviar" />
            <input id="limpiar" type="reset" value="Limpiar" />
            
        </form>
    </body>
</html>
