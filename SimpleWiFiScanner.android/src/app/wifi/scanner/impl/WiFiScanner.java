package app.wifi.scanner.impl;

import android.content.Context;
import android.net.wifi.WifiManager;
import app.wifi.scanner.WiFiScannerIF;
import app.wifi.scanner.exception.ScanNotStartedException;

/**
 * WiFiScanner implements {@link WiFiScannerIF} to provide
 * an simple interface which provides a method to start
 * an wi-fi access point scan.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see WiFiScannerIF
 */
public class WiFiScanner 
implements WiFiScannerIF {

	/** the context to use  for retrieving the WiFiManager. */
	private Context context;
	
	/** the wi-fi manager to use in scanning access points. */
	private WifiManager wifiManager;

	/**
	 * Constructs the scanner using the passed in Context which
	 * is then used to grab the Wi-Fi manager system service.
	 * 
	 * @param ctx the context to use in grabbing the wi-fi scanner.
	 */
	public WiFiScanner(final Context ctx) {
		
		// Cache a local reference to the context.
		this.context = 
			ctx;
		
		// Grab the wi-fi manager using the context.
		this.wifiManager =
			(WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see app.wifi.scanner.WiFiScannerIF#startAccessPointScan()
	 */
	public void startAccessPointScan() throws ScanNotStartedException {
		
		// Attempt to start the wi-fi scan
		final boolean started =
			wifiManager.startScan();
		
		// Throw an exception if it failed to start.
		if (started == false) {
			throw new ScanNotStartedException();			
		}
	}
}

