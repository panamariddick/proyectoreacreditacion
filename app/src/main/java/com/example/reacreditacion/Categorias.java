package com.example.reacreditacion;

class Categorias {
    private int icono;
    private String nombre;
    private String descripcion;


    public Categorias(int icono, String nombre, String descripcion) {
        this.icono = icono;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIcono() {
        return icono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
