package com.markswell.githubconector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.markswell.githubconector.fragments.TelaBuscaFragment;
import com.markswell.githubconector.model.Usuario;
import com.markswell.githubconector.services.UsuarioServices;
import com.markswell.githubconector.utils.GerenciadorContainerFragment;
import com.markswell.githubconector.utils.RetrofitUtils;
import com.markswell.githubconector.utils.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static boolean ACESSADO;
    private GerenciadorContainerFragment gerenciador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarTela(savedInstanceState);
    }

    private void iniciarTela(Bundle savedInstanceState) {
        gerenciador = new GerenciadorContainerFragment(R.id.fragment_container, this);
        gerenciador.inserirFragment(new TelaBuscaFragment(), savedInstanceState);
    }

    public GerenciadorContainerFragment getGerenciador() {
        return gerenciador;
    }

    @Override
    public void onBackPressed() {
        if(ACESSADO){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            ACESSADO = !ACESSADO;
            finish();
        }
        else
            super.onBackPressed();
    }
}
