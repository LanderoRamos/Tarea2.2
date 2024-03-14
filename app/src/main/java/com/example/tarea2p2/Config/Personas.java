package com.example.tarea2p2.Config;

public class Personas
{
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String fechanac;
    private String foto;

    public Personas()
    {

    }
    public Personas(String id, String nombres, String apellidos, String telefono, String fechanac, String foto) {
        this.id = id;
        this.nombre = nombres;
        this.apellido = apellidos;
        this.telefono = telefono;
        this.fechanac = fechanac;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
