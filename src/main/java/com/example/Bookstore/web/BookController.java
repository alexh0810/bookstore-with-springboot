package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {

	// Read functionality: Show all books

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@RequestMapping(value = { "/", "/booklist" })
	public String studentList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	// RESTful service to get all books
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	// RESTful service to get book by id
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}

	// Create functionality: Adding new book

	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";

	}

	// Saving a book

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	// Delete functionality: Delete a book

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";

	}

	// Update functionality: Updating a book

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "edit";

	}

}
