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

import com.ivica.magentoid.a.service.MagentoServiceManager;
import com.ivica.magentoid.a.service.MagentoServiceManager.MagentoServiceManagerCallBack;
import com.ivica.magentoid.a.service.MagentoServiceManager.MagentoServiceManagerControll;

public class MagentoidActivity extends FragmentActivity {
	private MagentoServiceManager magentoServiceManager;
	private android.support.v4.widget.DrawerLayout drawerLayout;
	private ListView left_drawer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		magentoServiceManager = new MagentoServiceManager(this);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		left_drawer = (ListView) findViewById(R.id.left_drawer);
		setupMenuLeft();

		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// String message = "";
		// message = "Nothing";
		// if (MagentoManager.getInstance().getConfiguration().ds == null) {
		// // Toast.makeText(MagentoidActivity.this, "Nothing",
		// // Toast.LENGTH_LONG).show();
		// message = "Nothing";
		// } else if
		// (MagentoManager.getInstance().getConfiguration().ds.getGeneral() !=
		// null) {
		// message =
		// MagentoManager.getInstance().getConfiguration().ds.getGeneral().getCopyright();
		// }
		// LogUtils.e("testxx", message);
		// }
		// }).start();
		// if (mApp.getConfiguration().ds == null) {
		// Toast.makeText(this, "Nothing", Toast.LENGTH_LONG).show();
		// } else {
		// String message = "";
		// if (mApp.getConfiguration().ds.getGeneral() != null) {
		// message = mApp.getConfiguration().ds.getGeneral().getCopyright();
		// }
		//
		// Toast.makeText(this, message, Toast.LENGTH_LONG).show();
		// }

		magentoServiceManager.onCall(MagentoServiceManagerControll.CREATE, new MagentoServiceManagerCallBack() {

			@Override
			public void onServiceDisconnected() {

			}

			@Override
			public void onServiceConnected() {

			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		magentoServiceManager.onCall(MagentoServiceManagerControll.DESTROY, null);
	}

	private void setupMenuLeft() {
		left_drawer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			}
		});
	}
}