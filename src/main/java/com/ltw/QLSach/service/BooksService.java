package com.ltw.QLSach.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ltw.QLSach.model.Book;

public interface BooksService {
    List<Book> getAllBooks();
    Book saveBooks(Book book);
    Book save1Books(Book book);
    Book getBookById(int id);
    void deleteBookById(int id);
}
