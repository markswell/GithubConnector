package com.markswell.githubconector.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.markswell.githubconector.R;
import com.markswell.githubconector.model.Repositorio;
import com.markswell.githubconector.model.Usuario;
import com.markswell.githubconector.services.RepositorioServices;
import com.markswell.githubconector.services.UsuarioServices;
import com.markswell.githubconector.utils.RetrofitUtils;
import com.markswell.githubconector.utils.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 *  Created by markswell on 12/26/17.
 */
public class TelaBuscaFragment extends Fragment {

    private FloatingActionButton fab;
    private EditText login;
    private Usuario usuarioGit;
    private List<Repositorio> repositoriosGit;

    public TelaBuscaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_tela_busca, container, false);

        login = (EditText) view.findViewById(R.id.login);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        fab.setOnClickListener(obterFabListener());

        return view;
    }

    private View.OnClickListener obterFabListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = login.getText().toString();
                Retrofit retrofit = getRetrofit();

                obterUsuario(usuario, retrofit);
                obterRepositorios(usuario, retrofit);


            }
        };
    }

    private void obterRepositorios(String usuario, Retrofit retrofit) {
        RepositorioServices usuarioServices = retrofit.create(RepositorioServices.class);
        Call<List<Repositorio>> call = usuarioServices.getRepositorios(usuario);
        call.enqueue(getCallBackRepositorio());
    }

    private void obterUsuario(String usuario, Retrofit retrofit) {
        UsuarioServices usuarioServices = retrofit.create(UsuarioServices.class);
        Call<Usuario> call = usuarioServices.getUsuario(usuario);
        call.enqueue(getCallbackUsuario());
    }

    private Retrofit getRetrofit() {
        RetrofitUtils retrofitUtils = new RetrofitUtils();
        return retrofitUtils.obterRetrofit(Url.URL.endereco);
    }

    @NonNull
    private Callback<Usuario> getCallbackUsuario() {
        return new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful())
                    usuarioGit = response.body();
                else
                    Toast.makeText(getContext(), "Usuario não encontrado.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                    Toast.makeText(getContext(), "Não foi possivel efetuar a busca, verifique sua conexão.", Toast.LENGTH_LONG).show();
            }
        };
    }


    public Callback<List<Repositorio>> getCallBackRepositorio() {
        return new Callback<List<Repositorio>>() {
            @Override
            public void onResponse(Call<List<Repositorio>> call, Response<List<Repositorio>> response) {
                if(response.isSuccessful())
                    repositoriosGit = response.body();
                else
                    Toast.makeText(getContext(), "Não foi possivel encontrar repositorios.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Repositorio>> call, Throwable t) {
                    Toast.makeText(getContext(), "Não foi possivel efetuar a busca, verifique sua conexão.", Toast.LENGTH_LONG).show();

            }
        };
    }
}
