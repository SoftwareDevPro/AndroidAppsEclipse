package eiselsoft.number.random.reset;

import eiselsoft.number.random.generator.RandomNumberGeneratorIF;
import eiselsoft.number.random.parameters.defaults.DefaultParameterMaxNumber;
import eiselsoft.number.random.parameters.defaults.DefaultParameterMinNumber;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/**
 * ResetOnClickListener is an {@link OnClickListener} which is used
 * to reset the minimum and maximum parameters on the user interface (UI)
 * as well as the parameters in the random generator.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ResetOnClickListener 
implements OnClickListener {
	
	/**
	 * for logging purposes.
	 */
	private final String LOG_TAG = 
		ResetOnClickListener.class.getSimpleName();
	
	/**
	 * the minimum number edit text box to reset.
	 */
	private EditText minEditTextBox;
	
	/**
	 * the maximum number edit text box to reset.
	 */
	private EditText maxEditTextBox;
	
	/**
	 * the random number generator to update.
	 */
	private RandomNumberGeneratorIF numberGenerator;
	
	/**
	 * Constructs the click listener using the two EditText boxes
	 * to reset (to default values), and the random number generator
	 * to update.
	 * 
	 * @param minBox the minimum number box to reset.
	 * @param maxBox the maximum number box to reset.
	 * @param generator the random number generator to update.
	 * @see EditText
	 * @see RandomNumberGeneratorIF
	 */
	public ResetOnClickListener(final EditText minBox, 
                                final EditText maxBox,
                                final RandomNumberGeneratorIF generator) {
		
		Log.d(LOG_TAG, "ctor-enter");

		// Sanity check the arguments.
		if (null == minBox) {
			throw new IllegalArgumentException("minBox can not be null");
		}
		if (null == maxBox) {
			throw new IllegalArgumentException("maxBox can not be null");
		}
		if (null == generator) {
			throw new IllegalArgumentException("generator can not be null");
		}
		
		this.minEditTextBox = minBox;
		this.maxEditTextBox = maxBox;
		this.numberGenerator = generator;
		
		Log.d(LOG_TAG, "ctor-exit");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		
		Log.d(LOG_TAG, "onClick-enter");
		
		// Update the generator.
		Log.d(LOG_TAG, "onClick-[updating generator parameters]");
		
		numberGenerator.setMaximumNumber(new DefaultParameterMaxNumber());
		numberGenerator.setMinimumNumber(new DefaultParameterMinNumber());
		
		// Update the text boxes.
		Log.d(LOG_TAG, "onClick-[updating edit text boxes]");
		
		minEditTextBox.setText(DefaultParameterMinNumber.asString());
		maxEditTextBox.setText(DefaultParameterMaxNumber.asString());
		
		Log.d(LOG_TAG, "onClick-exit");
	}
}

