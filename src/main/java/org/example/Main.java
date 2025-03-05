package org.example;

import org.example.author.AuthorMenu;
import org.example.book.BookMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // load init data
        Database db = new Database();
        db.loadBooksTable();
        db.loadAuthorsTable();
        /**
        1.Authors
        2.Books
        3.exit
         */
        A: for (;;) {
            System.out.println("""
                    \nMenu
                    1.Authors
                    2.Books
                    3.Exit
                    """);
//            AuthorsResult author = new AuthorsResult();
            Scanner menu = new Scanner(System.in);
            int menuItem = menu.nextInt();
            switch (menuItem) {
                case 1 -> AuthorMenu.authorMenu(menu);
                case 2-> BookMenu.bookMenu(menu);
                case 3-> {break A;}
                default -> System.out.println("error");

//

            }
        }
    }





}