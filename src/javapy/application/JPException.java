package javapy.application;

public class JPException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor that does not accept a message.
	public JPException() {
	}

	// Constructor that accepts a message.
	public JPException(String message) {
		super(message);
	}
}
