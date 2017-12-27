package com.markswell.githubconector.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.markswell.githubconector.R;
import com.markswell.githubconector.model.Repositorio;

import java.util.List;

/**
 * Created by markswell on 12/26/17.
 */

public class RepositorioRecycleView extends Adapter<RepositorioViewholder> {

    private Context context;
    private List<Repositorio> repositorios;
    private RepositorioListener listener;

    public RepositorioRecycleView(Context context, List<Repositorio> repositorios, RepositorioListener listener) {
        this.context = context;
        this.repositorios = repositorios;
        this.listener = listener;
    }

    @Override
    public RepositorioViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycleview_repositorios, parent, false);
        RepositorioViewholder viewHolder = new RepositorioViewholder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RepositorioViewholder holder, final int position) {
        holder.getNome().setText(getNome(position));
        if(listener != null) {
            holder.getNome().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(RepositorioRecycleView.this, position);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return repositorios.size();
    }

    private String getNome(int index) {
        return repositorios.get(index).getName();
    }

    public String getUrl(int index){
        return repositorios.get(index).getHtml_url();
    }
}
