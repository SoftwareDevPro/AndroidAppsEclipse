package eiselsoft.number.random.parameters.defaults;

import eiselsoft.number.random.parameters.ParameterMaxNumber;

/**
 * DefaultParameterMaxNumber is a {@link ParameterMinNUmber} which
 * serves as a default in absence of a value provided from some other
 * source (e.g. user, external agents).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class DefaultParameterMaxNumber 
extends ParameterMaxNumber {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = -2230203618667858777L;
	
	/**
	 * the default value for this parameter. 
	 */
	public static final Integer DEFAULT_VALUE =
		Integer.valueOf(10);
	
	/** 
	 * Constructs the parameter using 
	 * {@link DefaultParameterMaxNumber#DEFAULT_VALUE} as the default.
	 */
	public DefaultParameterMaxNumber() {
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
