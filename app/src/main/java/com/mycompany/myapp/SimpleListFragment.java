package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.res.*;

public class SimpleListFragment extends ListFragment {
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
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);
		Toast.makeText(getActivity().getApplicationContext(),
			pies[position], Toast.LENGTH_SHORT).show();
	}
}
