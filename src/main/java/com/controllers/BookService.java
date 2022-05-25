package com.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookService {
private static List<Book> books = new ArrayList<>();
private static int bookCounter=3;

    static{
        books.add(new Book(1,"Harry Potter",new Date()));
        books.add(new Book(2,"Marry Gotter",new Date()));
        books.add(new Book(3,"Sarry Potter",new Date()));
    }

    public List<Book> findAllBooks(){
        return books;
    }

    public Book addBook(Book book){
        if(book.getBookId()== null){
            book.setBookId(bookCounter++);
        }

        books.add(book);
        return book;

    }

    public Book findBook(int id){
        for(Book book:books){
            if(book.getBookId()==id){
                return book;
            }
        }
        return null;
    }
}
