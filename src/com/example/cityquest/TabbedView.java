package com.example.cityquest;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

	public class TabbedView extends FragmentActivity implements ActionBar.TabListener{
		
		
		private ViewPager viewPager;
	    private TabsPagerAdapter mAdapter;
	    private ActionBar actionBar;
	    // Tab titles
	    private String[] tabs = { "Find", "Share", "Friends" };
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tabbed_view);
	 
	        // Initilization
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
	
}