package com.example.apppokemon.Interface;


import com.example.apppokemon.Model.AddUser;
import com.example.apppokemon.Model.Login;
import com.example.apppokemon.Model.Pkemon;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiAlien {


    //Agregar un nuevo registro
    @FormUrlEncoded
    @POST("aliens")
    Call<AddUser> addUser(
            @Field("alien_usuario") String alien_usuario,
            @Field("alien_nombre") String alien_nombre,
            @Field("alien_ap") String alien_ap,
            @Field("alien_am") String alien_am,
            @Field("alien_correo") String alien_correo,
            @Field("alien_contrasenia") String alien_contrasenia,
            @Field("alien_nac") String alien_nac,
            @Field("alien_status") String alien_status
    );


    //Iniciar sesión
    @FormUrlEncoded
    @POST("login")
    Call<Login> logUser(
            @Field("alien_correo") String alien_correo,
            @Field("alien_contrasenia") String alien_contrasenia
    );

    @GET("pokemon/{id}")
    Call<Pkemon>search(@Path("id") String search);

}
