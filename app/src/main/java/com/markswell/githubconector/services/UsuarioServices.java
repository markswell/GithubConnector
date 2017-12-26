package com.markswell.githubconector.services;

import com.markswell.githubconector.model.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by markswell on 12/26/17.
 */

public interface UsuarioServices {

    @GET("{usuario}")
    Call<Usuario> getUsuario(@Path("usuario") String usuario);
}
