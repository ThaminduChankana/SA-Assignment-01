//IT20232368 - D.M.M.P Gunaratne

package com.sa.bookingservice.publisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookingServicePublishImpl implements BookingServicePublish {

	// input scanner
	Scanner input = new Scanner(System.in);

	// required object t create the database connection
	private Connection conn = null;
	private Statement state = null;
	private ResultSet result;

	// database instance
	// private Database database;

	public BookingServicePublishImpl() {
		super();
	}

	// method to add a new booking to the system
	@Override
	public void insertBooking() {

		// Booking class instance
		Booking booking = new Booking();

		System.out.println("----------	Pub House : Booking	----------");

		System.out.println("Enter Customer's Name : ");
		booking.setCustomerName(input.nextLine().trim());

		System.out.println("Enter Number of Guests : ");
		booking.setNoOfguests(Integer.parseInt(input.nextLine().trim()));

		System.out.println("Enter Customer's Phone Number : ");
		booking.setPhoneNumber(input.nextLine().trim());

		System.out.println("Enter Booking Date ( dd/mm/yyyy ) : ");
		booking.setBookingDate(input.nextLine().trim());

		String sqlQueryForBooking = "INSERT INTO bookings(customername, noofguest, customerphone,date) " + "VALUES('"
				+ booking.getCustomerName() + "', '" + booking.getNoOfguests() + "', " + "'" + booking.getPhoneNumber()
				+ "', '" + booking.getBookingDate() + "')";

		try {
			state = conn.createStatement();
			state.executeUpdate(sqlQueryForBooking);
			System.out.println("Booking is successfully added!!!");
		} catch (SQLException e) {
			System.out.println("Error with adding the booking..");
			System.out.println(e.getMessage());
		}
	}

	// method to get all the bookings
	@Override
	public void getallBookings() {

		// Booking class instance
		Booking booking = new Booking();

		String sqlBooking = "SELECT * FROM bookings";

		try {
			state = conn.createStatement();
			result = state.executeQuery(sqlBooking);

			System.out.printf("\n%20s %20s %20s %20s %20s %20s\n", "Booking ID", "Customer Name", "Number of guests",
					"Phone number", "Date of booking");
			System.out.printf("\n");

			while (result.next()) {
				System.out.printf("%20d %20s %20d %20s %20s %20d\n", result.getInt("id"),
						result.getString("customername"), result.getInt("noofguest"), result.getString("customerphone"),
						result.getString("date"));
			}

		} catch (SQLException e) {
			System.out.println("Something is wrong, cannot get the booking details!!!");
			System.out.println(e.getMessage());
		}
	}

	// method to get a booking by the customer's name
	@Override
	public void getBookingByCustomerName() {

		String customerName;

		System.out.print("Enter customer's name : ");
		customerName = input.nextLine().trim(); // get the customer name by keyboard

		String sqlQueryBooking = "SELECT * FROM bookings WHERE customername = '" + customerName + "'";

		try {
			state = conn.createStatement();
			result = state.executeQuery(sqlQueryBooking);

			System.out.printf("\n%20s %20s %20s %20s %20s %20s\n", "Booking ID", "Customer Name", "Number of guests",
					"Phone number", "Date of booking");
			System.out.printf("\n");

			while (result.next()) {
				System.out.printf("%20d %20s %20d %20s %20s %20d\n", result.getInt("id"),
						result.getString("customername"), result.getInt("noofguest"), result.getString("customerphone"),
						result.getString("date"));
			}

		} catch (SQLException e) {
			System.out.println("Error with getting the booking details!!!");
			System.out.println(e.getMessage());
		}
	}

	// method to delete a booking
	@Override
	public void deleteBooking() {

		String customerName;
		String bookingdate;

		System.out.print("Enter customer's name : ");
		customerName = input.nextLine().trim(); // get the customer name by keyboard

		System.out.print("Enter the booked date ( dd/mm/yyyy ): ");
		bookingdate = input.nextLine().trim(); // get the date by keyboard

		try {

			state = conn.createStatement();
			state.executeUpdate("Deleting the booking for the customer='" + customerName + "' for the booking date='"
					+ bookingdate + "'");
			System.out.println("Successfully deleted the booking\n");

		} catch (SQLException e) {
			System.out.println("Error with deleting the booking!!!");
			System.out.println(e.getMessage());
		}
	}
}
