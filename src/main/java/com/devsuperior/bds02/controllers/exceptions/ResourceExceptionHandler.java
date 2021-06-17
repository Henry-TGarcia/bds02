package com.devsuperior.bds02.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.services.exceptions.DataIntegrityException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		Error err = new Error();
		err.setTimesinstant(Instant.now());
		err.setStatus(status.value()); // codigo 404
		err.setError("Rosource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI()); // Pega o caminho da requisição

		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<Error> entityNotFound(DataIntegrityException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		Error err = new Error();
		err.setTimesinstant(Instant.now());
		err.setStatus(status.value()); // codigo 400
		err.setError("Rosource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI()); // Pega o caminho da requisição

		return ResponseEntity.status(status).body(err);
	}
}
