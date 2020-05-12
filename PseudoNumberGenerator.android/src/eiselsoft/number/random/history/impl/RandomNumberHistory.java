package eiselsoft.number.random.history.impl;

import eiselsoft.number.random.history.RandomNumberHistoryIF;
import eiselsoft.number.random.type.RandomNumber;
import eiselsoft.number.random.type.list.RandomNumberList;

/**
 * RandomNumberHistory implements {@link RandomNumberHistoryIF}
 * to provide easy access to a history of random numbers,
 * by provide an add method, a clear history method, and
 * a toString override to provide a string.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RandomNumberHistory 
implements RandomNumberHistoryIF {

	/**
	 * the list of random numbers. 
	 */
	private RandomNumberList history =
		new RandomNumberList();
	
	/**
	 * the singleton instance.
	 */
	private static final RandomNumberHistoryIF INSTANCE =
		new RandomNumberHistory();
	
	/**
	 * Private - Singleton Class.
	 */
	private RandomNumberHistory() {
		// NULL
	}

	/**
	 * Returns the singleton instance of the random number 
	 * history.
	 * 
	 * @return the single instance
	 */
	public static final RandomNumberHistoryIF getInstance() {
		return INSTANCE;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see eiselsoft.number.random.history.RandomNumberHistoryIF#addNumber(eiselsoft.number.random.type.RandomNumber)
	 */
	public void addNumber(final RandomNumber numberToAdd) {
		history.add(numberToAdd);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see eiselsoft.number.random.history.RandomNumberHistoryIF#clearHistory()
	 */
	public void clearHistory() {
		history.clear();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Past Numbers: " + history.toString();
	}
}
