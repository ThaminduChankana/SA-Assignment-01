package com.sa.pubdb.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DatabaseServiceActivator implements BundleActivator {

	private ServiceRegistration<?> serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("PUB Database Publisher service started");
		Database database = new DatabaseServicePublishImpl();
		serviceRegistration = bundleContext.registerService(Database.class.getName(), database, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("PUB Database Publisher service stopped");
		serviceRegistration.unregister();
	}

}
