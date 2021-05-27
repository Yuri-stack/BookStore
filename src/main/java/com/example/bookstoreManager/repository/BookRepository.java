package com.example.bookstoreManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstoreManager.entity.Books;

public interface BookRepository extends JpaRepository<Books, Long>{

}
