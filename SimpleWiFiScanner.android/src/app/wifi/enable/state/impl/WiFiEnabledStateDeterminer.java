package app.wifi.enable.state.impl;

import android.content.Context;
import android.net.wifi.WifiManager;
import app.wifi.enable.state.WiFiEnabledStateDeterminerIF;

/**
 * WiFiEnabledStateDeterminer is a simple implementation of 
 * {@link WiFiEnabledStateDeterminerIF} that returns the
 * enabled state of the wi-fi on the device.
 *
 * @author Chris Adamson
 * @version 1.0
 * @see WiFiEnabledStateDeterminerIF
 */
public class WiFiEnabledStateDeterminer 
implements WiFiEnabledStateDeterminerIF {

	/**
	 * reference to the context which is used
	 * to get the wi-fi manager.
	 */
	private final Context ctx;
	
	/**
	 * reference to the wi-fi manager.
	 */
	private final WifiManager wifiManager;

	/**
	 * Constructs the wi-fi enabler using the passed
	 * context which is used to get a reference to
	 * the system wi-fi manager.
	 * 
	 * @param context the context to use.
	 * @throws IllegalArgumentException if context is null.
	 */
	public WiFiEnabledStateDeterminer(final Context context) {
		
		// Sanity check the argument.
		if (null == context) {
			throw new IllegalArgumentException("context can not be null");
		}
		
		// Cache a local reference to the context.
		this.ctx =
			context;
		
		// Grab a reference to the wi-fi manager.
		this.wifiManager =
			(WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see app.wifi.enable.state.WiFiEnabledStateDeterminerIF#wifiEnabled()
	 */
	@Override
	public Boolean wifiEnabled() {
		return Boolean.valueOf(
				wifiManager.isWifiEnabled());
	}
}

