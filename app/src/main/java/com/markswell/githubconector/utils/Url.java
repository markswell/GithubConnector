package com.markswell.githubconector.utils;

/**
 * Created by markswell on 12/26/17.
 */

public enum Url {
    URL("https://api.github.com/users/");

    public String endereco;

    Url(String endereco) {
        this.endereco = endereco;
    }
}
