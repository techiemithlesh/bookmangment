package com.codewithmithlesh.bookmanagment.repository;

import com.codewithmithlesh.bookmanagment.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
