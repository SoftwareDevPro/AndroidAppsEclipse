package eiselsoft.number.random.next;

import eiselsoft.number.random.clearhistory.ClearHistoryOnClickListener;
import eiselsoft.number.random.generator.RandomNumberGeneratorIF;
import eiselsoft.number.random.history.RandomNumberHistoryIF;
import eiselsoft.number.random.history.impl.RandomNumberHistory;
import eiselsoft.number.random.type.RandomNumber;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * NextOnClickListener implements {@link OnClickListener} to update
 * the last number generated text view, and a history text view,
 * when clicked.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class NextOnClickListener 
implements OnClickListener {

	/**
	 * the history text box.
	 */
	private TextView historyTextView;
	
	/**
	 * the pseudo-random number generator.
	 */
	private RandomNumberGeneratorIF prng;

	/**
	 * the last number to be generated.
	 */
	private TextView lastNumberTextView;
	
	/**
	 * the actual history of random numbers. 
	 */
	private final RandomNumberHistoryIF history =
		RandomNumberHistory.getInstance();
	
	/**
	 * for logging purposes.
	 */
	private final String LOG_TAG = 
		NextOnClickListener.class.getSimpleName();


	/**
	 * Constructs the {@link OnClickListener} using the last number
	 * text view which gets updated with the last result, the history
	 * text view to update, and the number generator to use in updating 
	 * numbers.
	 * 
	 * @param lastNumber the last number text view.
	 * @param historyView the text view to put the history in.
	 * @param numberGenerator the random number generator to use.
	 * @throws IllegalArgumentException if any parameter is null.
	 */
	public NextOnClickListener(final TextView lastNumber,
			                   final TextView historyView,
                               final RandomNumberGeneratorIF numberGenerator) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		// Sanity check the arguments.
		if (null == lastNumber) {
			throw new IllegalArgumentException("historyView can not be null");
		}
		if (null == historyView) {
			throw new IllegalArgumentException("historyView can not be null");
		}
		if (null == numberGenerator) {
			throw new IllegalArgumentException("numberGenerator can not be null");
		}
		
		this.lastNumberTextView = lastNumber;
		this.historyTextView = historyView;
		this.prng = numberGenerator;
		
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
		
		// Grab the next random number.
		final RandomNumber nextRandomNumber =
			prng.nextRandomNumber();

		// Add the random number to the end of the list.
		history.addNumber(nextRandomNumber);
		
		final String historyText =
			historyTextView.toString();
		
		// ... and set the last number box.
		lastNumberTextView.setText(nextRandomNumber.toString());
		
		if (! historyText.equals(ClearHistoryOnClickListener.INITIAL_TEXT)) {
			
			historyTextView.setText(history.toString());
		}
		
		Log.d(LOG_TAG, "onClick-exit");
	}
}
