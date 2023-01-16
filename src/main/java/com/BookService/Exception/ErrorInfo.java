package com.BookService.Exception;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorInfo {
	 private final Long errorId;
	    private final String errorMessage;

}
