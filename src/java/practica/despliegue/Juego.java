package practica.despliegue;

public class Juego {
    private int id;
    private String nombre;
    private String compania;
    private String genero;
    private int puntuacion;
    private int precio;
    private int unidades;

    public Juego(int id, String nombre, String compania, String genero, int puntuacion, int precio, int unidades) {
        this.id = id;
        this.nombre = nombre;
        this.compania = compania;
        this.genero = genero;
        this.puntuacion = puntuacion;
        this.precio = precio;
        this.unidades = unidades;
    }

    public Juego(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    

    public Juego(String nombre) {
        this.nombre = nombre;
    }
    
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCompania() {
        return compania;
    }

    public String getGenero() {
        return genero;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    
    
    
    
}
