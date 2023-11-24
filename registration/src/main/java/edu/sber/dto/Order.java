package edu.sber.dto;

import java.util.Date;

public class Order {
	private Long userId;
	private Long realEstateId;
	private Date orderDateFrom;
	private Date orderDateTo;

	public Order(Long userId, Long realEstateId, Date orderDateFrom, Date orderDateTo) {
		this.userId = userId;
		this.realEstateId = realEstateId;
		this.orderDateFrom = orderDateFrom;
		this.orderDateTo = orderDateTo;
	}

	public Order() {

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(Long realEstateId) {
		this.realEstateId = realEstateId;
	}

	public Date getOrderDateFrom() {
		return orderDateFrom;
	}

	public void setOrderDateFrom(Date orderDateFrom) {
		this.orderDateFrom = orderDateFrom;
	}

	public Date getOrderDateTo() {
		return orderDateTo;
	}

	public void setOrderDateTo(Date orderDateTo) {
		this.orderDateTo = orderDateTo;
	}
}
