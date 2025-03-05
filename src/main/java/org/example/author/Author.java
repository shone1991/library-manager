package org.example.author;

import java.io.Serializable;

public class Author implements Serializable {
    private Long id;
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author(Long id, String name) {
        this.id=id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
