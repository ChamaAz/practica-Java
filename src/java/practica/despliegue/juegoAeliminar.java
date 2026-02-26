package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class juegoAeliminar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String nombre = request.getParameter("nombre");
        
        Juego juego = new Juego(id, nombre);
        
        // Inicia la respuesta HTML con los estilos que has proporcionado
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Eliminar Juego</title>");
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
        
        try {
            Conexion conexion = new Conexion();
            conexion.eliminarJuego(juego);
            out.println("<h2>Juego eliminado</h2>");
            out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
            out.print("<br>");
            out.print("<a href='eliminarJuego'>Volver</a>");
            out.print("<br><br>");
        } catch (Exception e) {
            out.println("<h2 class='error'>Error al eliminar el juego</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
            out.print("<br>");
            out.print("<a href='eliminarJuego'>Volver</a>");
            out.print("<br><br>");
        }
        
        // Cierra el cuerpo y la etiqueta HTML
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
