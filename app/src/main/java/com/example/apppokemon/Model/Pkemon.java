package com.example.apppokemon.Model;

public class Pkemon {
    private String id ;
    private String name;
    private String experiencia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public Pkemon(String id, String name, String experiencia) {
        this.id = id;
        this.name = name;
        this.experiencia = experiencia;
    }
}

