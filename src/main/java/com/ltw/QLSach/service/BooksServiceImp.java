package com.ltw.QLSach.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltw.QLSach.model.Book;
import com.ltw.QLSach.repository.BooksRepository;

@Service
public class BooksServiceImp implements BooksService {
    
    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Book saveBooks(Book book) {
        return booksRepository.save(book);
        
    }
    @Override
    public Book save1Books(Book book) {
        return booksRepository.save(book);
        
    }
    @Override
    public Book getBookById(int id) {
        Optional<Book> optional = booksRepository.findById(id);
        Book book = null;
        if(optional.isPresent())
        {
            book = optional.get();
        }else {
            throw new RuntimeException("book not found by id" + id);
        }
        return book;
    }

    @Override
    public void deleteBookById(int id) {
        booksRepository.deleteById(id);
        return;
    }
    
    

}
