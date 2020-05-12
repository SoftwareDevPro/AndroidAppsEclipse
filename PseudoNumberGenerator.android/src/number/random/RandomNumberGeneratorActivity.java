package number.random;

import android.app.Activity;
import android.os.Bundle;

/**
 * TODO
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RandomNumberGeneratorActivity 
extends Activity {
    
	/** 
     * Called when the activity is first created. 
     */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
    	
    	// Invoke super class behavior.
        super.onCreate(savedInstanceState);
        
        // Set the content view.
        setContentView(R.layout.main);
    }
}