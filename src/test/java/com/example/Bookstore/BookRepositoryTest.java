package com.example.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	// Testing function: Find By Title should return Author
	
	@Test 
	public void findByTitleShouldReturnAuthor() {
		List<Book> books = repository.findByTitle("A Farewell to Arms");
		assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
	}
	
	
	// Testing function: Creating a new book
	
	@Test
	public void createNewBook() {
		Book book = new Book("Paul Trembley", "A Head Full of Ghosts", "434345621394", 2015, crepository.findByName("Fiction").get(0));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
		
	}
	
	

}
