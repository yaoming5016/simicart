package com.ivica.magentoid.a.db;

import com.acv.cheerz.db.DBDatabaseHelper;
import com.acv.cheerz.db.DBProvider;
//com.ivica.magentoid.a.db.MagentoDBProvider
public class MagentoDBProvider extends DBProvider {

	public MagentoDBProvider() {
		super();
	}

	@Override
	public void addTable(DBDatabaseHelper arg0) {
		arg0.addTable(new MagentoAccountTable(getContext(), getClass()));
		arg0.addTable(new MagentoSettingTable(getContext(), getClass()));
	}

	@Override
	public int getVersionDB() {
		return 1;
	}

}
