package com.example.cityquest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlaceListActivity extends Activity  {
	
	ListView placeList;
	private Intent tempIntent;
	
	protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_place_list_layout);
        
        String[] places = getResources().getStringArray(R.array.places);
    	
    	placeList = (ListView) findViewById(R.id.find_place_list);
    	
	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < places.length; ++i) {
	    	list.add(places[i]);
	    }
	    
	    final StableArrayAdapter adapter = new StableArrayAdapter(this,android.R.layout.simple_list_item_1, list);
	    placeList.setAdapter(adapter);
	    
	    placeList.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        	
	            // When clicked, launch the placedetail activity
	        	tempIntent = new Intent(view.getContext(), PlaceDetailActivity.class);
	        	startActivity(tempIntent);
	        	}
	        });
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
