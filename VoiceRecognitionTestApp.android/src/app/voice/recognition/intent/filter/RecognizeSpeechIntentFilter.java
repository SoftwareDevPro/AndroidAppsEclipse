package app.voice.recognition.intent.filter;

import android.content.IntentFilter;
import android.speech.RecognizerIntent;

/**
 * RecognizeSpeechIntentFilter is an {@link IntentFilter} which
 * uses the Recognize Speech action from {@link RecognizerIntent}
 * as the concrete action.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RecognizeSpeechIntentFilter 
extends IntentFilter {

	/**
	 * Constructs the {@link IntentFilter} using 
	 * {@link RecognizerIntent#ACTION_RECOGNIZE_SPEECH} as the action.
	 */
	public RecognizeSpeechIntentFilter() {
		super(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	}
}
