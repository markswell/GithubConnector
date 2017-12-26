package com.markswell.githubconector.model;

import java.io.Serializable;

/**
 * Created by markswell on 12/26/17.
 */

public class Usuario implements Serializable {

    private String name;
    private String avatar_url;
    private String repos_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (name != null ? !name.equals(usuario.name) : usuario.name != null) return false;
        if (avatar_url != null ? !avatar_url.equals(usuario.avatar_url) : usuario.avatar_url != null)
            return false;
        return repos_url != null ? repos_url.equals(usuario.repos_url) : usuario.repos_url == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (avatar_url != null ? avatar_url.hashCode() : 0);
        result = 31 * result + (repos_url != null ? repos_url.hashCode() : 0);
        return result;
    }
}
