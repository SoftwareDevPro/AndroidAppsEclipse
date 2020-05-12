package eiselsoft.number.random;

import eiselsoft.number.random.clearhistory.ClearHistoryOnClickListener;
import eiselsoft.number.random.generator.RandomNumberGeneratorIF;
import eiselsoft.number.random.generator.impl.RandomNumberGenerator;
import eiselsoft.number.random.max.MaxNumberFocusChangeListener;
import eiselsoft.number.random.min.MinNumberFocusChangeListener;
import eiselsoft.number.random.next.NextOnClickListener;
import eiselsoft.number.random.parameters.defaults.DefaultParameterMaxNumber;
import eiselsoft.number.random.parameters.defaults.DefaultParameterMinNumber;
import eiselsoft.number.random.reset.ResetOnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * RandomNumberGeneratorActivity represents the primary activity
 * that the user interacts with to generate random numbers.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RandomNumberGeneratorActivity 
extends Activity {
    
	/**
	 * for logging purposes.
	 */
	private final String LOG_TAG = 
		RandomNumberGeneratorActivity.class.getSimpleName();
	
	/**
	 * the minimum random number value box.
	 */
	private EditText minBox;
	
	/**
	 * the maximum random number value box.
	 */
	private EditText maxBox;

	/**
	 * the next random number button.
	 */
	private Button nextButton;

	/**
	 * the clear history button.
	 */
	private Button clearHistoryButton;

	/**
	 * the reset parameters button.
	 */
	private Button resetButton;
	
	/**
	 * the random number generator.
	 */
	private RandomNumberGeneratorIF generator;
	
	/**
	 * the last number which displays at the top of the activity.
	 */
	private TextView lastNumberBox;
	
	/**
	 * the history text box. 
	 */
	private TextView historyBox;
	
	/** 
     * Called when the activity is first created. 
     */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
    	
		Log.d(LOG_TAG, "onCreate-enter");
		
    	// Invoke super class behavior.
        super.onCreate(savedInstanceState);
        
        // Set the content view.
        setContentView(R.layout.main);
        
        // Cache a local reference to the minimum number box.
        this.minBox =
        	(EditText) findViewById(R.id.MinimumNumberEditText);
        
        // Cache a local reference to the maximum number box.
        this.maxBox =
        	(EditText) findViewById(R.id.MaximumNumberEditText);
        
        // Cache a local reference to the reset button.
        this.resetButton =
        	(Button) findViewById(R.id.ResetButton);
        
        // Cache a local reference to the clear history button.
        this.clearHistoryButton =
        	(Button) findViewById(R.id.ClearHistoryButton);
        
        // Cache a local reference to the next button.
        this.nextButton =
        	(Button) findViewById(R.id.NextNumberButton);
        
        // Cache a local reference to the last number text view.
        this.lastNumberBox =
        	(TextView) findViewById(R.id.LastResultTextView);
        
        // Cache a local reference to the history text view.
        this.historyBox =
        	(TextView) findViewById(R.id.HistoryTextView);
        
        // Create the random number generator.
        this.generator = new RandomNumberGenerator();
        
        // Setup the click listeners.
        setClickListeners();
        
        // Setup the focus listeners
        setFocusListeners();
        
        // Set the default values.
        setDefaultValues();
        
		Log.d(LOG_TAG, "onCreate-exit");
    }
    
    /**
     * This method simply creates, and attach's on click
     * listeners to each of the buttons.
     */
    private void setClickListeners() {
    	
		Log.d(LOG_TAG, "setClickListeners-enter");
		
		// Setup the reset button
		resetButton.setOnClickListener(new 
				ResetOnClickListener(minBox, maxBox, generator));
		
		// Setup the next number button
		nextButton.setOnClickListener(new 
				NextOnClickListener(lastNumberBox, historyBox, generator));
		
		// Setup the clear history button.
		clearHistoryButton.setOnClickListener(new 
				ClearHistoryOnClickListener(historyBox));
		
		Log.d(LOG_TAG, "setClickListeners-exit");
    }
    
    /**
     * This method simply sets up the default parameters
     * for the minimum and maximum edit text boxes. 
     */
    private void setDefaultValues() {
    	
		Log.d(LOG_TAG, "setDefaultValues-enter");
		
		// Set the minimum number default.
		minBox.setText(DefaultParameterMinNumber.asString());
		
		// Set the maximum number default.
		maxBox.setText(DefaultParameterMaxNumber.asString());
    	
		Log.d(LOG_TAG, "setDefaultValues-exit");
    }
    
    /**
     * Sets the focus listeners on the minimum and maximum
     * text box's.
     */
    private void setFocusListeners() {
    	
		Log.d(LOG_TAG, "setFocusListeners-enter");

		// Set the minimum box focus change listener.
		minBox.setOnFocusChangeListener(
				new MinNumberFocusChangeListener(generator, minBox));
		
		// Set the maximum box focus change listener.
		maxBox.setOnFocusChangeListener(
				new MaxNumberFocusChangeListener(generator, maxBox));
    	
		Log.d(LOG_TAG, "setFocusListeners-exit");
    }
}
