/*
 * Magentoid2
 * 
 * @author	Ivica Tadić <ivica.tadic@ymail.com>
 */
package com.ivica.magentoid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ivica.magentoid.core.MagentoidApp;

public class MagentoidActivity extends FragmentActivity {
	private android.support.v4.widget.DrawerLayout drawerLayout;
	private ListView left_drawer;
	private MagentoidApp mApp = MagentoidApp.getInstance();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		left_drawer = (ListView) findViewById(R.id.left_drawer);
		setupMenuLeft();
		if (mApp.getConfiguration().ds == null) {
			Toast.makeText(this, "Nothing", Toast.LENGTH_LONG).show();
		} else {
			String message = "";
			if (mApp.getConfiguration().ds.getGeneral() != null) {
				message = mApp.getConfiguration().ds.getGeneral()
						.getCopyright();
			}

			Toast.makeText(this, message, Toast.LENGTH_LONG).show();
		}
	}

	private void setupMenuLeft() {
		String[] datas = new String[] {//
		getResources().getString(R.string.home),//
				getResources().getString(R.string.category),//
				getResources().getString(R.string.profile),//
				getResources().getString(R.string.addressbook),//
				getResources().getString(R.string.order_history),//
				getResources().getString(R.string.store_locator),//
				getResources().getString(R.string.abountus),//
				getResources().getString(R.string.privacy_policy) //
		};//

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, datas);
		left_drawer.setAdapter(adapter);
		left_drawer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}

		});
	}
}