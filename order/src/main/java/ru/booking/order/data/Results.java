package ru.booking.order.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.UUID;

public class Results {
	private UUID id;
	private String city;
	private String address;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date checkIn;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date checkOut;

	private Float priceForDay;
	private String status;

	public Results(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Float getPriceForDay() {
		return priceForDay;
	}

	public void setPriceForDay(Float priceForDay) {
		this.priceForDay = priceForDay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Results(UUID id, String city, String address, Date checkIn, Date checkOut, Float priceForDay, String status) {
		this.id = id;
		this.city = city;
		this.address = address;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.priceForDay = priceForDay;
		this.status = status;
	}
}
