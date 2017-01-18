package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.app.ActionBar.*;
import java.util.function.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.addTab(bar.newTab().setText("List").setTabListener(new ReusableTabListener(new Producer<Fragment>() {
		  public ListFragment produce() {
			return new SimpleListFragment();
		  }
		}, "list", getFragmentManager())));
		
		bar.addTab(bar.newTab().setText("Custom").setTabListener(new ReusableTabListener(new Producer<Fragment>() {
		  public Fragment produce() {
			return new CustomListFragment();
		  }
		}, "custom", getFragmentManager())));
		
		bar.addTab(bar.newTab().setText("Grid").setTabListener(new ReusableTabListener(new Producer<Fragment>() {
		  public Fragment produce() {
			return new SimpleGridFragment();
		  }
		}, "grid", getFragmentManager())));
		
		bar.addTab(bar.newTab().setText("Gallery").setTabListener(new ReusableTabListener(new Producer<Fragment>() {
		  public Fragment produce() {
			return new SimpleGalleryFragment();
		  }
		}, "gallery", getFragmentManager())));
    }
	
  static class ReusableTabListener implements ActionBar.TabListener {
	Producer<Fragment> constructor;
	String nameForStack;
	FragmentManager manager;
	
	ReusableTabListener(Producer<Fragment> constructor, String nameForStack, FragmentManager manager) {
	  this.constructor = constructor;
	  this.nameForStack = nameForStack;
	  this.manager = manager;
	}
	
	@Override
	public void onTabSelected(ActionBar.Tab p1, FragmentTransaction p2) {
	  Fragment frag = constructor.produce();
	  FragmentTransaction transaction = manager.beginTransaction();
	  transaction.replace(R.id.layout_container, frag);
	  transaction.addToBackStack(nameForStack);
	  transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	  transaction.commit();
	}

	@Override
	public void onTabUnselected(ActionBar.Tab p1, FragmentTransaction p2) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab p1, FragmentTransaction p2) {
	  onTabSelected(p1, p2);
	}
  }
  
  interface Producer<T> {
	T produce();
  }
}
