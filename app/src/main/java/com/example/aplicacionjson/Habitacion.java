package com.example.aplicacionjson;

public class Habitacion {
    private Boolean encendido;
    private String nombre;

    public Habitacion(String nombre, Boolean encendido) {
        this.encendido = encendido;
        this.nombre = nombre;
    }

    public Boolean getEncendido() {
        return encendido;
    }

    public void setEncendido(Boolean encendido) {
        this.encendido = encendido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
