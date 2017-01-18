package com.mycompany.myapp;

import android.app.*;
import android.widget.*;
import android.os.*;
import android.content.res.*;
import android.view.*;
import android.widget.AdapterView.*;

public class SimpleGalleryFragment extends Fragment {
  Gallery gallery;
  String[] pies;

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	Resources resources = getResources();
	pies = resources.getStringArray(R.array.pie_array);
	gallery.setAdapter(new ArrayAdapter<String>(getActivity(),
											 android.R.layout.simple_list_item_1, pies));
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	gallery = (Gallery) inflater.inflate(R.layout.gallery_fragment, container, false);
	gallery.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
		  Toast.makeText(getActivity().getApplicationContext(), pies[p3], Toast.LENGTH_SHORT).show();
		}
	  });
	return gallery;
  }
}
