package app.wifi.broadcast.receiver.intent.filter;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;

/**
 * ScanResultsAvailableIntent represents a concrete IntentFilter that
 * uses the Wi-Fi Managers scan results available as the action.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ScanResultsAvailableIntentFilter 
extends IntentFilter {

	/**
	 * Constructs the {@link IntentFilter} using 
	 * {@link WifiManager#SCAN_RESULTS_AVAILABLE_ACTION} as the action.
	 */
	public ScanResultsAvailableIntentFilter() {
		super(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
	}
}
