package com.example.ELibrary.Management.Controllers;

import com.example.ELibrary.Management.Entities.Book;
import com.example.ELibrary.Management.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }
    @PostMapping
    public Book addBook(@RequestBody Book book) {

        System.out.print("Book added"+book.toString());
        return bookService.save(book);
    }

    @PutMapping("/edit/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable Long id) {
        System.out.println("request for book update"+ book.getId());

            return bookService.updateBook(id , book);

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
//    @PostMapping("/{bookId}/borrow/{userId}")
//    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
//        Book borrowedBook = bookService.borrowBook(bookId, userId);
//        if (borrowedBook != null) {
//            return ResponseEntity.ok(borrowedBook);
//        } else {
//            return ResponseEntity.badRequest().build(); // or a more descriptive error response
//        }
//    }
    @GetMapping("getBook/{bookTitle}")
    public List<Book> getBookByName(@PathVariable String bookTitle) {
        return bookService.findBookByTitle(bookTitle);
        
    }
    
    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

}
