package practica.despliegue;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {

    private Connection laConexion;

    public Conexion() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.laConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "daw2", "1234");
    }

    public int comprobarUsuario(String username, String pass) throws Exception {
        // Consulta para seleccionar el usuario con su contraseña y estado de admin
        String consulta = "SELECT * FROM usuarios WHERE nombreUser=? AND password=?";
        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        // Asignamos los parámetros al PreparedStatement
        elStatementPreparado.setString(1, username);
        elStatementPreparado.setString(2, pass);

        // Ejecutamos la consulta
        ResultSet elResultado = elStatementPreparado.executeQuery();

        // Comprobamos si encontramos el usuario
        if (elResultado.absolute(1)) {
            // Recuperamos el valor de esAdmin (en este caso un TINYINT, pero en Java lo manejamos como un int)
            int esAdmin = elResultado.getInt("esAdmin");

            // Cerramos recursos
            elStatementPreparado.close();
            elResultado.close();

            // Determinamos el tipo de usuario
            if (esAdmin == 1) {
                return 1;  // Es un administrador
            } else if (esAdmin == 0) {
                return 2;  // Es un usuario normal
            }
        } else {
            // Si no encontramos al usuario en la base de datos
            elStatementPreparado.close();
            elResultado.close();
        }
        return 0; // El usuario no existe
    }

    public ArrayList<Consola> infoConsola() throws Exception {
        ArrayList<Consola> consolas = new ArrayList<>();

        String consulta = "SELECT * FROM consolas";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet elResultado = elStatementPreparado.executeQuery();

        while (elResultado.next()) {
            // Obtener los valores de las columnas
            int idConsola = elResultado.getInt("id_consola");
            String nombre = elResultado.getString("nombre");
            String potenciaCpu = elResultado.getString("potencia_cpu");
            String potenciaGpu = elResultado.getString("potencia_gpu");
            String compania = elResultado.getString("compania");
            int precio = elResultado.getInt("precio");
            int unidades = elResultado.getInt("unidades");
            int generacion = elResultado.getInt("generacion");

            Consola consola = new Consola(idConsola, nombre, potenciaCpu, potenciaGpu, compania, precio, unidades, generacion);
            consolas.add(consola);
        }

        elStatementPreparado.close();
        elResultado.close();

        return consolas; // Devolver la lista de consolas
    }

    public ArrayList<Juego> infoxconsola(String consola) throws Exception {
        ArrayList<Juego> juegos = new ArrayList<>();

        String consulta = "SELECT * FROM juegos j INNER JOIN juego_consola jc ON j.id_juego = jc.id_juego INNER JOIN consolas c ON jc.id_consola = c.id_consola WHERE c.nombre = ?;";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        elStatementPreparado.setString(1, consola);

        ResultSet elResultado = elStatementPreparado.executeQuery();

        while (elResultado.next()) {
            int idJuego = elResultado.getInt("id_juego");
            String nombre = elResultado.getString("nombre");
            String compania = elResultado.getString("compania_desarrolladora");
            String genero = elResultado.getString("genero");
            int puntuacion = elResultado.getInt("puntuacion_metacritic");
            int precio = elResultado.getInt("precio");
            int unidades = elResultado.getInt("unidades_disponibles");

            Juego juego = new Juego(idJuego, nombre, compania, genero, puntuacion, precio, unidades);
            juegos.add(juego);
        }

        elStatementPreparado.close();
        elResultado.close();

        return juegos;
    }

    public ArrayList<Juego> infoJuegos() throws Exception {
        ArrayList<Juego> juegos = new ArrayList<>();

        String consulta = "SELECT * FROM juegos";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet elResultado = elStatementPreparado.executeQuery();

        while (elResultado.next()) {
            int idJuego = elResultado.getInt("id_juego");
            String nombre = elResultado.getString("nombre");
            String compania = elResultado.getString("compania_desarrolladora");
            String genero = elResultado.getString("genero");
            int puntuacion = elResultado.getInt("puntuacion_metacritic");
            int precio = elResultado.getInt("precio");
            int unidades = elResultado.getInt("unidades_disponibles");

            Juego juego = new Juego(idJuego, nombre, compania, genero, puntuacion, precio, unidades);
            juegos.add(juego);
        }

        elStatementPreparado.close();
        elResultado.close();

        return juegos; // Devolver la lista de consolas
    }

    public boolean insertarConsola(Consola consola) throws SQLException {

        String consulta = "INSERT INTO consolas (id_consola, nombre, potencia_cpu, potencia_gpu, compania, precio, unidades, generacion) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta);
        elStatementPreparado.setInt(1, consola.getIdConsola());
        elStatementPreparado.setString(2, consola.getNombre());
        elStatementPreparado.setString(3, consola.getCpu());
        elStatementPreparado.setString(4, consola.getGpu());
        elStatementPreparado.setString(5, consola.getCompania());
        elStatementPreparado.setInt(6, consola.getPrecio());
        elStatementPreparado.setInt(7, consola.getUnidades());
        elStatementPreparado.setInt(8, consola.getGeneracion());

        elStatementPreparado.executeUpdate();
        this.laConexion.close();
        elStatementPreparado.close();
        return true;
    }

    public boolean insertarJuego(Juego juego) throws SQLException {

        String consulta = "INSERT INTO juegos (id_juego, nombre, compania_desarrolladora, genero, puntuacion_metacritic, precio, unidades_disponibles) "
                + "VALUES(?,?,?,?,?,?,?)";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta);
        elStatementPreparado.setInt(1, juego.getId());
        elStatementPreparado.setString(2, juego.getNombre());
        elStatementPreparado.setString(3, juego.getCompania());
        elStatementPreparado.setString(4, juego.getGenero());
        elStatementPreparado.setInt(5, juego.getPuntuacion());
        elStatementPreparado.setInt(6, juego.getPrecio());
        elStatementPreparado.setInt(7, juego.getUnidades());

        elStatementPreparado.executeUpdate();
        this.laConexion.close();
        elStatementPreparado.close();
        return true;
    }

    public ArrayList<Consola> obtenerNombreConsolas() throws SQLException {
        ArrayList<Consola> consolas = new ArrayList<>();

        String consulta = "SELECT id_consola, nombre nombre FROM consolas";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet elResultado = elStatementPreparado.executeQuery();

        while (elResultado.next()) {
            int id = elResultado.getInt("id_consola");
            String nombre = elResultado.getString("nombre");

            Consola consola = new Consola(id, nombre);
            consolas.add(consola);
        }

        elStatementPreparado.close();
        elResultado.close();

        return consolas;
    }

    public Consola infoConsolaModificar(int id) throws Exception {
        int idConsola = 0;
        String nombre = "";
        String potenciaCpu = "";
        String potenciaGpu = "";
        String compania = "";
        int precio = 0;
        int unidades = 0;
        int generacion = 0;

        String consulta = "SELECT * FROM consolas WHERE id_consola=?;";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta);

        elStatementPreparado.setInt(1, id);

        ResultSet elResultado = elStatementPreparado.executeQuery();

        while (elResultado.next()) {
            idConsola = elResultado.getInt("id_consola");
            nombre = elResultado.getString("nombre");
            potenciaCpu = elResultado.getString("potencia_cpu");
            potenciaGpu = elResultado.getString("potencia_gpu");
            compania = elResultado.getString("compania");
            precio = elResultado.getInt("precio");
            unidades = elResultado.getInt("unidades");
            generacion = elResultado.getInt("generacion");
        }
        Consola consola1 = new Consola(idConsola, nombre, potenciaCpu, potenciaGpu, compania, precio, unidades, generacion);

        elStatementPreparado.close();
        elResultado.close();

        return consola1;
    }

    public void modificarConsola(Consola consola) throws Exception {
        String consulta = "UPDATE consolas SET nombre=?, potencia_cpu=?, potencia_gpu=?, compania=?, precio=?, unidades=?, generacion=? WHERE id_consola=?;";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta);
        elStatementPreparado.setInt(8, consola.getIdConsola());
        elStatementPreparado.setString(1, consola.getNombre());
        elStatementPreparado.setString(2, consola.getCpu());
        elStatementPreparado.setString(3, consola.getGpu());
        elStatementPreparado.setString(4, consola.getCompania());
        elStatementPreparado.setInt(5, consola.getPrecio());
        elStatementPreparado.setInt(6, consola.getUnidades());
        elStatementPreparado.setInt(7, consola.getGeneracion());

        elStatementPreparado.executeUpdate();

        elStatementPreparado.close();

    }

    public ArrayList<Juego> obtenerNombreJuegos() throws SQLException {
        ArrayList<Juego> juegos = new ArrayList<>();

        String consulta = "SELECT id_juego, nombre nombre FROM juegos";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet elResultado = elStatementPreparado.executeQuery();

        while (elResultado.next()) {
            int id = elResultado.getInt("id_juego");
            String nombre = elResultado.getString("nombre");

            Juego juego = new Juego(id, nombre);
            juegos.add(juego);
        }

        elStatementPreparado.close();
        elResultado.close();

        return juegos;
    }

    public Juego infoJuegoModificar(int id) throws Exception {
        int idJuego = 0;
        String nombre = "";
        String compania = "";
        String genero = "";
        int puntuacion = 0;
        int precio = 0;
        int unidades = 0;

        String consulta = "SELECT * FROM juegos WHERE id_juego=?;";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta);

        elStatementPreparado.setInt(1, id);

        ResultSet elResultado = elStatementPreparado.executeQuery();

        while (elResultado.next()) {
            idJuego = elResultado.getInt("id_juego");
            nombre = elResultado.getString("nombre");
            compania = elResultado.getString("compania_desarrolladora");
            genero = elResultado.getString("genero");
            puntuacion = elResultado.getInt("puntuacion_metacritic");
            precio = elResultado.getInt("precio");
            unidades = elResultado.getInt("unidades_disponibles");
        }

        Juego juego = new Juego(id, nombre, compania, genero, puntuacion, precio, unidades);

        elStatementPreparado.close();
        elResultado.close();

        return juego;
    }

    public void modificarJuego(Juego juego) throws Exception {
        String consulta = "UPDATE juegos SET nombre=?, compania_desarrolladora=?, genero=?, puntuacion_metacritic=?, precio=?, unidades_disponibles=? WHERE id_juego=?;";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta);
        elStatementPreparado.setString(1, juego.getNombre());
        elStatementPreparado.setString(2, juego.getCompania());
        elStatementPreparado.setString(3, juego.getGenero());
        elStatementPreparado.setInt(4, juego.getPuntuacion());
        elStatementPreparado.setInt(5, juego.getPrecio());
        elStatementPreparado.setInt(6, juego.getUnidades());
        elStatementPreparado.setInt(7, juego.getId());

        elStatementPreparado.executeUpdate();

        elStatementPreparado.close();

    }

    public void eliminarConsola(Consola consola) throws Exception {
        String consulta = "DELETE FROM consolas WHERE id_consola = ?";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta);
        elStatementPreparado.setInt(1, consola.getIdConsola());

        elStatementPreparado.executeUpdate();

        elStatementPreparado.close();
    }

    public void eliminarJuego(Juego juego) throws Exception {
        String consulta = "DELETE FROM juegos WHERE id_juego = ?";

        PreparedStatement elStatementPreparado = this.laConexion.prepareStatement(consulta);
        elStatementPreparado.setInt(1, juego.getId());

        elStatementPreparado.executeUpdate();

        elStatementPreparado.close();

    }

}
