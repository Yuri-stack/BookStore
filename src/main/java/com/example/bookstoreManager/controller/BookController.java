package com.example.bookstoreManager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreManager.entity.Book;
import com.example.bookstoreManager.service.BookServices;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {
 
	private @Autowired BookServices services;
	
	@PostMapping("/new")
	public ResponseEntity<Book> newBook(@Valid @RequestBody Book book){
		return services.createNewBook(book)
				.map(newBook -> ResponseEntity.status(201).body(newBook))
				.orElse(ResponseEntity.status(400).build());
	}

}
