package com.example.ELibrary.Management.Repository;

import com.example.ELibrary.Management.Entities.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title LIKE CONCAT(:prefix, '%')")
    List<Book> findByTitleStartingWith(String prefix);
}