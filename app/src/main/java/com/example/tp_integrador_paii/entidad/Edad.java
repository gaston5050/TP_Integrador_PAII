package com.example.tp_integrador_paii.entidad;

public class Edad {
    private Integer id;
    private String descripcion;

    public Edad() {
    }

    public Edad(String descripcion) {
        this.descripcion = descripcion;
    }

    public Edad(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Edad{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
}
