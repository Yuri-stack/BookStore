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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity					// Declara que a Classe é uma Entidade do Banco de Dados
@Data					// Disponibiliza os Métodos Getter e Setter 
@Builder
@NoArgsConstructor		// Cria os Construtores sem Argumentos
@AllArgsConstructor		// Cria os Construtores com Argumentos 
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private Integer pages;
	
	@Column(nullable = false)
	private Integer chapters;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(name = "published_name", nullable = false, unique = true)
	private String publisherName;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "author_id")
	private Author author;
}
