package com.devsuperior.bds02.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class Error implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	private Instant timesinstant;
	private Integer status;
	private String error;
	private String message;
	private String path;

	// Construtor
	public Error() {
	}

	//Gets e Sets
	public Instant getTimesinstant() {
		return timesinstant;
	}

	public void setTimesinstant(Instant timesinstant) {
		this.timesinstant = timesinstant;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
