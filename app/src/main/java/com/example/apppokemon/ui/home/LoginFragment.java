package com.example.apppokemon.ui.home;

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
import com.example.apppokemon.Model.Login;
import com.example.apppokemon.databinding.FragmentLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel homeViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button btnLog = binding.btnLog;
        btnLog.setOnClickListener(new View.OnClickListener() {
            final TextView textPassword = binding.txtPassword;
            final TextView textUser = binding.txtUser;

            @Override
            public void onClick(View v) {
                String password = textPassword.getText().toString().trim();
                String user = textUser.getText().toString().trim();

                if (password.isEmpty() && user.isEmpty()){
                    String message = "Todos los campos son requeridos";
                    textPassword.setError(message);
                    textUser.setError(message);
                }


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api-alien.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiAlien login = retrofit.create(ApiAlien.class);
                Call<Login> call = login.logUser(user, password);
                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        if (response.isSuccessful() && response.body() != null){

                            Toast.makeText(getContext(), "Logeado", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getContext(), "No Logeado", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {

                    }
                });
            }
        });

        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        //final Button btnAdd = binding.btnAdd;






        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




}