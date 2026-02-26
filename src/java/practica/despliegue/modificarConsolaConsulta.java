package practica.despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class modificarConsolaConsulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String nombre = request.getParameter("nombre");
        String potenciaCPU = request.getParameter("potenciaCPU");
        String potenciaGPU = request.getParameter("potenciaGPU");
        String compania = request.getParameter("compania");
        String precioStr = request.getParameter("precio");
        int precio = Integer.parseInt(precioStr);
        String unidadesStr = request.getParameter("unidades");
        int unidades = Integer.parseInt(unidadesStr);
        String generacionStr = request.getParameter("generacion");
        int generacion = Integer.parseInt(generacionStr);
        
        Consola consola = new Consola(id, nombre, potenciaCPU, potenciaGPU, compania, precio, unidades, generacion);
        
        try {
            Conexion conexion = new Conexion();
            conexion.modificarConsola(consola);
            
            // Estilo minimalista con tonos grises
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consola Modificada</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; color: #333; margin: 0; padding: 20px; }");
            out.println("h2 { color: #555; text-align: center; }");
            out.println("a { color: #666; text-decoration: none; font-size: 14px; margin: 10px 0; display: block; text-align: center; }");
            out.println("a:hover { text-decoration: underline; color: #444; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Consola modificada con éxito</h2>");
            out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
            out.print("<a href='modificarConsola'>Volver</a>");
            out.print("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; color: #333; margin: 0; padding: 20px; }");
            out.println("h2 { color: #ff0000; text-align: center; }");
            out.println("a { color: #666; text-decoration: none; font-size: 14px; margin: 10px 0; display: block; text-align: center; }");
            out.println("a:hover { text-decoration: underline; color: #444; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Error al modificar la consola</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.print("<a href='menuAdmin.jsp'>Menú principal</a>");
            out.print("<a href='consolaAmodificar'>Volver</a>");
            out.print("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
