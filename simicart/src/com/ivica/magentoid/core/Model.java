/*
 * Magentoid2
 * 
 * @author	Ivica Tadić <ivica.tadic@ymail.com>
 */
package com.ivica.magentoid.core;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.content.Context;

public class Model {
	private Context context;

	public Context getContext() {
		return context;
	}

	public Model(Context context) {
		this.context = context;
	}

//	protected static final Client client = MagentoidApp.client;
	protected static final Serializer serializer = new Persister();

}
