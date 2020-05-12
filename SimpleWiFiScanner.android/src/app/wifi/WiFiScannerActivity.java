package app.wifi;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import app.wifi.broadcast.receiver.ScanResultsAvailableBroadcastReceiver;
import app.wifi.enable.WiFiEnablerIF;
import app.wifi.enable.impl.WiFiEnabler;
import app.wifi.scanner.WiFiScannerIF;
import app.wifi.scanner.exception.handler.ScanNotStartedExceptionHandlerIF;
import app.wifi.scanner.exception.handler.impl.ScanNotStartedExceptionHandler;
import app.wifi.scanner.impl.WiFiScanner;
import app.wifi.scanner.resultsreceiver.WiFiScannerResultsReceiver;
import app.wifi.startscan.StartScanButtonOnClickListener;

/**
 * WiFiScannerActivity represents the primary activity 
 * for the application.  It handles the setup of the
 * various elements such as the start access point scan
 * click listener.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class WiFiScannerActivity 
extends Activity 
implements WiFiScannerResultsReceiver {
	
	/** the wi-fi scanner implementation. */
	private WiFiScannerIF scanner;
    
	/** For Logging Purposes. */
	private final String LOG_TAG =
		WiFiScannerActivity.class.getSimpleName();

	/** handles the starting of the scan. */
	private Button startScanButton;

	/** to handle when the start scan button is clicked. */
	private StartScanButtonOnClickListener startOnClickListener;
	
	/** to handle the case where the scan can not be started. */
	private ScanNotStartedExceptionHandlerIF scanNotStartedExceptionHandler;

	/** to display the results from the access point scan. */
	private TextView resultsWindow;

	/** the broadcast receiver for wi-fi scan results. */
	@SuppressWarnings("unused")
	private ScanResultsAvailableBroadcastReceiver scanResultsReceiver;

	/** used to enable the wi-fi on the device.  */
	private WiFiEnablerIF enabler;
	
	/** 
	 * Called when the activity is first created. 
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	Log.d(LOG_TAG, "onCreate-enter");
    	
    	// Invoke super class behavior
    	super.onCreate(savedInstanceState);
    	
    	// Set the content view.
        setContentView(R.layout.main);
        
        // Create the wi-fi scanner.
        scanner =
        	new WiFiScanner(getApplicationContext());
        
        // Cache a local reference to the start scan button.
        startScanButton = 
        	(Button) findViewById(R.id.StartScanButton);
        
        // Create the exception handler.
        scanNotStartedExceptionHandler = 
        	new ScanNotStartedExceptionHandler(this);
        
        // Create the start scan button click listener.
        startOnClickListener =
        	new StartScanButtonOnClickListener(scanner, scanNotStartedExceptionHandler);
        
        // Set the click listener.
        startScanButton.setOnClickListener(startOnClickListener);
        
        // Cache a reference to the results text view.
        this.resultsWindow = 
        	(TextView) findViewById(R.id.ScanResultsTextView);
      
        WifiManager wifiManager =
        	(WifiManager) getSystemService(WIFI_SERVICE);
        
        // Create the broadcast receiver.
        scanResultsReceiver =
        	new ScanResultsAvailableBroadcastReceiver(this, wifiManager, this);
        
        Log.v(LOG_TAG, "[creating the wi-fi enabler]");
        
        // Create the wi-fi enabler.
        this.enabler =
        	new WiFiEnabler(this);
        
        Log.v(LOG_TAG, "[attempting to enable the wi-fi]");
        
        // Try and enable the wi-fi state.
        enabler.setEnabled(Boolean.TRUE);
        
    	Log.d(LOG_TAG, "onCreate-exit");
    }

	/**
	 * {@inheritDoc}
	 * 
	 * @see app.wifi.scanner.resultsreceiver.WiFiScannerResultsReceiver#onScannerResultsReceiver(java.util.List)
	 */
	public void onScannerResultsReceiver(final List < ScanResult > results) {

    	Log.d(LOG_TAG, "onScannerResultsReceiver-enter");
		
    	// Clear what's there already.
    	resultsWindow.setText("Scan Results:");
    	
    	final StringBuilder builder =
    		new StringBuilder(resultsWindow.getText());
    	
    	final Iterator <  ScanResult >  itr =
    		results.iterator();
    	
    	while (itr.hasNext()) {

    		ScanResult result = itr.next();
    		
    		// Grab the Basic Service Set Identifier (address).
    		final String bssid = result.BSSID;
    		
    		if (builder.toString().contains(bssid)) {
    			
    			Log.d(LOG_TAG, "duplicate BSSID in results:" + bssid + "]");
    			
    			continue;
    		}
    			
    		// Grab the Service Set Identifier.
    		final String ssid = result.SSID;
    		
    		// Grab the capabilities.
    		final String capabilities = 
    			result.capabilities;
    		
    		// Grab the frequency (MHz of the channel)
    		final String frequency =
    			String.valueOf(result.frequency);
    		
    		// Grab the level (detected signal level in dBm).
    		final String level =
    			String.valueOf(result.level);
    		
    		builder.append("\n");
    		builder.append("BSSID: ").append(bssid).append("\n");
    		builder.append("SSID: ").append(ssid).append("\n");
    		builder.append("Frequency: ").append(frequency).append("\n");
    		builder.append("Level: ").append(level).append("\n");
    		builder.append("Capabilties: ").append(capabilities).append("\n");
    		
    		resultsWindow.setText(builder.toString());
    	}
    	
    	Log.d(LOG_TAG, "onScannerResultsReceiver-exit");
	}
}

