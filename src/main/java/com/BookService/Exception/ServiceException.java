package com.BookService.Exception;

import lombok.Getter;

@Getter
public class ServiceException {

	
	  private final int id;
	    private final String message;

	    ServiceException(int id,String message){
	        this.id = id;
	        this.message = message;
	    }
}
