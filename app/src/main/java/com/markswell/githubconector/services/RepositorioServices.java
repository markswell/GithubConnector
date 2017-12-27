package com.markswell.githubconector.services;

import com.markswell.githubconector.model.Repositorio;
import com.markswell.githubconector.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by markswell on 12/26/17.
 */

public interface RepositorioServices {
    @GET("{usuario}/repos")
    Call<List<Repositorio>> getRepositorios(@Path("usuario") String usuario);
}
