package com.codewithmithlesh.bookmanagment.service;

import com.codewithmithlesh.bookmanagment.dto.BookRequestDTO;
import com.codewithmithlesh.bookmanagment.model.Book;
import com.codewithmithlesh.bookmanagment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(BookRequestDTO dto) {
        Book book = new Book(dto.getTitle(), dto.getAuthor(), dto.getPages());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getBooksPaged(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> filterBooks(String title, String author){
        return bookRepository.filterBooks(title, author);
    }

    @Override
    public Book updateBook(Long id, BookRequestDTO dto) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Book not found with ID: " + id);
        }

        Book book = optional.get();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPages(dto.getPages());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Book not found with ID: " + id);
        }
        bookRepository.deleteById(id);
    }
}
