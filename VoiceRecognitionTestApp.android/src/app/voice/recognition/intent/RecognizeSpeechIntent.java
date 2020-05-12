package app.voice.recognition.intent;

import android.content.Intent;
import android.speech.RecognizerIntent;

/**
 * RecognizeSpeechIntentFilter is an {@link Intent} which
 * uses the Recognize Speech action from {@link RecognizerIntent}
 * as the concrete action.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RecognizeSpeechIntent 
extends Intent {

	/**
	 * Constructs the {@link Intent} using 
	 * {@link RecognizerIntent#ACTION_RECOGNIZE_SPEECH} as the action..
	 */
	public RecognizeSpeechIntent() {
		super(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	}
}
