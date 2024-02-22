package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    final BookService service;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @GetMapping("/get")
    public Iterable<BookEntity>getBooks(){
        return service.getBooks();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        return service.deleteBook(id)?
            ResponseEntity.ok("Deleted"):
            ResponseEntity.notFound().build();
    }

    @GetMapping("search/{id}")
    public Book getBookById(@PathVariable Long id){
        return service.getBookById(id);
    }
}
