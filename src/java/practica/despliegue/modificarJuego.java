package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class modificarJuego extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            Conexion laConexion = new Conexion();
            ArrayList<Juego> juegos = laConexion.obtenerNombreJuegos();
            
            if (juegos.isEmpty()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>No juegos encontrados</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; color: #333; margin: 0; padding: 20px; }");
                out.println("h2, h3 { color: #555; text-align: center; }");
                out.println("a { color: #666; text-decoration: none; font-size: 14px; margin: 10px 0; display: block; text-align: center; }");
                out.println("a:hover { text-decoration: underline; color: #444; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3>No se ha encontrado ningun juego</h3>");
                out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
                out.print("<a href='modificarProductoMenu.jsp'>Volver</a>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Modificar juego</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; color: #333; margin: 0; padding: 20px; }");
                out.println("h2 { color: #555; text-align: center; }");
                out.println("select, input { display: block; margin: 10px auto; padding: 10px; font-size: 16px; }");
                out.println("a { color: #666; text-decoration: none; font-size: 14px; margin: 10px 0; display: block; text-align: center; }");
                out.println("a:hover { text-decoration: underline; color: #444; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
            
                out.println("<form action='juegoAmodificar' method='post'>");
                out.println("<h2>Selecciona un juego a modificar</h2>");
                out.println("<select name='id'>");
                    for (Juego juego : juegos) {
                        out.println("<option value='" + juego.getId() + "'>" + juego.getNombre() + "</option>");
                    }
                out.println("</select>");
                out.println("<input type='submit' value='Modificar'>");
                out.println("</form>");
                out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
                out.print("<a href='modificarProductoMenu.jsp'>Volver</a>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error al obtener juegos</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; color: #333; margin: 0; padding: 20px; }");
            out.println("h2 { color: #ff0000; text-align: center; }");
            out.println("p { color: #555; text-align: center; }");
            out.println("a { color: #666; text-decoration: none; font-size: 14px; margin: 10px 0; display: block; text-align: center; }");
            out.println("a:hover { text-decoration: underline; color: #444; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Error al obtener los juegos</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
            out.print("<a href='modificarProductoMenu.jsp'>Volver</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
