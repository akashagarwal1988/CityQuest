package com.example.cityquest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class FindFragmentCategories extends Fragment {
	
	ListView categoryList;
	FindFragmentSelectedListener fragCallback;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
    	final View categoriesView = inflater.inflate(R.layout.fragment_find, container, false);
    	
    	String[] categories = getResources().getStringArray(R.array.categories);
    	
    	// Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
 
        for(int i=0;i<categories.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", categories[i]);
            hm.put("flag", Integer.toString(R.drawable.ic_launcher) );
            aList.add(hm);
        }
    	
        // Keys used in Hashmap
        String[] from = { "flag","txt" };
 
        // Ids of views in listview_layout
        int[] to = { R.id.logo,R.id.label};
 
        // Instantiating an adapter to store each items
        // R.layout.fragment_find_list_item defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.simple_list_item, from, to);
 
        categoryList = ( ListView ) categoriesView.findViewById(R.id.category_list_view);
 
        // Setting the adapter to the listView
        categoryList.setAdapter(adapter);
    	
    	
	       // below function is for item click on the list
	    categoryList.setOnItemClickListener(new OnItemClickListener() {
	    	   @Override
	    	   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	    		   fragCallback.itemSelected();
	    	     }
	    	   });
	       
        return categoriesView;
    }
    
	public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
        	fragCallback = (FindFragmentSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnHeadlineSelectedListener");
        }
    }

	public interface FindFragmentSelectedListener {
    	public void itemSelected();
    }
}