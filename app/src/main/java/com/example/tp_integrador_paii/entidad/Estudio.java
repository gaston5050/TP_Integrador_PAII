package com.example.tp_integrador_paii.entidad;

public class Estudio {
    private Integer id;
    private String descripcion;

    public Estudio() {
    }

    public Estudio(String descripcion) {
        this.setDescripcion(descripcion);
    }

    public Estudio(Integer id, String descripcion) {
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
        return "Estudio{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
