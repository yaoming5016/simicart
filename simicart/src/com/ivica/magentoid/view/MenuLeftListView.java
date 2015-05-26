package com.ivica.magentoid.view;

import com.ivica.magentoid.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

//com.ivica.magentoid.view.MenuLeftListView
public class MenuLeftListView extends ListView {

	public MenuLeftListView(Context context) {
		super(context);
		init();
	}

	public MenuLeftListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public MenuLeftListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		setSelector(R.drawable.tranfer);
		setBackgroundResource(R.drawable.tranfer);
		setDividerHeight(0);

		String[] datas = new String[] {//
		getResources().getString(R.string.home),//
				getResources().getString(R.string.category),//
				getResources().getString(R.string.profile),//
				getResources().getString(R.string.addressbook),//
				getResources().getString(R.string.order_history),//
				getResources().getString(R.string.store_locator),//
				getResources().getString(R.string.abountus),//
				getResources().getString(R.string.privacy_policy) //
		};//

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
				android.R.layout.simple_list_item_1, datas);
		setAdapter(adapter);
	}

}
