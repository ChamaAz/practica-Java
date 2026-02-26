package practica.despliegue;

import java.util.ArrayList;

public class Consola {
    private int idConsola;
    private String nombre;
    private String cpu;
    private String gpu;
    private String compania;
    private int precio;
    private int unidades;
    private int generacion;

    public Consola(int idConsola, String nombre, String cpu, String gpu, String compania, int precio, int unidades, int generacion) {
        this.idConsola = idConsola;
        this.nombre = nombre;
        this.cpu = cpu;
        this.gpu = gpu;
        this.compania = compania;
        this.precio = precio;
        this.unidades = unidades;
        this.generacion = generacion;
    }

    public Consola(int idConsola, String nombre) {
        this.idConsola = idConsola;
        this.nombre = nombre;
    }
    
    

    public int getIdConsola() {
        return idConsola;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public String getCompania() {
        return compania;
    }

    public int getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setIdConsola(int idConsola) {
        this.idConsola = idConsola;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    void add(ArrayList<Consola> consolas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
