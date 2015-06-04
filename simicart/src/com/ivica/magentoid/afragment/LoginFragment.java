package com.ivica.magentoid.afragment;

import com.ivica.magentoid.MagentoManager;
import com.ivica.magentoid.R;
import com.ivica.magentoid.a.db.MagentoDBProvider;
import com.ivica.magentoid.a.db.MagentoSettingTable;
import com.ivica.magentoid.a.db.MagentoSettingTable.MagentoSettingTableName;
import com.vnp.core.common.CommonAndroid;
import com.vnp.core.common.LogUtils;

import android.database.Cursor;
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.login, null);
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		getView().findViewById(R.id.login_btn).setOnClickListener(this);

		MagentoSettingTable settingTable = new MagentoSettingTable(getActivity(), MagentoDBProvider.class);
		TextView login_url = CommonAndroid.getView(getView(), R.id.login_url);
		TextView login_appcode = CommonAndroid.getView(getView(), R.id.login_appcode);

		String url = settingTable.get(MagentoSettingTableName.MAGENTO_URL);
		String appcode = settingTable.get(MagentoSettingTableName.MAGENTO_APPCODE);

		if (CommonAndroid.isBlank(url)) {
			url = "http://magentoivica.loc";
		}
		if (CommonAndroid.isBlank(appcode)) {
			appcode = "defand1";
		}

		login_url.setText(url);
		login_appcode.setText(appcode);
	}

	@Override
	public void onClick(View v) {
		String login_url = ((TextView) getView().findViewById(R.id.login_url)).getText().toString().trim();
		String magento_appCode = ((TextView) getView().findViewById(R.id.login_appcode)).getText().toString().trim();

		MagentoSettingTable settingTable = new MagentoSettingTable(getActivity(), MagentoDBProvider.class);
		settingTable.set(MagentoSettingTableName.MAGENTO_URL, login_url);
		settingTable.set(MagentoSettingTableName.MAGENTO_APPCODE, magento_appCode);

		if (MagentoManager.getInstance().isConnected()) {

		}
	}
}
