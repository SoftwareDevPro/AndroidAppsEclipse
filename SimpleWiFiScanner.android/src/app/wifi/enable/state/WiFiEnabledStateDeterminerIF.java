package app.wifi.enable.state;

/**
 * WiFiEnabledStateDeterminerIF provides clients an interface
 * to determine wi-fi status from.
 *
 * @author Chris Adamson
 * @version 1.0
 */
public interface WiFiEnabledStateDeterminerIF {

	/**
	 * Returns the enabled state of wi-fi on
	 * the device.
	 * 
	 * @return {@link Boolean#TRUE} if it is enabled,
	 * {@link Boolean#FALSE} otherwise.
	 */
	Boolean wifiEnabled();
}
