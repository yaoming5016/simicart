package com.ivica.magentoid;

import android.app.Application;

import com.ivica.magentoid.a.db.MagentoDBProvider;
import com.ivica.magentoid.a.db.MagentoSettingTable;
import com.ivica.magentoid.a.db.MagentoSettingTable.MagentoSettingTableName;
import com.ivica.magentoid.configuration.Configuration;
import com.ivica.magentoid.core.Client;
import com.ivica.magentoid.customer.Customer;
import com.vnp.core.common.CommonAndroid;

public class MagentoManager {
	private Application application;
	private static MagentoManager instance = new MagentoManager();

	public static MagentoManager getInstance() {
		return instance;
	}

	private MagentoManager() {
	}

	public void init(Application application) {
		this.application = application;

		client = new Client(application);
	}

	private Client client;
	private Configuration configuration;
	private Customer customer;

	public Client getClient() {
		return client;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public Configuration getConfiguration() {
		if (configuration == null) {
			configuration = new Configuration(application);
			configuration.load(320, 480);
		}
		return configuration;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		if (customer == null) {
			customer = new Customer(application);
		}
		return customer;
	}

	public String MAGENTO_URL() {
		return new MagentoSettingTable(application, MagentoDBProvider.class).get(MagentoSettingTableName.MAGENTO_URL);
	}

	public String DATA_DATA_COM_IVICA_MAGENTOID() {
		// TODO
		// return "/data/data/com.ivica.magentoid/";

		return String.format("/data/data/%s/", application.getPackageName());
	}

	// = "http://magentoivica.loc";
	public String MAGENTO_APP_CODE() {
		return new MagentoSettingTable(application, MagentoDBProvider.class).get(MagentoSettingTableName.MAGENTO_APPCODE);
	}// = "defand1";

	public boolean isConnected() {

		String copyRight = getCopyRight();
		// if (MagentoManager.getInstance().getConfiguration().ds == null) {
		// } else if
		// (MagentoManager.getInstance().getConfiguration().ds.getGeneral() !=
		// null) {
		// copyRight =
		// MagentoManager.getInstance().getConfiguration().ds.getGeneral().getCopyright();
		// }

		return !CommonAndroid.isBlank(copyRight);
	}

	public String getCopyRight() {
		String copyRight = "";
		if (MagentoManager.getInstance().getConfiguration().ds == null) {
		} else if (MagentoManager.getInstance().getConfiguration().ds.getGeneral() != null) {
			copyRight = MagentoManager.getInstance().getConfiguration().ds.getGeneral().getCopyright();
		}

		return copyRight;
	}
}
