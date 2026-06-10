package com.codecodence.admin_panel_backend.exception.InvalidCredintialsException;

public class InvalidCredentialsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

    public InvalidCredentialsException(String message) {
        super(message);
    }

}
