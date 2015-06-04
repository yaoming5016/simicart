package com.ivica.magentoid.a.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.acv.cheerz.db.SkypeTable;
import com.vnp.core.common.CommonAndroid;

public class MagentoSettingTable extends SkypeTable {

	public MagentoSettingTable(Context context, Class provider) {
		super(context, provider);

		addColumns("xname");
		addColumns("_value");
	}

	public enum MagentoSettingTableName {
		MAGENTO_URL, MAGENTO_APPCODE
	}

	public void set(MagentoSettingTableName name, String value) {
		String where = String.format("%s == '%s'", "xname", name.name());
		ContentValues values = new ContentValues();
		values.put("xname", name.name());
		values.put("_value", value);
		if (has(where)) {
			getContext().getContentResolver().update(getContentUri(), values, where, null);
		} else {
			getContext().getContentResolver().insert(getContentUri(), values);
		}
	}

	// TODO
	public String get(MagentoSettingTableName name) {
		String where = String.format("%s == '%s'", "xname", name.name());

		Cursor cursor = querry(where);

		String data = null;
		if (cursor != null) {
			if (cursor.moveToNext()) {
				data = CommonAndroid.getString(cursor, "_value");
			}
			cursor.close();
		}

		if (CommonAndroid.isBlank(data) && name == MagentoSettingTableName.MAGENTO_URL) {
			data = "http://magentoivica.loc";
		}

		if (CommonAndroid.isBlank(data) && name == MagentoSettingTableName.MAGENTO_APPCODE) {
			data = "defand1";
		}
		return data;
	}
}