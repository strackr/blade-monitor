package vcu.blademonitor.logging;

/**
 * Exception signalizing problems with logger creation.
 */
public class LogInitializationException extends RuntimeException {

	private static final long serialVersionUID = 7579753296193497671L;

	public LogInitializationException() {
	}

	public LogInitializationException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogInitializationException(String message) {
		super(message);
	}

	public LogInitializationException(Throwable cause) {
		super(cause);
	}

}
