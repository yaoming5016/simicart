package com.ivica.magentoid.afragment;

import com.ivica.magentoid.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoginFragment extends Fragment implements OnClickListener {

	public LoginFragment() {
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.login, null);
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		getView().findViewById(R.id.login_btn).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		String url = ((TextView) getView().findViewById(R.id.login_url))
				.getText().toString();
		String magento_appCode = ((TextView) getView().findViewById(
				R.id.login_id)).getText().toString();
		
		
		
	}
}
