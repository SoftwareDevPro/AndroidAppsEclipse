package app.voice.recognition;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import app.voice.recognition.capability.VoiceRecognitionCapabilityIF;
import app.voice.recognition.capability.impl.VoiceRecognitionCapability;

/**
 * TODO
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class VoiceRecognitionActivity 
extends Activity {

	/**
	 * for logging purposes.
	 */
	private final String LOG_TAG =
		VoiceRecognitionActivity.class.getSimpleName();
	
	/**
	 * to determine voice recognition support.
	 */
	private VoiceRecognitionCapabilityIF vrCapability;
	
	/**
	 * to display the capability for voice recognition support.
	 */
	private EditText vrSupportBox;

	/**
	 * invokes the start voice recognition activity.
	 */
	private Button startVrButton;
	
    /**
     * the request code for the startActivityForResultCall
     */
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

	/** 
     * Called when the activity is first created. 
     */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
    	
    	Log.d(LOG_TAG, "onCreate-enter");
    	
    	// Invoke super class behavior.
        super.onCreate(savedInstanceState);
        
        // Set the content view with the layout
        setContentView(R.layout.main);
        
        // Create the new voice capability object.
        vrCapability = 
        	new VoiceRecognitionCapability(this);
        
        // Create a reference to the voice recognition support box.
        vrSupportBox =
        	(EditText) findViewById(R.id.SupportsVrBox);
        
        // Determine voice recognition capability.
        final Boolean hasVrCapability =
        	vrCapability.hasVoiceRecognitionCapability();
        
        // Update the voice recognition support box.
        vrSupportBox.setText(hasVrCapability.toString());
        
        // Cache a local reference to the start voice recognition box.
        startVrButton =
        	(Button) findViewById(R.id.StartVrButton);
        
        startVrButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
			        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
			        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
	                                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
			        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech recognition demo");
			        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
				} catch (final Exception e) {
					Toast.makeText(getApplicationContext(), 
                                   e.getMessage(), 
                                   Toast.LENGTH_SHORT);
				}
			}
		});
        
    	Log.d(LOG_TAG, "onCreate-exit");        
    }

	/**
	 * {@inheritDoc}
	 * 
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, 
                                    int resultCode, 
                                    final Intent data) {
		
    	Log.d(LOG_TAG, "onActivityResult-enter");
		
		if (RecognizerIntent.RESULT_AUDIO_ERROR == resultCode) {
			Log.e(LOG_TAG, "Audio Error Encountered");
			startVrButton.setEnabled(false);
			return;
		}
		if (RecognizerIntent.RESULT_CLIENT_ERROR == resultCode) {
			Log.e(LOG_TAG, "Client Error Encountered");
			startVrButton.setEnabled(false);
			return;
		}
		if (RecognizerIntent.RESULT_NETWORK_ERROR == resultCode) {
			Log.e(LOG_TAG, "Network Error Encountered");
			startVrButton.setEnabled(false);
			return;
		}
		if (RecognizerIntent.RESULT_NO_MATCH == resultCode) {
			Log.e(LOG_TAG, "No Match Error Encountered");			
			startVrButton.setEnabled(false);
			return;
		}
		if (RecognizerIntent.RESULT_SERVER_ERROR == resultCode) {
			Log.e(LOG_TAG, "Server Error Encountered");		
			startVrButton.setEnabled(false);
			return;
		}
		
		Log.v(LOG_TAG, "[result code: " + resultCode + "]");			
		Log.v(LOG_TAG, "[request code: " + requestCode + "]");			

		if (resultCode == RESULT_OK && 
            VOICE_RECOGNITION_REQUEST_CODE == requestCode) {
			
			Log.v(LOG_TAG, "received match on request code");			

			Bundle extras = data.getExtras();
			
			ArrayList < String > strResultsList =
				extras.getStringArrayList(RecognizerIntent.EXTRA_RESULTS);
			
			final StringBuilder resultsString =
				new StringBuilder();
			
			Iterator < String > itr =
				strResultsList.iterator();
			
			while (itr.hasNext()) {
				resultsString.append(itr.next());
			}
			
			final EditText resultsBox =
				(EditText) findViewById(R.id.BoxVoiceRecognitionResults);
			
			resultsBox.setText(resultsString.toString());
		}
		
		// Invoke super class behavior.
		super.onActivityResult(requestCode, resultCode, data);
		
    	Log.d(LOG_TAG, "onActivityResult-exit");
	}
}

