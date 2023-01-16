package com.BookService;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.BookService.Entity.Book;
import com.BookService.Exception.BookException;
import com.BookService.Repository.BookRepository;
import com.BookService.Services.BookService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService = new BookService();

    @Test
    void addBook_ValidTest(){
       
        Long authorId = 1L;
        Book book = Book.builder().bookId(1L).title("ABCDE").build();

       
        Mockito.when(bookRepository.findByAuthorId(any())).thenReturn(List.of());
        Mockito.when(bookRepository.save(any())).thenReturn(book);

       
        Long bookId = bookService.addBook(authorId, book);

       
        assertThat(bookId).isEqualTo(1L);
    }

    @Test
    void addBook_InvalidTest(){
      
        Long authorId = 1L;
        Long bookId = 1L;
        Book book = Book.builder().bookId(bookId).title("ABCDE").build();

        Mockito.when(bookRepository.findByAuthorId(any())).thenReturn(List.of(book));

       
        assertThrows(BookException.class,()->bookService.addBook(authorId, book));
        assertThat(bookId).isEqualTo(1L);

    }

    @Test
    void retrieveBookDataById_ValidTest(){
        
        Long authorId = 1L;
        Long bookId = 1L;
        Book book = Book.builder().bookId(bookId).authorId(authorId).title("ABCDE").build();

        
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(book));

       
        Book newBook = bookService.retrieveBookDataById(bookId);

        
        assertThat(newBook).isEqualTo(book);
    }

    @Test
    void retrieveBookDataById_InValidTest(){
        
        Long bookId = 1L;

       
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.empty());

       
        assertThrows(BookException.class,()-> bookService.retrieveBookDataById(bookId));
    }

    @Test
    void updateBook_ValidTest(){
        
        Long authorId = 1L;
        Long bookId = 1L;
        Book book = Book.builder().bookId(bookId).authorId(authorId).title("ABCDE").build();

        
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(book));

       
        Long newBookId = bookService.updateBook(authorId,bookId, book);

        
        assertThat(newBookId).isEqualTo(1L);
    }

    @Test
    void updateBook_InvalidTest(){
        
        Long authorId = 1L;
        Long bookId = 1L;
        Book book = Book.builder().bookId(bookId).title("ABCDE").build();

        
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(book));

        
        assertThrows(BookException.class,()->bookService.updateBook(authorId,bookId, book));
    }

    @Test
    void unBlockBook_ValidTest(){
        
        Long authorId = 1L;
        Long bookId = 1L;
        Book book = Book.builder().bookId(bookId).authorId(authorId).title("ABCDE").blocked(true).build();

      
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(book));

        
        Long newBookId = bookService.unBlockBook(authorId, bookId);
        
        assertThat(newBookId).isEqualTo(bookId);
    }

    @Test
    void blockBook_ValidTest(){
        
        Long authorId = 1L;
        Long bookId = 1L;
        Book book = Book.builder().bookId(bookId).authorId(authorId).title("ABCDE").blocked(false).build();

       
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(book));

      
        Long newBookId = bookService.blockBook(authorId, bookId);
        
        assertThat(newBookId).isEqualTo(bookId);
    }

    @Test
    void unBlockBook_InValidTest(){
        
        Long authorId = 1L;
        Long bookId = 1L;
        Book book = Book.builder().bookId(bookId).authorId(authorId).title("ABCDE").blocked(false).build();

        
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(book));

       
        assertThrows(BookException.class,()->bookService.unBlockBook(authorId, bookId));
    }

    @Test
    void blockBook_InValidTest(){
       
        Long authorId = 1L;
        Long bookId = 1L;
        Book book = Book.builder().bookId(bookId).authorId(authorId).title("ABCDE").blocked(false).build();

       
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(book));

       
        assertThrows(BookException.class,()->bookService.unBlockBook(authorId, bookId));
    }
}