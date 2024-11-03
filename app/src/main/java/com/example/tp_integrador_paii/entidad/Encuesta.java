package com.example.tp_integrador_paii.entidad;

public class Encuesta {
    private Integer id;
    private Sexo id_sexo;
    private Estudio id_estudio;
    private Edad id_edad;
    private Trabajo id_trabajo;
    private Relacion_Contractual id_relacion_contractual;
    private Rubro id_rubro;
    private Hora_Semanal id_hora_semanal;
    private Antiguedad id_antiguedad;
    private Salario id_salario;
    private Conforme id_conforme;
    private Encuestador id_encuestador;

    public Encuesta() {
    }

    public Encuesta(Sexo id_sexo, Estudio id_estudio, Edad id_edad, Trabajo id_trabajo, Relacion_Contractual id_relacion_contractual, Rubro id_rubro, Hora_Semanal id_hora_semanal, Antiguedad id_antiguedad, Salario id_salario, Conforme id_conforme, Encuestador id_encuestador){
        this.id_sexo = id_sexo;
        this.id_estudio = id_estudio;
        this.id_edad = id_edad;
        this.id_trabajo = id_trabajo;
        this.id_relacion_contractual = id_relacion_contractual;
        this.id_rubro = id_rubro;
        this.id_hora_semanal = id_hora_semanal;
        this.id_antiguedad = id_antiguedad;
        this.id_salario = id_salario;
        this.id_conforme = id_conforme;
        this.id_encuestador = id_encuestador;
    }

    public Encuesta(Integer id, Sexo id_sexo, Estudio id_estudio, Edad id_edad, Trabajo id_trabajo, Relacion_Contractual id_relacion_contractual, Rubro id_rubro, Hora_Semanal id_hora_semanal, Antiguedad id_antiguedad, Salario id_salario, Conforme id_conforme, Encuestador id_encuestador) {
        this.id = id;
        this.id_sexo = id_sexo;
        this.id_estudio = id_estudio;
        this.id_edad = id_edad;
        this.id_trabajo = id_trabajo;
        this.id_relacion_contractual = id_relacion_contractual;
        this.id_rubro = id_rubro;
        this.id_hora_semanal = id_hora_semanal;
        this.id_antiguedad = id_antiguedad;
        this.id_salario = id_salario;
        this.id_conforme = id_conforme;
        this.id_encuestador = id_encuestador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sexo getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(Sexo id_sexo) {
        this.id_sexo = id_sexo;
    }

    public Estudio getId_estudio() {
        return id_estudio;
    }

    public void setId_estudio(Estudio id_estudio) {
        this.id_estudio = id_estudio;
    }

    public Edad getId_edad() {
        return id_edad;
    }

    public void setId_edad(Edad id_edad) {
        this.id_edad = id_edad;
    }

    public Trabajo getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(Trabajo id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public Relacion_Contractual getId_relacion_contractual() {
        return id_relacion_contractual;
    }

    public void setId_relacion_contractual(Relacion_Contractual id_relacion_contractual) {
        this.id_relacion_contractual = id_relacion_contractual;
    }

    public Rubro getId_rubro() {
        return id_rubro;
    }

    public void setId_rubro(Rubro id_rubro) {
        this.id_rubro = id_rubro;
    }

    public Hora_Semanal getId_hora_semanal() {
        return id_hora_semanal;
    }

    public void setId_hora_semanal(Hora_Semanal id_hora_semanal) {
        this.id_hora_semanal = id_hora_semanal;
    }

    public Antiguedad getId_antiguedad() {
        return id_antiguedad;
    }

    public void setId_antiguedad(Antiguedad id_antiguedad) {
        this.id_antiguedad = id_antiguedad;
    }

    public Salario getId_salario() {
        return id_salario;
    }

    public void setId_salario(Salario id_salario) {
        this.id_salario = id_salario;
    }

    public Conforme getId_conforme() {
        return id_conforme;
    }

    public void setId_conforme(Conforme id_conforme) {
        this.id_conforme = id_conforme;
    }

    public Encuestador getId_encuestador() {
        return id_encuestador;
    }

    public void setId_encuestador(Encuestador id_encuestador) {
        this.id_encuestador = id_encuestador;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "id=" + id +
                ", id_sexo=" + id_sexo +
                ", id_estudio=" + id_estudio +
                ", id_edad=" + id_edad +
                ", id_trabajo=" + id_trabajo +
                ", id_relacion_contractual=" + id_relacion_contractual +
                ", id_rubro=" + id_rubro +
                ", id_hora_semanal=" + id_hora_semanal +
                ", id_antiguedad=" + id_antiguedad +
                ", id_salario=" + id_salario +
                ", id_conforme=" + id_conforme +
                ", id_encuestador=" + id_encuestador +
                '}';
    }
}
