package com.example.tp_integrador_paii.entidad;

public class Encuestador {
    private String cue;
    private String password;

    public Encuestador() {
    }

    public Encuestador(String cue, String password) {
        this.cue = cue;
        this.password = password;
    }

    public String getCue() {
        return cue;
    }

    public void setCue(String cue) {
        this.cue = cue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Encuestador{" +
                "cue='" + cue + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
