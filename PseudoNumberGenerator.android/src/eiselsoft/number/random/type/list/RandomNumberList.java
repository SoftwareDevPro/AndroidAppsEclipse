package eiselsoft.number.random.type.list;

import java.util.ArrayList;

import eiselsoft.number.random.type.RandomNumber;


/**
 * Sub-classes {@link ArrayList} to provide {@link RandomNumber}
 * as the concrete type that it holds.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see RandomNumber
 */
public class RandomNumberList 
extends ArrayList< RandomNumber > {

	/**
	 * for serialization purposes. 
	 */
	private static final long serialVersionUID = 583814606046460641L;

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString() {
		
		final RandomNumber[] numbers =
			toArray(new RandomNumber[0]);

		final StringBuilder builder =
			new StringBuilder();
		
		for (int idx = numbers.length - 1; idx >= 0; idx--) {
			builder.append(" ").append(numbers[idx]);
		}
		
		return builder.toString();
	}
}
