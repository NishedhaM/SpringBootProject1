package com.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book retreiveBook(@PathVariable int bookId){
        Book book=bookService.findBook(bookId);
        if(book==null){
            throw new BookNotFoundException("No Such book ->Book ID" + bookId);
            
        }
        return book;

    }

    @PostMapping("/books")
    public ResponseEntity<Object> createBook(@RequestBody Book book){
    Book saveBook = bookService.addBook(book);
    URI newBookLocation=ServletUriComponentsBuilder.fromCurrentRequest().path("/{bookId}")
      .buildAndExpand(saveBook.getBookId())
      .toUri();

      return ResponseEntity.created(newBookLocation).build();
    }

}
