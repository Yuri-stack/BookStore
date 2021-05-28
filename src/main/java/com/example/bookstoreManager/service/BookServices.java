package com.example.bookstoreManager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreManager.entity.Book;
import com.example.bookstoreManager.repository.BookRepository;

@Service
public class BookServices {
	
	private @Autowired BookRepository repository;
	
	public Optional<Book> createNewBook(Book book){
		Optional<Book> bookExists = repository.findByTitleContaining(book.getTitle());
		
		if (bookExists.isPresent()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repository.save(book));
		}
	}
}
