package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class juegoAmodificar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
        out.print("<br>");
        out.print("<a href='modificarJuego'>Volver</a>");
        out.print("<br><br>");
        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        
        try {
            Conexion laConexion = new Conexion();
            Juego juego = laConexion.infoJuegoModificar(id);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Información de juego</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; color: #333; margin: 0; padding: 20px; }");
            out.println("h1 { color: #555; text-align: center; }");
            out.println("form { background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); max-width: 400px; margin: 0 auto;}");
            out.println("input, select { width: 100%; padding: 10px; margin: 10px 0; border-radius: 5px; border: 1px solid #ccc; background-color: #f9f9f9; font-size: 16px; color: #555; }");
            out.println("input[type='submit'] { background-color: #cccccc; color: #333; border: none; cursor: pointer;}");
            out.println("input[type='submit']:hover { background-color: #b3b3b3; }");
            out.println(".link-container { margin-top: 20px; text-align: center; }");
            out.println(".link-container a { margin-top: 10px; display: block; color: #666; text-decoration: none; font-size: 14px; }");
            out.println(".link-container a:hover { text-decoration: underline; color: #444; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Información del juego</h1>");
            out.println("<form action='modificarJuegoConsulta' method='post'>");
            out.println("ID: " + juego.getId() + "<br>");
            out.println("<input type='hidden' name='id' value='" + juego.getId() + "'><br>");
            out.println("Nombre: <input type='text' name='nombre' value='" + juego.getNombre() + "'><br>");
            out.println("Compañía: <input type='text' name='compania' value='" + juego.getCompania() + "'><br>");
            out.println("Género: <input type='text' name='genero' value='" + juego.getGenero() + "'><br>");
            out.println("Puntuación: <input type='number' name='puntuacion' value='" + juego.getPuntuacion() + "'><br>");
            out.println("Precio: <input type='number' name='precio' value='" + juego.getPrecio() + "'><br>");
            out.println("Unidades disponibles: <input type='number' name='unidades' value='" + juego.getUnidades() + "'><br>");
            out.println("<input type='submit' value='Guardar cambios'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println("<h2>Error al obtener el juego</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
            out.print("<br>");
            out.print("<a href='modificarJuego'>Volver</a>");
            out.print("<br><br>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
