package com.ivica.magentoid.a.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.ivica.magentoid.a.service.IMagentoService.Stub;

//com.ivica.magentoid.a.service.MagentoService
public class MagentoService extends Service {
	public static void init(final Context context) {

			ServiceConnection connection = new ServiceConnection() {

				@Override
				public void onServiceConnected(ComponentName arg0, IBinder arg1) {
//					service = ISipService.Stub.asInterface(arg1);
				}

				@Override
				public void onServiceDisconnected(ComponentName arg0) {
				}
			};
			context.bindService(new Intent(
					"com.ivica.magentoid.a.service.MagentoService"),
					connection, Context.BIND_AUTO_CREATE);
	}

	public MagentoService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

	private IMagentoService.Stub binder = new Stub() {

		@Override
		public void userUrlAppCode(String url, String appCode)
				throws RemoteException {

		}

		@Override
		public void logout() throws RemoteException {

		}

		@Override
		public void login(String user, String password) throws RemoteException {

		}
	};

}
