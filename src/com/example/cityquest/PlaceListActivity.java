package com.example.cityquest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PlaceListActivity extends Activity  {
	
	ListView placeList;
	private Intent tempIntent;
	
	protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_place_list);
        
        String[] places = getResources().getStringArray(R.array.places);
    	
    	placeList = (ListView) findViewById(R.id.find_place_list);
    	
	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < places.length; ++i) {
	    	list.add(places[i]);
	    }
	    
    	// Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
 
        for(int i=0;i<places.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", places[i]);
            hm.put("flag", Integer.toString(R.drawable.ic_launcher) );
            aList.add(hm);
        }
    	
        // Keys used in Hashmap
        String[] from = { "flag","txt" };
 
        // Ids of views in listview_layout
        int[] to = { R.id.logo,R.id.label};
 
        // Instantiating an adapter to store each items
        // R.layout.fragment_find_list_item defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.simple_list_item, from, to);
	    
	    placeList.setAdapter(adapter);
	    
	    placeList.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        	
	            // When clicked, launch the placedetail activity
	        	tempIntent = new Intent(view.getContext(), PlaceDetailActivity.class);
	        	startActivity(tempIntent);
	        	}
	        });
	    }
}
