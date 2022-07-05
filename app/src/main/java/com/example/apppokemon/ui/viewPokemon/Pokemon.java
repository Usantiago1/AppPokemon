package com.example.apppokemon.ui.viewPokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppokemon.Interface.ApiAlien;
import com.example.apppokemon.Model.Pkemon;
import com.example.apppokemon.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Pokemon extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        Button btnSearch = findViewById(R.id.btnsearch);
        EditText txtSearch = findViewById(R.id.txtSearch);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            //TextView txtResult = findViewById(R.id.txtResult);
            @Override
            public void onClick(View v) {
                String search = txtSearch.getText().toString();
                Retrofit retrofit =new Retrofit.Builder()
                        .baseUrl("https://pokeapi.co/api/v2/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiAlien apiAlien = retrofit.create(ApiAlien.class);
                Call<Pkemon> call = apiAlien.search(search);
                call.enqueue(new Callback<Pkemon>() {
                    @Override
                    public void onResponse(Call<Pkemon> call, Response<Pkemon> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(Pokemon.this, "nombre: "+response.body().getName() + " \n" + " Habilidad: " + response.body().getExperiencia(), Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<Pkemon> call, Throwable t) {

                    }
                });

            }
        });
    }


}