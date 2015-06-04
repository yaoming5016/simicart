/*
 * Magentoid2
 * 
 * @author	Ivica Tadić <ivica.tadic@ymail.com>
 */
package com.ivica.magentoid.core;

import android.app.Application;

import com.ivica.magentoid.MagentoManager;

public class MagentoidApp extends Application {
//	public static MagentoidApp mApp;

//	public static Client client;
//
//	private Configuration configuration;
//	private Customer customer;

	@Override
	public void onCreate() {
		super.onCreate();
		MagentoManager.getInstance().init(this);
		
//		if (MagentoidApp.mApp == null) {
//			MagentoidApp.mApp = this;
//		}

		//client = new Client();
	}

//	public static MagentoidApp getInstance() {
//		return mApp;
//	}

//	public boolean isOnline() {
//		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//		NetworkInfo ni = cm.getActiveNetworkInfo();
//		if (ni != null && ni.isAvailable() && ni.isConnected()) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	/*
	 * Public getters and setters
	 */
//	public void setConfiguration(Configuration configuration) {
//		this.configuration = configuration;
//	}
//
//	public Configuration getConfiguration() {
//		if (configuration == null) {
//			configuration = new Configuration(this);
//			configuration.load(320, 480);
//		}
//
//		return configuration;
//	}

//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public Customer getCustomer() {
//		if (customer == null) {
//			customer = new Customer(this);
//		}
//		return customer;
//	}

}
