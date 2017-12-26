package com.markswell.githubconector.teste;

import android.util.Log;

import com.markswell.githubconector.model.Usuario;
import com.markswell.githubconector.services.UsuarioServices;
import com.markswell.githubconector.testeutils.CallBackUtils;
import com.markswell.githubconector.utils.RetrofitUtils;
import com.markswell.githubconector.utils.Url;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by markswell on 12/26/17.
 */

public class Teste extends TestCase{

    private CallBackUtils utils;

    public void testeUsuarioServicesNaoNulo(){
        prencherUsuario();
        assert( !CallBackUtils.user.getName().isEmpty());
    }

    public void testeUsuarioServicesNome(){
        prencherUsuario();
        Log.i("markswell", CallBackUtils.user.getName());
        assertEquals("Markswell Menezes" , CallBackUtils.user.getName());
    }


    private void prencherUsuario() {
        Retrofit retrofit = new RetrofitUtils().obterRetrofit(Url.URL.endereco);
        utils = new CallBackUtils();
        efetuarChamada(retrofit);
    }

    public void efetuarChamada(Retrofit retrofit) {
        UsuarioServices chamarUser = retrofit.create(UsuarioServices.class);
        Call<Usuario> call = chamarUser.getUsuario("markswell");
        try {
            Usuario body = call.execute().body();
            body.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
