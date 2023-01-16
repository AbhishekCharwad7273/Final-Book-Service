package com.BookService.Exception;

import lombok.Getter;

@Getter
public class BookException extends RuntimeException{
	
	  /**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private long id = 1L;
	    public BookException(String message) {
	        super(message);
	    }
	    public BookException(Long id,String message) {
	        super(message);
	        this.id = id;
	    }

}
