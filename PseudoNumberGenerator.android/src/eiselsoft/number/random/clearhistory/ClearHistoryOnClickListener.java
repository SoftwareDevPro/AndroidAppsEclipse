package eiselsoft.number.random.clearhistory;

import eiselsoft.number.random.history.RandomNumberHistoryIF;
import eiselsoft.number.random.history.impl.RandomNumberHistory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * ClearHistoryOnClickListener implements {@link OnClickListener} to
 * clear a {@link TextView} that holds a history of numbers.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ClearHistoryOnClickListener 
implements OnClickListener {

	/**
	 * the text view that holds the history to clear.
	 */
	private final TextView historyTextView;
	
	/**
	 * for logging purposes.
	 */
	private final String LOG_TAG = 
		ClearHistoryOnClickListener.class.getSimpleName();
	
	/**
	 * the initial text string to fill history box with.
	 */
	public final static String INITIAL_TEXT =
		"Past Numbers:";
	
	/**
	 * the actual history of random numbers. 
	 */
	private final RandomNumberHistoryIF history =
		RandomNumberHistory.getInstance();
	
	/**
	 * Constructs the click listener using the text view
	 * which holds history of numbers.
	 * 
	 * @param historyView the text view that holds the history.
	 */
	public ClearHistoryOnClickListener(final TextView historyView) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		// Sanity Check the argument.
		if (null == historyView) {
			throw new IllegalArgumentException("historyView can not be null");
		}
		
		this.historyTextView =
			historyView;
		
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

		// Reset back to the initial text.
		historyTextView.setText(INITIAL_TEXT);
		
		// ... and clear the history.
		history.clearHistory();
		
		Log.d(LOG_TAG, "onClick-exit");
		
	}
}
