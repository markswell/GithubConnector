package com.markswell.githubconector.services;

import com.markswell.githubconector.model.Repositorio;
import com.markswell.githubconector.model.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;

/**
 * Created by markswell on 12/26/17.
 */

public interface RepositorioServices {
    @GET("{usuario}/repos")
    Call<Repositorio> getUsuario(@Part String usuario);
}
