/*
 * Magentoid2
 * 
 * @author	Ivica Tadić <ivica.tadic@ymail.com>
 */
package com.ivica.magentoid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.ivica.magentoid.core.MagentoidApp;

public class MagentoidActivity extends Activity {

	MagentoidApp mApp = MagentoidApp.getInstance();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

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

}