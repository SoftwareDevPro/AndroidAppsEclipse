package eiselsoft.number.random.parameters.defaults;

import eiselsoft.number.random.parameters.ParameterMinNumber;

/**
 * DefaultParameterMinNumber is a {@link ParameterMinNumber} which 
 * serves as a default in absence  of a value provided from some other source 
 * (e.g. user, external agents).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class DefaultParameterMinNumber 
extends ParameterMinNumber {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = -5740882844951310234L;

	/**
	 * the default value for this parameter. 
	 */
	public static final Integer DEFAULT_VALUE =
		Integer.valueOf(1);
	
	/**
	 * Constructs the parameter using 
	 * {@link DefaultParameterMinNumber#DEFAULT_VALUE} as the default.
	 */
	public DefaultParameterMinNumber() {
		super(DEFAULT_VALUE);
	}
	
	/**
	 * Returns the default value as a String.
	 * 
	 * @return the default value as a String.
	 */
	public static String asString() {
		return DEFAULT_VALUE.toString();
	}
}
