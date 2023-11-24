package ru.booking.order.api.model;

import java.util.Date;

public class Calendar {

	private Long id;
	private String checkin;
	private String checkout;

	@Override
	public String toString() {
		return "Calendar{" +
				"id=" + id +
				", checkin=" + checkin +
				", checkout=" + checkout +
				'}';
	}

	public Calendar(Long id, String checkin, String checkout) {
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
}
