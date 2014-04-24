package com.example.cityquest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;

public class PlaceDetailActivity extends Activity {
	
	ListView reviewList;
	private RatingBar ratingBar;
	
	
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.find_place_detail);
	        
			
			// initializing and setting some random value for the ratingbar
			ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
			ratingBar.setRating((float) 3.5);
			
			
	        String[] reviews = getResources().getStringArray(R.array.reviews);
	    	
	        reviewList = (ListView) findViewById(R.id.review_list);
	        
	        
		    final ArrayList<String> list = new ArrayList<String>();
		    for (int i = 0; i < reviews.length; ++i) {
		    	list.add(reviews[i]);
		    }
		    
		    final StableArrayAdapter adapter = new StableArrayAdapter(this,android.R.layout.simple_list_item_1, list);
		    reviewList.setAdapter(adapter);
		}
		    	
		 
	    private class StableArrayAdapter extends ArrayAdapter<String> {

	 	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	 	    public StableArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
	 	      super(context, textViewResourceId, objects);
	 	      for (int i = 0; i < objects.size(); ++i) {
	 	        mIdMap.put(objects.get(i), i);
	 	      }
	 	    }
	 	}
	}
