package org.example.book;



import org.example.Database;

import java.util.Scanner;

public class BookMenu {
    public static void bookMenu(Scanner scanner){
        boolean isOn=true;
        while(isOn) {
            System.out.println("""
                    \nMenu books
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
                default -> System.out.println("invalid command");


            }
        }
    }

    public static void viewAll(){
        BookRepository bookRepository=new BookRepository();
        bookRepository.view();
    }

    public static void viewOne(Scanner scanner){
        System.out.println("enter id: ");
        long id = scanner.nextLong();
        BookRepository bookRepository=new BookRepository();
        bookRepository.viewOne(id);
    }

    public static void add(Scanner scanner){
        System.out.println("enter id: ");
        long id = scanner.nextLong();
        System.out.println("enter name: ");
        String name = scanner.next();
        System.out.println("enter genre: ");
        String genre = scanner.next();
        System.out.println("enter author ids with comma separated list as (1, 2, 3, 4): ");
        scanner=new Scanner(System.in);
        String authorIds = scanner.nextLine();
        Book book=new Book(id,name,genre,authorIds);
        BookRepository bookRepository=new BookRepository();
        bookRepository.addOrUpdate(book);
    }

    public static void delete(Scanner scanner){
        System.out.println("enter id: ");
        long id = scanner.nextLong();
        BookRepository bookRepository=new BookRepository();
        bookRepository.remove(id);
    }

    public static void saveAndExit(){
        Database database=new Database();
        database.saveBookData();
    }
}
