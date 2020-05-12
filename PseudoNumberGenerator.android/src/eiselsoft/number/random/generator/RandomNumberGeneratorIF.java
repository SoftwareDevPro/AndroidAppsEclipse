package eiselsoft.number.random.generator;

import eiselsoft.number.random.parameters.ParameterMaxNumber;
import eiselsoft.number.random.parameters.ParameterMinNumber;
import eiselsoft.number.random.type.RandomNumber;

/**
 * RandomNumberGeneratorIF represents an interface for which
 * concrete implementations can provide random numbers.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see RandomNumber
 * @see ParameterMaxNumber
 * @see ParameterMinNumber
 */
public interface RandomNumberGeneratorIF {

	/**
	 * Returns a (pseudo) randomly generated
	 * number.
	 * 
	 * @return the next randomly generated number.
	 */
	RandomNumber nextRandomNumber();
	
	/**
	 * Sets the maximum/biggest number to be produced by the 
	 * generator.
	 * 
	 * @param maximumNumber the biggest number to generate.
	 */
	void setMaximumNumber(ParameterMaxNumber maximumNumber);
	
	/**
	 * Sets the minimum/smallest number to be produced by the 
	 * generator.
	 * 
	 * @param minimumNumber the smallest number to generate.
	 */
	void setMinimumNumber(ParameterMinNumber minimumNumber);
}
