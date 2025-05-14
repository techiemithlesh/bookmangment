package com.codewithmithlesh.bookmanagment.controller;

import com.codewithmithlesh.bookmanagment.dto.BookRequestDTO;
import com.codewithmithlesh.bookmanagment.exception.ResourceNotFoundException;
import com.codewithmithlesh.bookmanagment.model.Book;
import com.codewithmithlesh.bookmanagment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    @Autowired
    private BookRepository bookRepository;


    @PostMapping("/add")
    public ResponseEntity<Book> addbooks(@Validated @RequestBody BookRequestDTO dto){

        Book book = new Book(dto.getTitle(), dto.getAuthor(), dto.getPages());
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBooksById(@PathVariable Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        return ResponseEntity.ok(book);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book bookDetails){
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book Not found with the given id" + id));

        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setPages(bookDetails.getPages());

        Book updatedBook = bookRepository.save(existingBook);

        return ResponseEntity.ok(updatedBook);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id){
        Book exisitngBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for given id "));
        bookRepository.deleteById(id);

        return ResponseEntity.ok("Book with ID " + id + " deleted successfully.");

    }
}
