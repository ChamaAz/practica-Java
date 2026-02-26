package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class infoConsolas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<a href='menuUser.jsp'>Menú principal</a>");
        out.print("<br>");

        try {
            Conexion laConexion = new Conexion();
            ArrayList<Consola> consolas = laConexion.infoConsola();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Catálogo de Consolas</title>");
            out.println("<style>");
            out.println("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
            out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("h1, h3 { text-align: center; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Información de Consolas</h1>");

            if (consolas.isEmpty()) { 
                out.println("<h3>No se ha encontrado ninguna consola</h3>");
            } else {
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>CPU</th>");
                out.println("<th>GPU</th>");
                out.println("<th>Compañía</th>");
                out.println("<th>Precio (€)</th>");
                out.println("<th>Unidades Disponibles</th>");
                out.println("<th>Generación</th>");
                out.println("</tr>");

                for (Consola consola : consolas) {
                    out.println("<tr>");
                    out.println("<td>" + consola.getNombre() + "</td>");
                    out.println("<td>" + consola.getCpu() + "</td>");
                    out.println("<td>" + consola.getGpu() + "</td>");
                    out.println("<td>" + consola.getCompania() + "</td>");
                    out.println("<td>" + consola.getPrecio() + "</td>");
                    out.println("<td>" + consola.getUnidades() + "</td>");
                    out.println("<td>" + consola.getGeneracion() + "ª</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
            }

            out.print("<a href='menuUser.jsp'>Menú principal</a>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println("<h2>Error al obtener las consolas</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.print("<a href='index.html'>Volver al index</a>");
        }
    }
}
