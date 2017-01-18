package com.mycompany.myapp;
import android.app.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class CustomListFragment extends ListFragment {
  String[] pies;
  
  @Override
  public void onActivityCreated(Bundle savedInstanceState)
  {
	super.onActivityCreated(savedInstanceState);
	Resources resources = getResources();
	pies = resources.getStringArray(R.array.pie_array);
	setListAdapter(new ArrayAdapter<String>(getActivity(),
											android.R.layout.simple_list_item_1, pies));
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	return inflater.inflate(R.layout.custom_list_fragment, container, false);
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
	Toast.makeText(getActivity().getApplicationContext(), pies[position], Toast.LENGTH_SHORT).show();
  }
  
  
}

/*
	String[] mPies;

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Resources resources = getResources();
		mPies = resources.getStringArray(R.array.pie_array);
		setListAdapter(new ArrayAdapter<String>(this.getActivity(),
				android.R.layout.simple_list_item_1, mPies));
	}
	
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(this.getActivity().getApplicationContext(), mPies[position], Toast.LENGTH_SHORT).show();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v   = inflater.inflate(R.layout.custom_list_fragment, container, false);
		return v;
	}
	
	
} */
