package com.example.cityquest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	// creating intent to call the tabbed view activity
	Intent tabbedIntent; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// starting the tabbed view activity and by passing the list view
		tabbedIntent = new Intent(this, TabbedView.class);
		startActivity(tabbedIntent);
	}
}

