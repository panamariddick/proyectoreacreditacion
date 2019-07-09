package com.example.reacreditacion;

public class NombreActividades {
    private String nombre_actividad, fecha_actividad, tipo_actividad, publico_actividad;

    public NombreActividades(String nombre_actividad, String fecha_actividad, String tipo_actividad, String publico_actividad) {
        this.nombre_actividad = nombre_actividad;
        this.fecha_actividad = fecha_actividad;
        this.tipo_actividad = tipo_actividad;
        this.publico_actividad = publico_actividad;


    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public String getFecha_actividad() {
        return fecha_actividad;
    }

    public void setFecha_actividad(String fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }

    public String getTipo_actividad() {
        return tipo_actividad;
    }

    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    public String getPublico_actividad() {
        return publico_actividad;
    }

    public void setPublico_actividad(String publico_actividad) {
        this.publico_actividad = publico_actividad;
    }


}
