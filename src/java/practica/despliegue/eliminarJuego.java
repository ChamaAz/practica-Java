package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class eliminarJuego extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    try {
            Conexion laConexion = new Conexion();
            ArrayList<Juego> juegos = laConexion.obtenerNombreJuegos();
            
            if (juegos.isEmpty()) {
                out.println("</table>");
                out.println("<h3>No se ha encontrado ningun juego</h3>");
                out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
                out.print("<br><br>");
                out.print("<a href='eliminarProductoMenu.jsp'>Volver</a>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Eliminar juego</title>");
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
            
                out.println("<form action='juegoAeliminar' method='post'>");
                out.println("<h2>Selecciona un juego a eliminar</h2>");
                out.println("<select name='id'>");
                    for (Juego juego : juegos) {
                        out.println("<option value='" + juego.getId()+ "'>" + juego.getNombre() + "</option>");
                    }
                out.println("</select>");
                out.println("<br><br>");
                out.println("<input type='submit' value='Eliminar'>");
                out.println("</form>");
                out.print("<br><br>");
                out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
                out.print("<br>");
                out.print("<a href='eliminarProductoMenu.jsp'>Volver</a>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {
            out.println("<h2>Error al obtener los juegos</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
