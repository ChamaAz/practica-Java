package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class insertarJuego extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String nombre = request.getParameter("nombre");
        String compania = request.getParameter("compania");
        String genero = request.getParameter("genero");
        String puntuacion = request.getParameter("puntuacion");
        String precioStr = request.getParameter("precio");
        int precio = Integer.parseInt(precioStr);
        String unidadesStr = request.getParameter("unidades");
        int unidades = Integer.parseInt(unidadesStr);
        
        Juego juego = new Juego(0, nombre, compania, genero, precio, precio, unidades);
        
        try {
            Conexion conexion = new Conexion();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f2f2f2;");
            out.println("    color: #333;");
            out.println("    margin: 0;");
            out.println("    padding: 20px;");
            out.println("}");
            out.println("h2 {");
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
            
            if (conexion.insertarJuego(juego)) {
                out.println("<form>");
                out.println("<h2>Juego añadido correctamente</h2>");
                out.println("<a href='menuAdmin.jsp'>Volver al menú principal</a>");
                out.println("</form>");
            } else {
                out.println("<form>");
                out.println("<h2>Fallo al añadir el juego</h2>");
                out.println("<a href='menuAdmin.jsp'>Volver al menú principal</a>");
                out.println("</form>");
            }
            
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f2f2f2;");
            out.println("    color: #333;");
            out.println("    margin: 0;");
            out.println("    padding: 20px;");
            out.println("}");
            out.println("h2 {");
            out.println("    color: red;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("form {");
            out.println("    background-color: #ffffff;");
            out.println("    padding: 20px;");
            out.println("    border-radius: 8px;");
            out.println("    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);");
            out.println("    max-width: 600px;");
            out.println("    margin: 0 auto;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<h2>Error al insertar el juego</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("<a href='menuAdmin.jsp'>Volver al menú principal</a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para insertar juegos con estilos CSS integrados";
    }
}
