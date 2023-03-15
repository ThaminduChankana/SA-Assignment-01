//IT20232368 - D.M.M.P Gunaratne

package com.sa.bookingservice.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Booking service started");
		BookingServicePublish bookingServicePublish = new BookingServicePublishImpl();
		serviceRegistration = bundleContext.registerService(BookingServicePublish.class.getName(), bookingServicePublish, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Booking service ended");
		serviceRegistration.unregister();
	}

}
