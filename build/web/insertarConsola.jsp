<%@page import="practica.despliegue.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de Consola</title>
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
            input[type="text"], input[type="number"], input[type="radio"] {
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
        <h2>Registrar nueva consola</h2>
        <form action='insertarConsola' method='post'>
            <label for="nombre">Nombre:</label>
            <input type='text' id="nombre" name='nombre' required>

            <label for="potenciaCPU">Potencia CPU:</label>
            <input type='text' id="potenciaCPU" name='potenciaCPU' required>

            <label for="potenciaGPU">Potencia GPU:</label>
            <input type='text' id="potenciaGPU" name='potenciaGPU' required>

            <label for="compania">Compañía:</label>
            <input type='text' id="compania" name='compania' required>

            <label for="precio">Precio:</label>
            <input type='number' id="precio" name='precio' required>

            <label for="unidades">Unidades disponibles:</label>
            <input type='number' id="unidades" name='unidades' required>

            <label>Generación:</label><br>
            <input type='radio' id="generacion1" name='generacion' value='1' required>
            <label for="generacion1">1ª</label>
            <input type='radio' id="generacion2" name='generacion' value='2'>
            <label for="generacion2">2ª</label><br>

            <input type='submit' value='Enviar'>  
            <br>
            <a href="insertarProductoMenu.jsp">Volver</a>
            <br>
            <a href="menuAdmin.jsp">Menu principal</a>
        </form>
        <br><br>
        
    </body>
</html>
