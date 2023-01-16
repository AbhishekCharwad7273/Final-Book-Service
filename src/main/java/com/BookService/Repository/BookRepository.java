package com.BookService.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BookService.Entity.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("select b.title,b.publisher from Book b WHERE b.title = ?1 AND b.publisher= ?2")
	List<Book> findAll(String title,String publisher);

    List<Book> findByTitleContainsIgnoreCase(String title);
    
    List<Book> findByPriceLessThan(Double price);

    List<Book> findByPriceLessThanEqual(Double price);

    List<Book> findByCategoryLikeIgnoreCase(String category);

    List<Book> findByPublisherContainsIgnoreCase(String publisher);

    List<Book> findByTitleLikeIgnoreCase(String title);

    List<Book> findByAuthorId(Long authorId);

    List<Book> findByBlockedFalse();

    List<Book> findByPublisherLikeIgnoreCase(String publisher);

    List<Book> findByPublishedDateAfter(LocalDate publishedDate);

}
