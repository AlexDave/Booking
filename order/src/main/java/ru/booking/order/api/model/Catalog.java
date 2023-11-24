package ru.booking.order.api.model;

public class Catalog {
	private Long id;
	private String address;
	private String city;
	private Long priceForDay;

	public Catalog(Long id) {
		this.id = id;
	}

	public Catalog(Long id, String address, String city, Long priceForDay) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.priceForDay = priceForDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPriceForDay() {
		return priceForDay;
	}

	public void setPriceForDay(Long priceForDay) {
		this.priceForDay = priceForDay;
	}
}
