package com.markswell.githubconector;

import com.markswell.githubconector.model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by markswell on 12/26/17.
 */

public class CallBackUtils {

    public static Usuario user;

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
}
