package com.ivica.magentoid.afragment;

import com.ivica.magentoid.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

	public HomeFragment() {
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home, null);
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();

	
	}
}
