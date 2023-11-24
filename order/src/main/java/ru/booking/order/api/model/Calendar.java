package ru.booking.order.api.model;

import java.util.Date;

public class Calendar {

	private Long id;
	private Date checkIn;
	private Date checkOut;

	public Calendar(Long id, Date checkIn, Date checkOut) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
}
