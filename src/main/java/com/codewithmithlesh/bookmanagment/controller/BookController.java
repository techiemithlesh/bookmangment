package com.codewithmithlesh.bookmanagment.controller;

import com.codewithmithlesh.bookmanagment.dto.BookRequestDTO;
import com.codewithmithlesh.bookmanagment.exception.ResourceNotFoundException;
import com.codewithmithlesh.bookmanagment.model.Book;
import com.codewithmithlesh.bookmanagment.repository.BookRepository;
import com.codewithmithlesh.bookmanagment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;


    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookRequestDTO dto) {
        return ResponseEntity.ok(bookService.saveBook(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Book>> getBooksPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "title") String sortBy) {

        return ResponseEntity.ok(bookService.getBooksPaged(page, size, sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBooksById(@PathVariable Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        return ResponseEntity.ok(book);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @Valid @RequestBody BookRequestDTO dto){
        return ResponseEntity.ok(bookService.updateBook(id, dto));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully.");
    }
}
