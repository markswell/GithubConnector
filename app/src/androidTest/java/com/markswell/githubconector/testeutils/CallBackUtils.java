package com.markswell.githubconector.testeutils;

import com.markswell.githubconector.model.Repositorio;
import com.markswell.githubconector.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by markswell on 12/26/17.
 */

public class CallBackUtils {

    public static Usuario user;
    public static List<Repositorio> listaRepositorios;

    public Callback<Usuario> obterCallBack() {
        return new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(!response.isSuccessful()){
                    user = null;
                }else {
                    user = response.body();

                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                user = null;
            }
        };
    }

    public Callback<List<Repositorio>> obterCallBackRepo() {
        return new Callback<List<Repositorio>>() {
            @Override
            public void onResponse(Call<List<Repositorio>> call, Response<List<Repositorio>> response) {
                if(response.isSuccessful()) {
                    listaRepositorios = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Repositorio>> call, Throwable t) {

            }
        };
    }
}
