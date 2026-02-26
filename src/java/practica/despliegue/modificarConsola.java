package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class modificarConsola extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            Conexion laConexion = new Conexion();
            ArrayList<Consola> consolas = laConexion.obtenerNombreConsolas();
            
            if (consolas.isEmpty()) {
                out.println("</table>");
                out.println("<h3>No se ha encontrado ninguna consola</h3>");
                out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
                out.print("<br><br>");
                out.print("<a href='modificarProductoMenu.jsp'>Volver</a>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Modificar consola</title>");
                out.println("<style>");
                out.println("body { font-family: 'Arial', sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh;}");
                out.println(".container { background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); padding: 100px; width: 600px; text-align: center;}");
                out.println("h2 { font-size: 24px; color: #333333; margin-bottom: 20px; }");
                out.println("a { display: inline-block; color: #9e9e9e; text-decoration: none; font-size: 14px; margin-top: 20px; }");
                out.println("a:hover { text-decoration: underline; color: #555555; }");
                out.println(".link-container { margin-top: 20px; }");  // Contenedor para separar los enlaces
                out.println(".link-container a { margin-top: 10px; display: block; }"); // Añadir margen a cada enlace
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                
                out.println("<div class='container'>");
                out.println("<h2>Selecciona la consola a modificar</h2>");
                out.println("<form action='consolaAmodificar' method='post'>");
                out.println("<select name='id'>");
                    for (Consola consola : consolas) {
                        out.println("<option value='" + consola.getIdConsola() + "'>" + consola.getNombre() + "</option>");
                    }
                out.println("</select>");
                out.println("<br><br>");
                out.println("<input type='submit' value='Modificar'>");
                out.println("</form>");
                
                out.println("<div class='link-container'>");
                out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
                out.print("<a href='modificarProductoMenu.jsp'>Volver</a>");
                out.println("</div>");
                
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {
            out.println("<h2>Error al obtener las consolas</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
