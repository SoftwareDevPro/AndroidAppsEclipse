package app.wifi.broadcast.receiver;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import app.wifi.broadcast.receiver.intent.filter.ScanResultsAvailableIntentFilter;
import app.wifi.scanner.resultsreceiver.WiFiScannerResultsReceiver;

/**
 * ScanResultsAvailableBroadcastReceiver is a broadcast receiver that
 * listens for when a wi-fi access point scan is complete, and then
 * notifes scan results receiver with the results.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ScanResultsAvailableBroadcastReceiver 
extends BroadcastReceiver {

	/**
	 * the context to register this object as a {@link BroadcastReceiver}
	 * with.
	 */
	private final Context ctx;
	
	/**
	 * the wi-fi manager to get the scan results from.
	 */
	private final WifiManager wifiManager;

	/**
	 * the wi-fi scanner results receiver to update.
	 */
	private WiFiScannerResultsReceiver resultsReceiver;

	/**
	 * Constructs the broadcast receiver using the context
	 * which is used to register this object as a broadcast
	 * receiver, the wi-fi manager to get the scan results
	 * from, and the results receiver to send a list of scan 
	 * results.
	 * 
	 * @param context the context to use.
	 * @param manager the wi-fi manager
	 * @param receiver the receiver to update with results.
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public  ScanResultsAvailableBroadcastReceiver(final Context context,
                                                  final WifiManager manager,
                                                  final WiFiScannerResultsReceiver receiver) {
		
		// Sanity check the passed argument.
		if (null == context) {
			throw new IllegalArgumentException("the context can not be null");
		}
		if (null == manager) {
			throw new IllegalArgumentException("the manager can not be null");
		}
		if (null == receiver) {
			throw new IllegalArgumentException("the receiver can not be null");
		}
		
		// Save a local reference to the context.
		this.ctx = context;
		
		// Save a local reference to the wi-fi manager.
		this.wifiManager = manager;
		
		// Save a local reference to the wi-fi scan results receiver.
		this.resultsReceiver = receiver;
		
		// Register this as a receiver.
		ctx.registerReceiver(this, new ScanResultsAvailableIntentFilter());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(final Context context, final Intent intent) {

		// Grab the action from the intent.
		final String action =
			intent.getAction();

		// Grab the action we are looking for.
		final String scanResultsAction =
			WifiManager.SCAN_RESULTS_AVAILABLE_ACTION;
		
		// Filter out non-interesting actions.
		if (scanResultsAction.equalsIgnoreCase(action)) {
			
			final List < ScanResult > scanResults =
				wifiManager.getScanResults();
			
			// Notify the results receiver. 			
			resultsReceiver.onScannerResultsReceiver(scanResults);
		}
	}
}

