package org.example.testbiblio;

import org.example.testbiblio.model.Author;
import org.example.testbiblio.model.Book;
import org.example.testbiblio.model.Library;
import org.example.testbiblio.repository.AuthorRepository;
import org.example.testbiblio.repository.BookRepository;
import org.example.testbiblio.repository.LibraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// UTILISER POUR FAIRE DES TESTES A LA DURE (IL Y A D'AUTRE MOYENNE)
//

@Configuration
public class CommandLinner {

  @Bean
  public CommandLineRunner initData(LibraryRepository libraryRepo, BookRepository bookRepo, AuthorRepository authorRepo) {
    return args -> {
      Library testbiblio = new Library("Bibliothèque Centrale");
      libraryRepo.save(testbiblio);

      Author author1 = new Author("Victor Hugo");
      Author author2 = new Author("Jules Verne");
      authorRepo.saveAll(List.of(author1, author2));

      Book book1 = new Book("Les Misérables");
      book1.getAuthors().add(author1);
      book1.setLibrary(testbiblio);

      Book book2 = new Book("Vingt Mille Lieues sous les mers");
      book2.getAuthors().add(author2);
      book2.setLibrary(testbiblio);

      bookRepo.saveAll(List.of(book1, book2));

      System.out.println("Données initialisées !");
    };
  }
}
