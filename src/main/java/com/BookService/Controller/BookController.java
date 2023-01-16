package com.BookService.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BookService.Entity.Book;
import com.BookService.Services.BookService;

@Controller
@CrossOrigin
@RequestMapping("/api/v1/digitalbooks/")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/{authorId}/books")
    public ResponseEntity<Long> createBook(@PathVariable Long authorId, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(authorId, book));
    }

    @PutMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<Long> updateBook(@PathVariable Long authorId, @PathVariable Long bookId, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(authorId, bookId, book));
    }

    @DeleteMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<Long> deleteBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.deleteBook(authorId, bookId));
    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<Book>> getBooksByGivenAuthor(@PathVariable Long authorId) {
        return ResponseEntity.ok(bookService.retrieveAllBooksByAuthor(authorId));
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.retrieveBookDataById(bookId));
    }

    @GetMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<Long> toggleBookBlock(@PathVariable Long authorId, @PathVariable Long bookId, @RequestParam boolean block) {
        return ResponseEntity.ok(
                (block) ? bookService.blockBook(authorId, bookId)
                        : bookService.unBlockBook(authorId, bookId)
        );
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.retrieveAllBooks());
    }

 
    
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchQuery(@RequestParam String category, @RequestParam String title, @RequestParam String price, @RequestParam String publisher) {
        return ResponseEntity.ok(bookService.retrieveBooksByQuery(category, title, price, publisher));
    }
}

