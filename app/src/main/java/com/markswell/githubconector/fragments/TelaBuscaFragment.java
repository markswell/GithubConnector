package com.markswell.githubconector.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.markswell.githubconector.R;

/**
 *  Created by markswell on 12/26/17.
 */
public class TelaBuscaFragment extends Fragment {

    public TelaBuscaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tela_busca, container, false);
    }


}
