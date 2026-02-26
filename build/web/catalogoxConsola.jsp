<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo por Consola</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #e0e0e0; /* Gris claro */
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
                padding: 30px;
                width: 350px;
                text-align: center;
            }
            h1 {
                font-size: 22px;
                color: #333333; /* Gris oscuro */
                margin-bottom: 20px;
            }
            label {
                display: block;
                font-size: 16px;
                color: #555555; /* Gris medio */
                margin-bottom: 10px;
            }
            select, input[type="submit"] {
                width: 100%;
                padding: 12px;
                margin: 10px 0;
                border: 1px solid #cccccc; /* Gris claro */
                border-radius: 4px;
                font-size: 16px;
                background-color: #f9f9f9; /* Gris muy claro */
                color: #555555; /* Gris medio */
            }
            input[type="submit"] {
                background-color: #9e9e9e; /* Gris */
                color: white;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }
            input[type="submit"]:hover {
                background-color: #7e7e7e; /* Gris oscuro */
            }
            a {
                color: #9e9e9e; /* Gris */
                text-decoration: none;
                font-size: 14px;
            }
            a:hover {
                text-decoration: underline;
                color: #555555; /* Gris medio */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Catálogo de Juegos por Consola</h1>
            <form action="catalogoxConsola" method="post">
                <label for="consola">Consola:</label>
                <select id="consola" name="consola">
                    <option value="Xbox one">Xbox One</option>
                    <option value="Xbox S">Xbox S</option>
                    <option value="Xbox X">Xbox X</option>
                    <option value="Nintendo Switch">Nintendo Switch</option>
                    <option value="Nintendo Switch Lite">Nintendo Switch Lite</option>
                    <option value="PS4">PS4</option>
                    <option value="PS5 con CD">PS5 con CD</option>
                    <option value="PS5 sin CD">PS5 sin CD</option>
                </select>
                <input type="submit" value="Buscar">
            </form>
            <br>
            <a href="menuUser.jsp">Menú Principal</a>
        </div>
    </body>
</html>
