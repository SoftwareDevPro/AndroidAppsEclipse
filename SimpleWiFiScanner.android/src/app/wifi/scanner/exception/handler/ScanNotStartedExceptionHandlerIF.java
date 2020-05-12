package app.wifi.scanner.exception.handler;

import app.wifi.scanner.exception.ScanNotStartedException;

/**
 * ScanNotStartedExceptionHandler represents a handler for
 * which {@link ScanNotStartedException}'s can be handled.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public interface ScanNotStartedExceptionHandlerIF {

	/**
	 * Receives the scan not started exception so
	 * that it can be handled.
	 * 
	 * @param e the exception that was thrown.
	 */
	void onScanNotStartedException(ScanNotStartedException e);
}
