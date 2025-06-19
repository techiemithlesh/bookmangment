package com.codewithmithlesh.bookmanagment.service;


import com.codewithmithlesh.bookmanagment.dto.BookRequestDTO;
import com.codewithmithlesh.bookmanagment.model.Book;
import com.codewithmithlesh.bookmanagment.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void testBookSave(){
        BookRequestDTO dto = new BookRequestDTO("Test Title", "Test Author", 300);

        Book mockBook = new Book(dto.getTitle(), dto.getAuthor(), dto.getPages());
        when(bookRepository.save(any(Book.class))).thenReturn(mockBook);

        Book result = bookService.saveBook(dto);

        assertEquals(dto.getTitle(), result.getTitle());
        assertEquals(dto.getAuthor(), result.getAuthor());
        assertEquals(dto.getPages(), result.getPages());

        verify(bookRepository, times(1)).save(any(Book.class));
    }

}
