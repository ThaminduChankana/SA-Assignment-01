//IT20232368 - D.M.M.P Gunaratne

package com.sa.bookingservice.consumer;

import com.sa.bookingservice.publisher.BookingServicePublish;

public class Customer {

	// booking service publisher object
	BookingServicePublish bookingServicePublish;

	// constructor
	public Customer(BookingServicePublish bookingServicePublish) {
		this.bookingServicePublish = bookingServicePublish;
	}

	// add booking method calling
	public void book() {
		bookingServicePublish.insertBooking();
	}

}
