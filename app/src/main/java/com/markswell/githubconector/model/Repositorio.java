package com.markswell.githubconector.model;

import java.io.Serializable;


/**
 * Created by markswell on 12/26/17.
 */

public class Repositorio implements Serializable {

    private String name;
    private String html_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repositorio that = (Repositorio) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return html_url != null ? html_url.equals(that.html_url) : that.html_url == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (html_url != null ? html_url.hashCode() : 0);
        return result;
    }
}
