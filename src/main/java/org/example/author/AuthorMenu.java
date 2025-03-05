package org.example.author;

import org.example.Database;

import java.util.Scanner;

public class AuthorMenu {
    public static void authorMenu(Scanner scanner){
        boolean isOn=true;
        while(isOn) {
            System.out.println("""
                    \nMenu authors
                    1.View all
                    2.View one
                    3.Add
                    4.Update
                    5.Delete
                    6.Main menu
                    """);
            scanner = new Scanner(System.in);
            int scannerItem = scanner.nextInt();
            switch (scannerItem) {
                case 1 -> viewAll();
                case 2 -> viewOne(scanner);
                case 3 -> add(scanner);
                case 4 -> add(scanner);
                case 5 -> delete(scanner);
                case 6 -> {saveAndExit(); isOn=false;}
                default -> {
                    System.out.println("invalid command");
                }


            }
        }
    }

    public static void viewAll(){
        AuthorRepository authorRepository=new AuthorRepository();
        authorRepository.view();
    }

    public static void viewOne(Scanner scanner){
        System.out.println("enter id: ");
        long id = scanner.nextLong();
        AuthorRepository authorRepository=new AuthorRepository();
        authorRepository.viewOne(id);
    }

    public static void add(Scanner scanner){
        System.out.println("enter id: ");
        long id = scanner.nextLong();
        System.out.println("enter name: ");
        String name = scanner.next();
        Author author=new Author(id,name);
        AuthorRepository authorRepository=new AuthorRepository();
        authorRepository.addOrUpdate(author);
    }

    public static void delete(Scanner scanner){
        System.out.println("enter id: ");
        long id = scanner.nextLong();
        AuthorRepository authorRepository=new AuthorRepository();
        authorRepository.remove(id);
    }

    public static void saveAndExit(){
        Database database=new Database();
        database.saveAuthorData();
    }
}
