package com.ivica.magentoid.a.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.ivica.magentoid.a.service.IMagentoService.Stub;

//com.ivica.magentoid.a.service.MagentoService
public class MagentoService extends Service {

	public MagentoService() {
		super();
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
