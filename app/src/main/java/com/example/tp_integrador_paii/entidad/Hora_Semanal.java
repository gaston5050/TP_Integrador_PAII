package com.example.tp_integrador_paii.entidad;

public class Hora_Semanal {
    private Integer id;
    private String descripcion;

    public Hora_Semanal() {
    }

    public Hora_Semanal(String descripcion) {
        this.setDescripcion(descripcion);
    }

    public Hora_Semanal(Integer id, String descripcion) {
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
        return "Hora_Semanal{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
