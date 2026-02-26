<%@page import="practica.despliegue.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Administrador</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .container {
                background-color: #ffffff;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                padding: 20px;
                width: 400px;
                text-align: center;
            }
            h1 {
                font-size: 24px;
                color: #333333;
                margin-bottom: 20px;
            }
            ol {
                list-style: none;
                padding: 0;
                margin: 0;
            }
            li {
                margin: 15px 0;
            }
            a {
                display: inline-block;
                text-decoration: none;
                font-size: 18px;
                color: #555555;
                padding: 10px 20px;
                border: 1px solid #dddddd;
                border-radius: 5px;
                background-color: #f9f9f9;
                transition: all 0.3s ease;
            }
            a:hover {
                background-color: #dddddd;
                color: #333333;
                border-color: #cccccc;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Menú Principal</h1>
            <ol>
                <li><a href="modificarProductoMenu.jsp">Modificar informacion de producto</a></li>
                <li><a href="insertarProductoMenu.jsp">Insertar un nuevo producto</a></li>
                <li><a href="eliminarProductoMenu.jsp">Eliminar un producto</a></li>
            </ol>
        </div>
    </body>
</html>
