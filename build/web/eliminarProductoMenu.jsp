<%@page import="practica.despliegue.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo de Producto</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4; /* Gris claro */
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .container {
                background-color: #ffffff;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                padding: 100px;
                width: 600px;
                text-align: center;
            }
            h2 {
                font-size: 24px;
                color: #333333; /* Gris oscuro */
                margin-bottom: 20px;
            }
            a {
                display: inline-block;
                color: #9e9e9e; /* Gris */
                text-decoration: none;
                font-size: 14px;
                margin-top: 20px;
            }
            a:hover {
                text-decoration: underline;
                color: #555555; /* Gris medio */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Elige que tipo de producto vas a eliminar</h2>
            <a href="eliminarConsola">Eliminar consola</a><br>
            <a href="eliminarJuego">Eliminar juego</a><br><br>
            
            <a href="menuAdmin.jsp">Volver</a>
        </div>
       
    </body>
</html>
