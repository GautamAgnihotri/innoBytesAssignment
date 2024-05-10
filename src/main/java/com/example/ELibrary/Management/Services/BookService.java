package com.example.ELibrary.Management.Services;

import com.example.ELibrary.Management.Entities.Book;
import com.example.ELibrary.Management.Repository.BookRepository;
import com.example.ELibrary.Management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public List<Book> findBookByTitle(String title){
        return bookRepository.findByTitleStartingWith(title);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = findById(id);
        if (existingBook!= null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setQuantity(book.getQuantity());
            existingBook.setCost(book.getCost());
            return save(existingBook);
        }
        return null;
    }

    public Book borrowBook(Long bookId, Long userId) {
        return null;
    }

    public Book returnBook(Long bookId) {
//        Book book = findById(bookId);
//        if (book != null && book.isBorrowed()) {
//            book.setBorrowedBy(null);
//            book.setBorrowed(false);
//            return save(book);
//        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null;
    }

}
