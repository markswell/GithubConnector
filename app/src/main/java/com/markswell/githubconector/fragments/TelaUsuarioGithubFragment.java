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
import com.markswell.githubconector.R;
import com.markswell.githubconector.model.Repositorio;
import com.markswell.githubconector.recycleview.RepositorioListener;
import com.markswell.githubconector.recycleview.RepositorioRecycleView;
import java.util.List;


public class TelaUsuarioGithubFragment extends Fragment {

    private RecyclerView recyclerView;
    private RepositorioRecycleView repositorioRecycleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_tela_usuario_github, container, false);

        List<Repositorio> repositorios = (List<Repositorio>) bundle.get("repositorios");
        popularListaRepositorios(view, repositorios);

        return view;
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
