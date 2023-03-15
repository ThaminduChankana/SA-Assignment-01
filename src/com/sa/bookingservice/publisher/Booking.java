//IT20232368 - D.M.M.P Gunaratne

package com.sa.bookingservice.publisher;

//Booking model class
public class Booking {

	private int bookingID;
	private String customerName;
	private int noOfguests;
	private String phoneNumber;
	private String bookingDate;

	public Booking() {
		super();
	}

	public Booking(int bookingID, String customerName, int noOfguests, String phoneNumber) {
		super();
		this.bookingID = bookingID;
		this.customerName = customerName;
		this.noOfguests = noOfguests;
		this.phoneNumber = phoneNumber;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNoOfguests() {
		return noOfguests;
	}

	public void setNoOfguests(int noOfguests) {
		this.noOfguests = noOfguests;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

}
