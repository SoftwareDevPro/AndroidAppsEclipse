package app.wifi.startscan;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import app.wifi.scanner.WiFiScannerIF;
import app.wifi.scanner.async.task.WiFiScannerAsyncTask;
import app.wifi.scanner.exception.handler.ScanNotStartedExceptionHandlerIF;

/**
 * StartScanButtonOnClickListener is an {@link OnClickListener}
 * which starts the wi-fi access pont scan.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class StartScanButtonOnClickListener 
implements OnClickListener {

	/** For Logging Purposes. */
	private final String LOG_TAG =
		StartScanButtonOnClickListener.class.getSimpleName();
	
	/** the async task which starts the wi-fi access point scan. */
	private WiFiScannerAsyncTask async;

	/**
	 * the scanner which kicks off the wi-fi access point scan.
	 */
	private final WiFiScannerIF wifiScanner;

	/**
	 * the exception handler for scans not being started.
	 */
	private final ScanNotStartedExceptionHandlerIF exceptionHandler;
	
	/**
	 * Constructs the click listener.
	 * 
	 * @param scanner the scanner which kicks off the wi-fi scan.
	 * @param handler the handler for any exceptions.
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public StartScanButtonOnClickListener(final WiFiScannerIF scanner, 
                                          final ScanNotStartedExceptionHandlerIF handler) {
		
		Log.d(LOG_TAG, "ctor-enter");

		if (null == scanner) {
			throw new IllegalArgumentException("scanner can not be null");
		}
		if (null == handler) {
			throw new IllegalArgumentException("handler can not be null");
		}
		
		this.wifiScanner =
			scanner;
		
		this.exceptionHandler =
			handler;
		
		Log.d(LOG_TAG, "ctor-exit");
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View v) {
		
		Log.d(LOG_TAG, "onClick-enter");
		
		Log.v(LOG_TAG, "onClick-[starting access point scan]");

		AsyncTask.Status status;
		
		if (null == async) {
			Log.v(LOG_TAG, "[no previous task, creating it]");
			
			async =
				new WiFiScannerAsyncTask(wifiScanner, exceptionHandler);
			
		} else {

			// If we have one that's done, re-create the async task.
			status = async.getStatus();
			
			if (status.equals(AsyncTask.Status.FINISHED)) {
				Log.v(LOG_TAG, "[previous task finished, re-creating it]");
				
				async =
					new WiFiScannerAsyncTask(wifiScanner, exceptionHandler);
			}
		}
		
		status = async.getStatus();

		if (status.equals(AsyncTask.Status.RUNNING)) {
			
			Log.w(LOG_TAG, "[wi-fi scanner still running]");
			
			return;
		}
		
		// If its not running, its pending so execute it...
		Log.v(LOG_TAG, "[executing async task for scan]");
		
		// Start the Access Point Scan
		async.execute();
		
		Log.d(LOG_TAG, "onClick-exit");
	}
}
