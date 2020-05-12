package eiselsoft.number.random.history;

import eiselsoft.number.random.type.RandomNumber;

/**
 * RandomNumberHistoryIF represents an interface for
 * which concrete objects can implement a history
 * of random numbers.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public interface RandomNumberHistoryIF {

	/**
	 * Adds the passed in number to the list of random numbers.
	 * 
	 * @param numberToAdd the new number to add.
	 */
	void addNumber(final RandomNumber numberToAdd);

	/**
	 * Clears the history out. 
	 */
	void clearHistory();
}