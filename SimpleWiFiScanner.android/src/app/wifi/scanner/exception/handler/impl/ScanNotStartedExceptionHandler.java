package app.wifi.scanner.exception.handler.impl;

import android.content.Context;
import android.widget.Toast;
import app.wifi.scanner.exception.ScanNotStartedException;
import app.wifi.scanner.exception.handler.ScanNotStartedExceptionHandlerIF;

/**
 * ScanNotStartedExceptionHandler implements {@link ScanNotStartedExceptionHandlerIF} to
 * handle the {@link ScanNotStartedException} should it get thrown.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see ScanNotStartedExceptionHandlerIF
 */
public class ScanNotStartedExceptionHandler 
implements ScanNotStartedExceptionHandlerIF {

	/**
	 * the context to use in generating Toast notifications.
	 */
	private Context ctx;
	
	/**
	 * Constructs the handler using the passed in context,
	 * which is used to generate Toast notifications
	 * when the handler is invoked.
	 * 
	 * @param context the context to use.
	 * @throws IllegalArgumentException if context is null.
	 */
	public ScanNotStartedExceptionHandler(final Context context) {
	
		if (null == context) {
			throw new IllegalArgumentException("context can not be null");
		}
		
		this.ctx = context;
	}
	/**
	 * {@inheritDoc}
	 * 
	 * This implementation simply generates a Toast notification
	 * to the user.
	 * 
	 * @see app.wifi.scanner.exception.handler.ScanNotStartedExceptionHandlerIF#onScanNotStartedException(app.wifi.scanner.exception.ScanNotStartedException)
	 */
	public void onScanNotStartedException(final ScanNotStartedException e) {
		
		// Generate the toast.
		Toast.makeText(ctx, 
                       "Unable to start Wi-Fi scan", 
                       Toast.LENGTH_SHORT);
	}
}

