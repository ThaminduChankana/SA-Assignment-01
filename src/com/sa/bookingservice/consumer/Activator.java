//IT20232368 - D.M.M.P Gunaratne

package com.sa.bookingservice.consumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.bookingservice.publisher.BookingServicePublish;

public class Activator implements BundleActivator {

	private ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting the Booking Consumer Service");
		serviceReference = bundleContext.getServiceReference(BookingServicePublish.class.getName());
		@SuppressWarnings("unchecked")
		BookingServicePublish bookingServicePublish = (BookingServicePublish) bundleContext.getService(serviceReference);
		displayBookings(bookingServicePublish);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stoping the Booking Consumer Service");
		bundleContext.ungetService(serviceReference);
	}

	public void displayBookings(BookingServicePublish bookingServicePublish) {

		String answer;
		int option;
		String nextoption = "y"; // setting the next option to yes

		Scanner sc = new Scanner(System.in); // input scanner

		System.out.println("\n");
		System.out.println("---------- Pub House : Booking ----------");
		System.out.println(" Enter (c) if you are a customer and (a) if you are an administrator: ");
		answer = sc.nextLine().trim();

		if (answer.equals("c") || answer.equals("C")) {
			// creating an customer class instance
			Customer customer = new Customer(bookingServicePublish);
			customer.book();

			while (nextoption.equals("y")) {
				System.out.println("\n\nDo you want to add another booking(y/n): ");
				nextoption = sc.nextLine().trim();

				if (nextoption.equals("y")) {
					customer.book();
				}
			}
			displayBookings(bookingServicePublish);

		} else if (answer.equals("a") || answer.equals("A")) {
			// creating an administrator class instance
			Administrator admin = new Administrator(bookingServicePublish);

			System.out.println("1  - Get all the bookings");
			System.out.println("2  - Get the booking by customer's name");
			System.out.println("3  - Delete a booking");

			System.out.print("\nChoose the option: ");
			option = Integer.parseInt(sc.nextLine().trim());

			switch (option) {
			case 1:
				admin.getallBookings();
				displayBookings(bookingServicePublish);
				break;
			case 2:
				admin.getBookingssByCustName();
				displayBookings(bookingServicePublish);
				break;
			case 3:
				admin.deleteBookings();
				displayBookings(bookingServicePublish);
				break;
			default:
				System.out.println("Wrong option");
				displayBookings(bookingServicePublish);
			}
		}

	}

}
