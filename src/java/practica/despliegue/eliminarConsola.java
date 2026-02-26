package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class eliminarConsola extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Conexion laConexion = new Conexion();
            ArrayList<Consola> consolas = laConexion.obtenerNombreConsolas();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Eliminar consola</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f2f2f2;");
            out.println("    color: #333;");
            out.println("    margin: 0;");
            out.println("    padding: 20px;");
            out.println("}");
            out.println("h2, h3 {");
            out.println("    color: #555;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("form {");
            out.println("    background-color: #ffffff;");
            out.println("    padding: 20px;");
            out.println("    border-radius: 8px;");
            out.println("    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);");
            out.println("    max-width: 600px;");
            out.println("    margin: 0 auto;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("select {");
            out.println("    width: 95%;");
            out.println("    padding: 10px;");
            out.println("    margin: 10px 0;");
            out.println("    border-radius: 5px;");
            out.println("    border: 1px solid #ccc;");
            out.println("    background-color: #ffffff;");
            out.println("    font-size: 16px;");
            out.println("    color: #555;");
            out.println("}");
            out.println("input[type='submit'] {");
            out.println("    background-color: #cccccc;");
            out.println("    color: #333;");
            out.println("    border: none;");
            out.println("    padding: 10px 15px;");
            out.println("    cursor: pointer;");
            out.println("    border-radius: 5px;");
            out.println("    font-size: 16px;");
            out.println("    display: block;");
            out.println("    margin: 20px auto;");
            out.println("}");
            out.println("input[type='submit']:hover {");
            out.println("    background-color: #b3b3b3;");
            out.println("}");
            out.println("a {");
            out.println("    color: #666;");
            out.println("    text-decoration: none;");
            out.println("    font-size: 14px;");
            out.println("    margin: 10px 0;");
            out.println("    display: block;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("a:hover {");
            out.println("    text-decoration: underline;");
            out.println("    color: #444;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            if (consolas.isEmpty()) {
                out.println("<h3>No se ha encontrado ninguna consola</h3>");
                out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
                out.print("<a href='modificarProductoMenu.jsp'>Volver</a>");
            } else {
                out.println("<form action='consolaAeliminar' method='post'>");
                out.println("<h2>Selecciona una consola a eliminar</h2>");
                out.println("<select name='id'>");
                for (Consola consola : consolas) {
                    out.println("<option value='" + consola.getIdConsola() + "'>" + consola.getNombre() + "</option>");
                }
                out.println("</select>");
                out.println("<input type='submit' value='Eliminar'>");
                out.println("</form>");
                out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
                out.print("<a href='eliminarProductoMenu.jsp'>Volver</a>");
            }

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; color: #333; }");
            out.println("h2 { color: red; text-align: center; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Error al obtener las consolas</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("<a href='menuAdmin.jsp'>Menú principal</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
}
