package com.example.apppokemon.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apppokemon.Interface.ApiAlien;
import com.example.apppokemon.Model.AddUser;
import com.example.apppokemon.databinding.FragmentRegistroBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroFragment extends Fragment {

    private FragmentRegistroBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RegistroViewModel galleryViewModel =
                new ViewModelProvider(this).get(RegistroViewModel.class);

        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button btnAdd = binding.btnAdd;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            final TextView textUser = binding.txtUser;
            final TextView textNombre = binding.txtNombre;
            final TextView textAp = binding.txtAp;
            final TextView textAm = binding.txtAm;
            final TextView textPassword = binding.txtPassword;
            final TextView textNac = binding.txtNac;
            final TextView textStatus = binding.txtStatus;
            final TextView textEmail = binding.txtEmail;



            @Override
            public void onClick(View v) {

                String alien_usuario = textUser.getText().toString().trim();
                String alien_nombre = textNombre.getText().toString().trim();
                String alien_ap = textAp.getText().toString().trim();
                String alien_am = textAm.getText().toString().trim();
                String alien_correo = textEmail.getText().toString().trim();
                String alien_contrasenia = textPassword.getText().toString().trim();
                String alien_nac = textNac.getText().toString().trim();
                String alien_status = textStatus.getText().toString().trim();

                if(alien_usuario.isEmpty() && alien_nombre.isEmpty() && alien_ap.isEmpty() && alien_ap.isEmpty() && alien_correo.isEmpty() && alien_contrasenia.isEmpty() && alien_nac.isEmpty() && alien_status.isEmpty()){
                    String message = "Todos los campos son requeridos";
                    textUser.setError(message);
                    textNombre.setError(message);
                    textAp.setError(message);
                    textAm.setError(message);
                    textEmail.setError(message);
                    textPassword.setError(message);
                    textNac.setError(message);
                    textStatus.setError(message);
                }

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api-alien.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiAlien apiAlien = retrofit.create(ApiAlien.class);
                Call<AddUser> call = apiAlien.addUser(alien_usuario, alien_nombre, alien_ap, alien_am, alien_correo, alien_contrasenia, alien_nac, alien_status);
                call.enqueue(new Callback<AddUser>() {
                    @Override
                    public void onResponse(Call<AddUser> call, Response<AddUser> response) {
                        if(response.isSuccessful() && response.body() != null){

                            Toast.makeText(getContext(), "Registrado", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getContext(), "No Registrado", Toast.LENGTH_SHORT).show();
                        }

                    }



                    @Override
                    public void onFailure(Call<AddUser> call, Throwable t) {

                    }
                });
            }
        });





        //galleryViewModel.getText().observe(getViewLifecycleOwner(), textUser::setText);
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}