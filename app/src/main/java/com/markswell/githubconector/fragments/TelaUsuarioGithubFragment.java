package com.markswell.githubconector.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.markswell.githubconector.R;
import com.markswell.githubconector.model.Repositorio;
import com.markswell.githubconector.model.Usuario;
import com.markswell.githubconector.recycleview.RepositorioListener;
import com.markswell.githubconector.recycleview.RepositorioRecycleView;
import java.util.List;


public class TelaUsuarioGithubFragment extends Fragment {

    private RecyclerView recyclerView;
    private RepositorioRecycleView repositorioRecycleView;
    private TextView nome;
    private Usuario usuario;
    private Gson gson;
    private List<Repositorio> repositorios;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_tela_usuario_github, container, false);
        Bundle arguments = getArguments();

        iniciarNome(view, arguments);
        iniciarRepositorios(arguments);

        popularListaRepositorios(view, repositorios);

        return view;
    }

    private void iniciarRepositorios(Bundle arguments) {
        String repositoriosString = (String) arguments.get("repositorios");
        repositorios = (List<Repositorio>) gson.fromJson(repositoriosString, new TypeToken<List<Repositorio>>() {}.getType());
    }

    private void iniciarNome(View view, Bundle arguments) {
        gson = new Gson();
        nome = (TextView) view.findViewById(R.id.nome_usuario);
        String usuarioString = (String) arguments.get("usuario");
        usuario = gson.fromJson(usuarioString, Usuario.class);
        nome.setText(this.usuario.getName());
    }

    private void popularListaRepositorios(View view, List<Repositorio> repositorios) {
        recyclerView = (RecyclerView) view.findViewById(R.id.lista_repositorios);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        repositorioRecycleView = new RepositorioRecycleView(getContext(), repositorios, obterListener());
        recyclerView.setAdapter(repositorioRecycleView);
    }

    private RepositorioListener obterListener() {
        return new RepositorioListener() {
            @Override
            public void onClick(RepositorioRecycleView recycle, Integer index) {
                Uri uri = Uri.parse(recycle.getUrl(index));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        };
    }

}
