//IT20232368 - D.M.M.P Gunaratne

package com.sa.bookingservice.consumer;

import com.sa.bookingservice.publisher.BookingServicePublish;

public class Administrator {

	// booking service publisher object
	BookingServicePublish bookingServicePublish;

	// constructor
	public Administrator(BookingServicePublish bookingServicePublish) {
		this.bookingServicePublish = bookingServicePublish;
	}

	// get all bookings method calling
	public void getallBookings() {
		bookingServicePublish.getallBookings();
	}

	// get booking by customer name method calling
	public void getBookingssByCustName() {
		bookingServicePublish.getBookingByCustomerName();
	}

	// delete booking method calling
	public void deleteBookings() {
		bookingServicePublish.deleteBooking();
	}

}
