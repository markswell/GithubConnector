package com.markswell.githubconector.teste;

import com.markswell.githubconector.model.Repositorio;
import com.markswell.githubconector.model.Usuario;
import com.markswell.githubconector.services.RepositorioServices;
import com.markswell.githubconector.services.UsuarioServices;
import com.markswell.githubconector.testeutils.CallBackUtils;
import com.markswell.githubconector.utils.RetrofitUtils;
import com.markswell.githubconector.utils.Url;
import junit.framework.TestCase;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by markswell on 12/26/17.
 */

public class Teste extends TestCase{

    private CallBackUtils utils;

    public void testeRetrofitUtils(){
        Retrofit retrofit = new RetrofitUtils().obterRetrofit(Url.URL.endereco);
        assert (retrofit != null);
    }

    public void testeUsuarioServices(){
        prencherUsuario();
        assert( !CallBackUtils.user.getName().isEmpty());
    }

    public void testeRepositorioSeriveces(){
        preencherRepositorio();
        assert(this.utils.listaRepositorios != null && this.utils.listaRepositorios.size() > 0);
    }

    private void preencherRepositorio() {
        utils = new CallBackUtils();
        Retrofit retrofit = new RetrofitUtils().obterRetrofit(Url.URL.endereco);
        RepositorioServices services = retrofit.create(RepositorioServices.class);
        Call<List<Repositorio>> repositorios = services.getRepositorios("markswell");
        repositorios.enqueue(this.utils.obterCallBackRepo());
    }


    private void prencherUsuario() {
        Retrofit retrofit = new RetrofitUtils().obterRetrofit(Url.URL.endereco);
        utils = new CallBackUtils();
        efetuarChamada(retrofit);
    }

    public void efetuarChamada(Retrofit retrofit) {
        UsuarioServices chamarUser = retrofit.create(UsuarioServices.class);
        Call<Usuario> call = chamarUser.getUsuario("markswell");
        call.enqueue(utils.obterCallBack());
    }

}
