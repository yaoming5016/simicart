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
		this.context = context;
	}

	public void onCreate() {
		init(null);
	}

	public void onDestroy() {
		context.unbindService(connection);
	}

	public void init(final MagentoServiceManagerCallBack callBack) {
		if (connection == null) {
			connection = new ServiceConnection() {

				@Override
				public void onServiceConnected(ComponentName arg0, IBinder arg1) {
					magentoService = IMagentoService.Stub.asInterface(arg1);
					if (callBack != null)
						callBack.onServiceConnected();
				}

				@Override
				public void onServiceDisconnected(ComponentName arg0) {
					if (callBack != null)
						callBack.onServiceDisconnected();
				}
			};
		}
		context.bindService(new Intent(
				"com.ivica.magentoid.a.service.MagentoService"), connection,
				Context.BIND_AUTO_CREATE);
	}

}
