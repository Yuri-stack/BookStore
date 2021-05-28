package com.example.bookstoreManager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity					// Declara que a Classe é uma Entidade do Banco de Dados
@Data					// Disponibiliza os Métodos Getter e Setter 
@Builder
@NoArgsConstructor		// Cria os Construtores sem Argumentos
@AllArgsConstructor		// Cria os Construtores com Argumentos 
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 100)
	@Column(nullable = false, unique = true)
	@NotNull(message = "O campo Título não pode ser vazio!")
	private String title;
	
	@Column(nullable = false)
	@NotNull(message = "O campo Páginas não pode ser vazio!")
	private Integer pages;
	
	@Column(nullable = false)
	@NotNull(message = "O campo Capítulos não pode ser vazio!")
	private Integer chapters;
	
	@Column(nullable = false)
	@NotNull(message = "O campo ISBN não pode ser vazio!")
	private String isbn;

	@Column(name = "publisher_name", nullable = false, unique = true)
	@NotNull(message = "O campo Título de Publicação não pode ser vazio!")
	private String publisherName;

    @Valid
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "author_id")
    @NotNull(message = "O campo Autor não pode ser vazio!")
    private Author author;


	//Métodos Getter e Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getChapters() {
		return chapters;
	}

	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
