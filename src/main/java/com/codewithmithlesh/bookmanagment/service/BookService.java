package com.codewithmithlesh.bookmanagment.service;

import com.codewithmithlesh.bookmanagment.dto.BookRequestDTO;
import com.codewithmithlesh.bookmanagment.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    Book savedBook (BookRequestDTO dto);
    Page<Book> getBooksPaged(int page, int size, String sortBy);
    Book updateBook(Long id, BookRequestDTO dto);
    void deleteBook(Long id);
}
