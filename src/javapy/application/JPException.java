package javapy.application;

public class JPException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPException() {
	}

	// Constructor that accepts a message
	public JPException(String message) {
		super(message);
	}
}
