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
import android.widget.ListView;
import android.widget.Toast;

import com.ivica.magentoid.a.service.MagentoServiceManager;
import com.ivica.magentoid.afragment.LoginFragment;
import com.ivica.magentoid.core.MagentoidApp;

public class MagentoidActivity extends FragmentActivity {
	private MagentoServiceManager magentoServiceManager;
	private android.support.v4.widget.DrawerLayout drawerLayout;
	private ListView left_drawer;
	private MagentoidApp mApp = MagentoidApp.getInstance();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		magentoServiceManager = new MagentoServiceManager(this);
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
		left_drawer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}

		});
	}
}