package app.wifi.scanner.async.task;

import android.os.AsyncTask;
import app.wifi.scanner.WiFiScannerIF;
import app.wifi.scanner.exception.ScanNotStartedException;
import app.wifi.scanner.exception.handler.ScanNotStartedExceptionHandlerIF;

/**
 * WiFiScannerAsyncTask is an {@link AsyncTask} which kicks
 * off the Wi-Fi Access Point Scanner.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class WiFiScannerAsyncTask 
extends AsyncTask<Void, Void, Void> {

	/**
	 * the scanner that looks for access points.
	 */
	private final WiFiScannerIF wifiScanner;
	
	/**
	 * the exception handler in case the access point 
	 * scan can't start.
	 */
	private final ScanNotStartedExceptionHandlerIF exceptionHandler;

	/**
	 * Constructs the {@link AsyncTask} using passed
	 * wi-fi scanner, and exception handler for when
	 * the access point scan can't start.
	 * 
	 * @param scanner the wi-fi scanner to use.
	 * @param handler the exception to use in case it doesn't start.
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public WiFiScannerAsyncTask(final WiFiScannerIF scanner,
                                final ScanNotStartedExceptionHandlerIF handler) {
		
		// Sanity check the arguments.
		if (null == scanner) {
			throw new IllegalArgumentException("scanner can not be null");
		}
		if (null == handler) {
			throw new IllegalArgumentException("handler can not be null");
		}
		
		this.wifiScanner = scanner;
		this.exceptionHandler = handler;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@Override
	protected Void doInBackground(Void... params) {
		
		try {
			// Start the scan
			wifiScanner.startAccessPointScan();
			
		} catch (final ScanNotStartedException e) {
			
			// Handle the exception.
			exceptionHandler.onScanNotStartedException(e);
		}
		// Required by the interface.
		return null;
	}
}
