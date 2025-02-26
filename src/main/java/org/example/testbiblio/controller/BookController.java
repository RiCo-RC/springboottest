package org.example.testbiblio.controller;

import org.example.testbiblio.model.Book;
import org.example.testbiblio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
}
