package com.BookService.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.BookService.Exception.BookException;
import com.BookService.Exception.ErrorInfo;

@ControllerAdvice
public class ControllerHandler {
	
	 @ExceptionHandler(BookException.class)
	    public ResponseEntity<ErrorInfo> handleBookServiceException(BookException ex){
	        ErrorInfo errorInfo = ErrorInfo.builder().errorId(ex.getId()).errorMessage(ex.getMessage()).build();
	        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorInfo> handleGeneralError(Exception ex){
	        ErrorInfo errorInfo = ErrorInfo.builder().errorId(0L).errorMessage(ex.getMessage()).build();
	        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	    }

}
