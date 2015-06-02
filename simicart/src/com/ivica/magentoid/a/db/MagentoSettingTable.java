package com.ivica.magentoid.a.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.acv.cheerz.db.SkypeTable;
import com.vnp.core.common.CommonAndroid;

public class MagentoSettingTable extends SkypeTable {

	public MagentoSettingTable(Context context, Class provider) {
		super(context, provider);

		addColumns("_name");
		addColumns("_value");
	}

	public enum MagentoSettingTableName {
		MAGENTO_URL, MAGENTO_APPCODE
	}

	public void set(MagentoSettingTableName name, String value) {
		String where = String.format("%s == '%s'", "_name", name.name());
		ContentValues values = new ContentValues();
		values.put("_name", name.name());
		values.put("_value", value);
		if (has(where)) {
			getContext().getContentResolver().update(getContentUri(), values, where, null);
		} else {
			getContext().getContentResolver().insert(getContentUri(), values);
		}
	}

	public String get(MagentoSettingTableName name) {
		String where = String.format("%s == '%s'", "_name", name.name());

		Cursor cursor = querry(where);

		String data = null;
		if (cursor != null) {
			if (cursor.moveToNext()) {
				data = CommonAndroid.getString(cursor, "_value");
			}
			cursor.close();
		}
		return data;
	}
}