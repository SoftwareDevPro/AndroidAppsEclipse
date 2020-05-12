package eiselsoft.number.random.generator.impl;

import java.util.Random;

import eiselsoft.number.random.generator.RandomNumberGeneratorIF;
import eiselsoft.number.random.parameters.ParameterMaxNumber;
import eiselsoft.number.random.parameters.ParameterMinNumber;
import eiselsoft.number.random.parameters.defaults.DefaultParameterMaxNumber;
import eiselsoft.number.random.parameters.defaults.DefaultParameterMinNumber;
import eiselsoft.number.random.type.RandomNumber;


/**
 * RandomNumberGenerator is an implementation of {@link RandomNumberGeneratorIF}
 * to produce random numbers (integers) which are within a range of numbers
 * as defined by a given (or default) minimum and maximum.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see RandomNumberGeneratorIF
 */
public class RandomNumberGenerator 
implements RandomNumberGeneratorIF {

	/**
	 * the minimum number to generate.
	 */
	private ParameterMinNumber minNumber;
	
	/**
	 * the maximum number to generate. 
	 */
	private ParameterMaxNumber maxNumber;
	
	/**
	 * the random number generator behind the scenes.
	 */
	private final Random random =
		new Random();

	/**
	 * Constructs the random generator using the defaults
	 * for the minimum and maximum parameters.
	 * 
	 * @see DefaultParameterMaxNumber
	 * @see DefaultParameterMinNumber
	 */
	public RandomNumberGenerator() {
		this(new DefaultParameterMaxNumber(), 
             new DefaultParameterMinNumber());
	}
	
	/**
	 * Constructs the random generator using the defaults
	 * for the minimum and maximum parameters.
	 * 
	 * @param max the maximum number to generate.
	 * @param min the minimum number to generate.
	 */
	public RandomNumberGenerator(final ParameterMaxNumber max,
                                 final ParameterMinNumber min) {
		setMaximumNumber(max);
		setMinimumNumber(min);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see eiselsoft.number.random.generator.RandomNumberGeneratorIF#nextRandomNumber()
	 */
	@Override
	public RandomNumber nextRandomNumber() {
		
		final int minValue =
			minNumber.intValue();
		
		final int maxValue =
			maxNumber.intValue();
		
		final int randomValue =
			random.nextInt(maxValue - minValue + 1) + minValue;
			
		return new RandomNumber(Integer.valueOf(randomValue));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see eiselsoft.number.random.generator.RandomNumberGeneratorIF#setMaximumNumber(eiselsoft.number.random.parameters.ParameterMaxNumber)
	 * @throws IllegalArgumentException if maximumNumber is null.
	 */
	@Override
	public void setMaximumNumber(final ParameterMaxNumber maximumNumber) {
		
		// Sanity check the passed argument.
		if (null == maximumNumber) {
			throw new IllegalArgumentException("maximumNumber can not be null");
		}
		this.maxNumber = maximumNumber;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see eiselsoft.number.random.generator.RandomNumberGeneratorIF#setMinimumNumber(eiselsoft.number.random.parameters.ParameterMinNumber)
	 * @throws IllegalArgumentException if minimumNumber is null.
	 */
	@Override
	public void setMinimumNumber(final ParameterMinNumber minimumNumber) {

		// Sanity check the passed argument.
		if (null == minimumNumber) {
			throw new IllegalArgumentException("minimumNumber can not be null");
		}
		this.minNumber = minimumNumber;
	}
}
