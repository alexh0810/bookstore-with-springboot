package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	// Add ManyToOne relation to Category
	@ManyToOne
	@JoinColumn(name = "categoryid")
	@JsonManagedReference
	private Category category;
	

	public Book() {}

	public Book(String author, String title, String isbn, int year, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.category = category; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		if (this.category != null)
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", ISBN=" + isbn + " category = " + this.getCategory() +"]";
		else 
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", ISBN=" + isbn + "]";
	}

}
