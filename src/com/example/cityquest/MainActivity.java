package com.example.cityquest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends Activity {

	// creating intent to call the tabbed view activity
	Intent tabbedIntent; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// starting the tabbed view activity and by passing the list view
		tabbedIntent = new Intent(this, TabbedView.class);
		startActivity(tabbedIntent);
		
		//logic diverted to the tabbed view activity
		final ListView listview = (ListView) findViewById(R.id.listview);
	    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
	        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
	        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
	        "Android", "iPhone", "WindowsMobile" 
	        };

	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
	    final StableArrayAdapter adapter = new StableArrayAdapter(this,
	        android.R.layout.simple_list_item_1, list);
	    listview.setAdapter(adapter);
	    
	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	        @Override
	        public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
	          final String item = (String) parent.getItemAtPosition(position);
	          view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
	                @Override
	                public void run() {
	                  list.remove(item);
	                  adapter.notifyDataSetChanged();
	                  view.setAlpha(1);
	                  }
	              });
	        }
	      });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.menu.options_menu, menu);
		    
		    SearchManager searchManager =
		            (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		     SearchView searchView =
		             (SearchView) menu.findItem(R.id.search).getActionView();
		     searchView.setSearchableInfo(
		             searchManager.getSearchableInfo(getComponentName()));
		    return true;
	}
	
	
	private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }
}

// check
