package com.cg.fms.exception;

public class AdminException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public AdminException(String errorMessage) {
		super(errorMessage);
	}
}


