package app.wifi.broadcast.receiver.intent;

import android.content.Intent;
import android.net.wifi.WifiManager;

/**
 * ScanResultsAvailableIntent represents a concrete Intent that
 * uses the Wi-Fi Managers scan results available as the action.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ScanResultsAvailableIntent 
extends Intent {
	
	/**
	 * Constructs the {@link Intent} using 
	 * {@link WifiManager#SCAN_RESULTS_AVAILABLE_ACTION} as the action.
	 */
	public ScanResultsAvailableIntent() {
		super(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
	}
}
