<%@page import="practica.despliegue.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>   
<html>   
    <head>   
        <title>Registro de Juego</title>   
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                color: #333;
                margin: 0;
                padding: 20px;
            }
            h2 {
                color: #555;
                text-align: center;
            }
            form {
                background-color: #ffffff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                max-width: 600px; /* Ajusta este valor para darle más ancho */
                margin: 0 auto;
            }
            input[type="text"], input[type="number"] {
                width: 95%;
                padding: 10px;
                margin: 10px 0;
                border-radius: 5px;
                border: 1px solid #ccc;
                background-color: #f9f9f9;
                font-size: 16px;
                color: #555;
            }
            input[type="radio"] {
                width: auto;
            }
            input[type="submit"] {
                background-color: #cccccc;
                color: #333;
                border: none;
                padding: 10px 15px;
                cursor: pointer;
                border-radius: 5px;
                font-size: 16px;
                display: block;
                margin: 20px auto;
            }
            input[type="submit"]:hover {
                background-color: #b3b3b3;
            }
            a { 
                color: #666; 
                text-decoration: none; 
                font-size: 14px; 
                margin: 10px 0; 
                display: block; 
                text-align: center; 
            }
            a:hover { 
                text-decoration: underline; 
                color: #444; 
            }
        </style>
    </head>   
    
    <body>   
        <h2>Registrar un nuevo juego</h2>   
        <form action='insertarJuego' method='post'>   
            Nombre: <input type='text' name='nombre'><br>   
            Compañia desarrolladora CPU: <input type='text' name='compania'><br>   
            genero: <input type='text' name='genero'><br>   
            Puntuacion en Metacritic: <input type='number' name='puntuacion'><br>   
            Precio: <input type='number' name='precio'><br>   
            Unidades disponibles: <input type='number' name='unidades'><br>   
            <br><br>   
            <input type='submit' value='Enviar'>
            <br>
            <a href="insertarProductoMenu.jsp">Volver</a>
            <br>
            <a href="menuAdmin.jsp">Menu principal</a>
        </form>   

    </body>   
</html>   
