package org.example.book;

import org.example.Database;
import org.example.author.Author;
import org.example.author.AuthorRepository;

import java.util.Map;
import java.util.Set;

public class BookRepository {

    public void view(){
        AuthorRepository authorRepository = new AuthorRepository();
        Set<Map.Entry<Long, Book>> entries = Database.books.entrySet();
        System.out.println("id | name | genre | authors");
        for(Map.Entry<Long,Book> bookEntry:entries){
            System.out.println(bookEntry.getValue().getId()+" | "+bookEntry.getValue().getName()
            +" | "+bookEntry.getValue().getGenre()+" | "+authorRepository.getAuthorNames(bookEntry.getValue().getAuthorIds()));
        }
    }

    public void viewOne(Long id){
        AuthorRepository authorRepository = new AuthorRepository();
        Book book = Database.books.get(id);
        System.out.println("id | name | genre | authors");
        System.out.println(book.getId()+" | "+book.getName() + "| "+book.getGenre()+" | "+authorRepository.getAuthorNames(book.getAuthorIds()));
    }

    public void addOrUpdate(Book book){
        Database.books.put(book.getId(), book);
    }

    public void remove(Long id){
        Database.books.remove(id);
    }


}
