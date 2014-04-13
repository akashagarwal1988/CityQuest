package com.example.cityquest;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

	public class TabbedView extends FragmentActivity implements ActionBar.TabListener, FindFragmentCategories.FindFragmentSelectedListener{
		
		
		private ViewPager viewPager;
	    private TabsPagerAdapter mAdapter;
	    private ActionBar actionBar;
	    private Intent tempIntent;
	    // Tab titles
	    private String[] tabs = { "Find", "Share" };
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tabbed_view);
	 
	        // Initialization
	        viewPager = (ViewPager) findViewById(R.id.pager);
	        actionBar = getActionBar();
	        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
	 
	        viewPager.setAdapter(mAdapter);
	        actionBar.setHomeButtonEnabled(false);
	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
	 
	        // Adding Tabs
	        for (String tab_name : tabs) {
	            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));	
	        }
	        
	        
	        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
		                @Override
		                public void onPageSelected(int position) {
		                    // When swiping between pages, select the
		                    // corresponding tab.
		                    getActionBar().setSelectedNavigationItem(position);
		                    }
		                });
	        }
			    
		
		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			viewPager.setCurrentItem(tab.getPosition());
		}

		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void itemSelected() {

			tempIntent = new Intent(this, PlaceListActivity.class);
			startActivity(tempIntent);
			
		}
	
}