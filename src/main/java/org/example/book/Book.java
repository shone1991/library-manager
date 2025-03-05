package org.example.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Serializable {
    private Long id;
    private String name;
    private String genre;
    private List<Long> authorIds=new ArrayList<>();

    public Book(Long id, String name, String genre, String authorIds) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        addAuthorId(authorIds);
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Long> getAuthorIds() {
        return this.authorIds;
    }

    public void setAuthorIds(List<Long> authorIds) {
        this.authorIds = authorIds;
    }

    private void addAuthorId(String idList) {
        var ids=Arrays.stream(idList.split(",")).toList();
        for(String id:ids){
            getAuthorIds().add(Long.parseLong(id.trim()));
        }
    }
}
