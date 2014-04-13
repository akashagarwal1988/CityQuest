package com.example.cityquest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FindFragmentCategories extends Fragment {
	
	ListView categoryList;
	FindFragmentSelectedListener fragCallback;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
    	final View categoriesView = inflater.inflate(R.layout.fragment_find, container, false);
    	
    	String[] categories = getResources().getStringArray(R.array.categories);
    	
    	categoryList = (ListView) categoriesView.findViewById(R.id.category_list_view);
    	
	       final ArrayList<String> list = new ArrayList<String>();
	       for (int i = 0; i < categories.length; ++i) {
	         list.add(categories[i]);
	       }
	       
	       final StableArrayAdapter adapter = new StableArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, list);
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
    
    private class StableArrayAdapter extends ArrayAdapter<String> {

 	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

 	    public StableArrayAdapter(Context context, int textViewResourceId,
 	        List<String> objects) {
 	      super(context, textViewResourceId, objects);
 	      for (int i = 0; i < objects.size(); ++i) {
 	        mIdMap.put(objects.get(i), i);
 	      }
 	    }
 	}
    
}