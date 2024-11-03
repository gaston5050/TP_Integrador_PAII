package com.example.tp_integrador_paii.entidad;

public class Salario {
    private Integer id;
    private String descripcion;

    public Salario() {
    }

    public Salario(String descripcion) {
        this.setDescripcion(descripcion);
    }

    public Salario(Integer id, String descripcion) {
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
        return "Salario{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
