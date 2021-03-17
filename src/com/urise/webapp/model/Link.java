package com.urise.webapp.model;

import java.io.Serializable;

public class Link implements Serializable {
    private String url;
    private String name;

    public Link(String name, String url) {
        this.url = url;
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
