package com.example.bookstoreManager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreManager.entity.Book;
import com.example.bookstoreManager.repository.BookRepository;
import com.example.bookstoreManager.service.BookServices;


@RestController
@RequestMapping("/api/v1/book")
public class BookController {
 
	private @Autowired BookServices services;
	private @Autowired BookRepository repository;
	
	@GetMapping("/id/{id_Book}")
	public ResponseEntity<Book> getBookById(@PathVariable(value="id_Book") Long id){
		return services.findBookById(id)
				.map(book -> ResponseEntity.status(200).body(book))
				.orElse(ResponseEntity.status(204).build());
	} 
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> bookList = repository.findAll();
		if(!bookList.isEmpty()) {
			return ResponseEntity.status(200).body(bookList);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	

	@PostMapping("/new")
	public ResponseEntity<Book> newBook(@Valid @RequestBody Book book){
		return services.createNewBook(book)
				.map(newBook -> ResponseEntity.status(201).body(newBook))
				.orElse(ResponseEntity.status(400).build());
	}
	
}
