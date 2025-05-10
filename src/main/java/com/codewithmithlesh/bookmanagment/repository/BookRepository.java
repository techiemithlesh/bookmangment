package com.codewithmithlesh.bookmanagment.repository;

import com.codewithmithlesh.bookmanagment.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    public function save(){}
}
