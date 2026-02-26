package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class productos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<a href='menuUser.jsp'>Menu principal</a>");
        out.print("<br>");

        try {
            Conexion laConexion = new Conexion();

            ArrayList<Consola> consolas = laConexion.infoConsola();
            ArrayList<Juego> juegos = laConexion.infoJuegos();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Productos</title>");
            out.println("<style>");
            out.println("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
            out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Productos</h1>");

            if (consolas.isEmpty() && juegos.isEmpty()) {
                out.println("<h3>No se ha encontrado ningún producto</h3>");
            } else {
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Tipo</th>");
                out.println("<th>Nombre</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("</tr>");

                // Consolas
                for (Consola consola : consolas) {
                    out.println("<tr>");
                    out.println("<td>Consola</td>");
                    out.println("<td>" + consola.getNombre() + "</td>");
                    out.println("<td>" + consola.getPrecio() + "€</td>");
                    out.println("<td>" + consola.getUnidades() + "</td>");
                    out.println("</tr>");
                }

                // Juegos
                for (Juego juego : juegos) {
                    out.println("<tr>");
                    out.println("<td>Juego</td>");
                    out.println("<td>" + juego.getNombre() + "</td>");
                    out.println("<td>" + juego.getPrecio() + "€</td>");
                    out.println("<td>" + juego.getUnidades() + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
            }

            out.print("<a href='menuUser.jsp'>Menu principal</a>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println("<h2>Error al obtener los productos</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.print("<a href='index.html'>Volver al index</a>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
