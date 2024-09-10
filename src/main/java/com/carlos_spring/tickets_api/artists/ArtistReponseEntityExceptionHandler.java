package com.carlos_spring.tickets_api.artists;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ArtistReponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { NoSuchElementException.class })
	public final ResponseEntity<ArtistErrorDetails> handleNoSuchElementExceptionException(Exception ex,
			WebRequest request) throws Exception {
		ArtistErrorDetails errorDetails = new ArtistErrorDetails(LocalDate.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ArtistErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
}

