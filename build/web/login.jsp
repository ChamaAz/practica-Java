<%@page import="practica.despliegue.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <%
            String usuario=request.getParameter("user");
            String password=request.getParameter("password");
        
            Conexion conexion=new Conexion();
            
            if(conexion.comprobarUsuario(usuario, password)==1){
                //es admin
                response.sendRedirect("menuAdmin.jsp");
            }else if(conexion.comprobarUsuario(usuario, password)==2){
                //es user
                response.sendRedirect("menuUser.jsp");
            }else if(conexion.comprobarUsuario(usuario, password)==0){
                out.println("<h2>Usuario incorrecto</h2>");
                response.sendRedirect("index.html");
            }
        
        
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
