package com.markswell.githubconector.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.markswell.githubconector.R;

/**
 * Created by markswell on 12/26/17.
 */

public class RepositorioViewholder extends RecyclerView.ViewHolder {

    private final TextView nome;

    public RepositorioViewholder(View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.nome_repo);
    }

    public TextView getNome() {
        return nome;
    }
}
