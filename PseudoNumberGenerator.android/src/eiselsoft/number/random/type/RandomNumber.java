package eiselsoft.number.random.type;

/**
 * RandomNumber represents a randomly generated number.  This
 * number is represented by an {@link Integer}.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RandomNumber 
extends Number {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = 7449740457690229548L;
	
	/**
	 * the value of the random number.
	 */
	private final Integer randomValue;
	
	/**
	 * Constructs the random number using the passed
	 * in value to represent it.
	 * 
	 * @param value the value of the RandomNumber
	 */
	public RandomNumber(final Integer value) {
		
		// Sanity check the value.
		if (null == value) {
			throw new IllegalArgumentException("value can not be null");
		}
		
		this.randomValue = value;
	}
	
	/**
	 * @see java.lang.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {
		return randomValue.doubleValue();
	}

	/**
	 * @see java.lang.Number#floatValue()
	 */
	@Override
	public float floatValue() {
		return randomValue.floatValue();
	}

	/**
	 * @see java.lang.Number#intValue()
	 */
	@Override
	public int intValue() {
		return randomValue.intValue();
	}

	/**
	 * @see java.lang.Number#longValue()
	 */
	@Override
	public long longValue() {
		return randomValue.longValue();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return randomValue.toString();
	}
}
