package com.example.tp_integrador_paii.entidad;

public class Conforme {
    private Integer id;
    private String descripcion;

    // Constructor vacío
    public Conforme() {
    }

    // Constructor con parámetros
    public Conforme(String descripcion) {
        this.setDescripcion(descripcion);
    }

    public Conforme(Integer id, String descripcion) {
        this.setId(id);
        this.setDescripcion(descripcion);
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
        return "Conforme{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
