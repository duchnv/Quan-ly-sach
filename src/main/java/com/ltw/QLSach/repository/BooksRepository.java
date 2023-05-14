package com.ltw.QLSach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltw.QLSach.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

}
