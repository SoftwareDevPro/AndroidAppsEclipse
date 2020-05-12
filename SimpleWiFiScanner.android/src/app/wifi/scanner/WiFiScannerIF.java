package app.wifi.scanner;

import app.wifi.scanner.exception.ScanNotStartedException;

/**
 * Implementations of WiFiScannerIF provide one method which
 * starts a wi-fi access point scan, and potentially throw
 * an exception if the scan can not be started.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public interface WiFiScannerIF {

	/** 
	 * Attempts to start a wi-fi access point scan, if it does not
	 * start, an exception is thrown.
	 * 
	 * @throws ScanNotStartedException if the scan can not be started.
	 * @see ScanNotStartedException
	 */
	void startAccessPointScan() throws ScanNotStartedException;
}