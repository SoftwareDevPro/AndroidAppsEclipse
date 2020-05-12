package app.wifi.scanner.exception;

/**
 * The scan not started exception can be used to indicate an exceptional
 * condition where a access point scan could not be started.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ScanNotStartedException 
extends Exception {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = 2465712470674275690L;

	/**
	 * Constructs the exception using a default string as the
	 * detailed message.
	 */
	public ScanNotStartedException() {
		super("wi-fi access point scan could not be started.");
	}

	/**
	 * Constructs the exception using the detailed messaged,
	 * and the throwable.
	 * 
	 * @param detailMessage the detailed message to use.
	 * @param throwable the throwable to pass down to the super-class.
	 */
	public ScanNotStartedException(final String detailMessage, 
                                   final Throwable throwable) {
		super(detailMessage, throwable);
	}

	/**
	 * Constructs the exception using only the detailed
	 * message.
	 * 
	 * @param detailMessage the detailed message to use.
	 */
	public ScanNotStartedException(final String detailMessage) {
		super(detailMessage);
	}

	/**
	 * Constructs the exception using the throwable passed.
	 * 
	 * @param throwable the throwable to pass down to the super-class.
	 */
	public ScanNotStartedException(final Throwable throwable) {
		super(throwable);
	}
}
