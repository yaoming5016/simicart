package com.ivica.magentoid.a.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class MagentoServiceManager {
	private IMagentoService magentoService;
	private Context context;
	private ServiceConnection connection;

	public interface MagentoServiceManagerCallBack {

		public void onServiceConnected();

		public void onServiceDisconnected();
	}

	public MagentoServiceManager(Context context) {
		this.context = context.getApplicationContext();
	}

	public enum MagentoServiceManagerControll {//
		CREATE, //
		DESTROY, //
		LOGIN, //
		LOGOUT, //
		userUrlAppCode,//
	};

	public void onCall(final MagentoServiceManagerControll serviceManagerControll, final MagentoServiceManagerCallBack callBack) {
		if (serviceManagerControll == MagentoServiceManagerControll.DESTROY) {
			if (magentoService != null) {
				context.unbindService(connection);
			}
		} else {
			if (connection == null) {
				connection = new ServiceConnection() {

					@Override
					public void onServiceConnected(ComponentName arg0, IBinder arg1) {
						magentoService = IMagentoService.Stub.asInterface(arg1);
						onCall(magentoService, serviceManagerControll, callBack);
					}

					@Override
					public void onServiceDisconnected(ComponentName arg0) {
						if (callBack != null)
							callBack.onServiceDisconnected();
					}
				};
			}

			if (magentoService == null) {
				context.bindService(new Intent("com.ivica.magentoid.a.service.MagentoService"), connection, Context.BIND_AUTO_CREATE);
			} else {
				onCall(magentoService, serviceManagerControll, callBack);
			}
		}
	}

	private void onCall(IMagentoService magentoService, MagentoServiceManagerControll serviceManagerControll, MagentoServiceManagerCallBack callBack) {
		if (magentoService == null) {
			if (callBack != null) {
				callBack.onServiceDisconnected();
			}
		} else {
			try {

			} catch (Exception exception) {

			}
		}
	}
}
