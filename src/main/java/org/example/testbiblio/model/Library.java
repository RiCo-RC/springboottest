package org.example.testbiblio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
  import java.util.List;

@Entity
public class Library {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
  @JsonManagedReference //Gére la relation avec la class Book;
  private List<Book> books;

  public Library() {}

  public Library(String name) {
    this.name = name;
  }

  // Getters et Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
