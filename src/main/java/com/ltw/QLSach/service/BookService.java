package com.ltw.QLSach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltw.QLSach.repository.BooksRepository;

@Service
public class BookService {
	@Autowired
	private BooksRepository booksRepository;
	
	
}
