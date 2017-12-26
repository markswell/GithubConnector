package com.markswell.githubconector.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

/**
 * Created by markswell on 12/26/17.
 */

public class GerenciadorContainerFragment {
    private int local;
    private FragmentActivity activity;

    public GerenciadorContainerFragment(int local, FragmentActivity activity) {
        this.local = local;
        this.activity = activity;
    }

    public void trocarFragment(Fragment fragment, Bundle bundle) {
        try {
            FragmentManager fm = activity.getSupportFragmentManager();
            fragment.setArguments(bundle);
            fm.beginTransaction().replace(local, fragment).commit();
        } catch (Exception e){
            Log.e("markswell", e.getMessage());
        }
    }

    public void inserirFragment(Fragment fragment, Bundle bundle) {
        try {
            FragmentManager fm = activity.getSupportFragmentManager();
            fragment.setArguments(bundle);
            fm.beginTransaction()
                    .add(local, fragment)
                    .commit();
        } catch (Exception e){
            Log.e("markswell", e.getMessage());
        }
    }
}
