package com.example.apppokemon.Model;

public class Login {
    public String alien_contrasenia;
    public String alien_correo;

    public String getAlien_contrasenia() {
        return alien_contrasenia;
    }

    public void setAlien_contrasenia(String alien_contrasenia) {
        this.alien_contrasenia = alien_contrasenia;
    }

    public String getAlien_correo() {
        return alien_correo;
    }

    public void setAlien_correo(String alien_correo) {
        this.alien_correo = alien_correo;
    }

    public Login(String alien_contrasenia, String alien_correo) {
        this.alien_contrasenia = alien_contrasenia;
        this.alien_correo = alien_correo;
    }
}
