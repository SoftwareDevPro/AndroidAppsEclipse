package app.wifi.scanner.resultsreceiver;

import java.util.List;

import android.net.wifi.ScanResult;

/**
 * WiFiScannerResultsReceiver represents an interface for which
 * interested listeners can receive a list of Wi-Fi Scan Results.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public interface WiFiScannerResultsReceiver {

	/**
	 * Receives the Wi-Fi Access Point Scan Results.
	 * 
	 * @param results the scan results;
	 */
	void onScannerResultsReceiver(List < ScanResult > results);
}
