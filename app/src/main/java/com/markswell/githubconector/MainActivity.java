package com.markswell.githubconector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.markswell.githubconector.fragments.TelaBuscaFragment;
import com.markswell.githubconector.model.Usuario;
import com.markswell.githubconector.services.UsuarioServices;
import com.markswell.githubconector.utils.GerenciadorContainerFragment;
import com.markswell.githubconector.utils.RetrofitUtils;
import com.markswell.githubconector.utils.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    private CallBackUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GerenciadorContainerFragment gerenciador = new GerenciadorContainerFragment(R.id.fragment_container, this);
        gerenciador.inserirFragment(new TelaBuscaFragment(), savedInstanceState);
        prencherUsuario();
        return;

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
