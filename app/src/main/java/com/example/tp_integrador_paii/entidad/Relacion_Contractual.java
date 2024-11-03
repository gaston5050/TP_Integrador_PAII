package com.example.tp_integrador_paii.entidad;

public class Relacion_Contractual {
    private Integer id;
    private String descripcion;

    public Relacion_Contractual() {
    }

    public Relacion_Contractual(String descripcion) {
        this.descripcion = descripcion;
    }

    public Relacion_Contractual(Integer id, String descripcion) {
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
        return "Relacion_Contractual{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
