package org.example.testbiblio.model;

import jakarta.persistence.*;
  import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public Author() {}

  public Author(String name) {
    this.name = name;
  }

  // Getters et Setters
}
