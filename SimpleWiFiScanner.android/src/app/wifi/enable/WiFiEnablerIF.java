package app.wifi.enable;

/**
 * WiFiEnablerIF provides an interface for which clients
 * can set the enabled state of the wi-fi device.
 *
 * @author Chris Adamson
 * @version 1.0
 */
public interface WiFiEnablerIF {

	/**
	 * Sets the enabled state of the wi-fi device.
	 * 
	 * @param enabled {@link Boolean#TRUE} to enable it,
	 * {@link Boolean#FALSE} to disable it.
	 */
	void setEnabled(Boolean enabled);
}
