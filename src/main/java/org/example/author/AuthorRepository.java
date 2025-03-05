package org.example.author;

import org.example.Database;

import java.util.*;

public class AuthorRepository {

    public void view(){
        Set<Map.Entry<Long, Author>> entries = Database.authors.entrySet();
        System.out.println("id | name");
        for(Map.Entry<Long,Author> authorEntry:entries){
            System.out.println(authorEntry.getValue().getId()+" | "+authorEntry.getValue().getName());
        }
    }

    public void viewOne(Long id){
        Author author = Database.authors.get(id);
        System.out.println("id | name");
        System.out.println(author.getId()+" | "+author.getName());
    }

    public void addOrUpdate(Author author){
        Database.authors.put(author.getId(), author);
    }

    public void remove(Long id){
        Database.authors.remove(id);
    }

    public List<Author> getAll(List<Long> ids){
        Set<Map.Entry<Long, Author>> entries = Database.authors.entrySet();
        List<Author> foundAuthors = new ArrayList<>();
        for(Long id:ids){
            Author author = Database.authors.get(id);
            foundAuthors.add(author);
        }
        return foundAuthors;
    }

    public String getAuthorNames(List<Long> ids){
        List<String> foundAuthors = new ArrayList<>();
        for(Long id:ids){
            Author author = Database.authors.get(id);
            if(Objects.nonNull(author)) {
                foundAuthors.add(author.getName());
            }
        }
        return foundAuthors.isEmpty()?"":String.join(",",foundAuthors);
    }


}
