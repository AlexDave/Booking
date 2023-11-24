package ru.booking.order.data;


import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private Long userId;
	private Long realEstateId;
	private String orderCategory;
	private Float orderPrice;
	private Date orderDateFrom;
	private Date orderDateTo;
	private Integer statusId;



	public Order(UUID id,Long userId, Long realEstateId, String orderCategory, String orderName, Float orderPrice,
				 Date dateFrom, Date dateTo, Integer statusId) {
		this.id = id;
		this.orderCategory = orderCategory;
		this.userId = userId;
		this.realEstateId = realEstateId;
		this.orderPrice = orderPrice;
		this.orderDateFrom = dateFrom;
		this.orderDateTo = dateTo;
		this.statusId = statusId;
	}

	public Order(Long userId, Long realEstateId, Date orderDateFrom, Date orderDateTo) {
		this.userId = userId;
		this.realEstateId = realEstateId;
		this.orderDateFrom = orderDateFrom;
		this.orderDateTo = orderDateTo;
		this.statusId = 1;
		this.orderCategory = "Booking";
	}

	public Order() {

	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getOrderCategory() {
		return orderCategory;
	}

	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}

	public Float getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
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

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}


	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", userId=" + userId +
				", realEstateId=" + realEstateId +
				", orderCategory='" + orderCategory + '\'' +
				", orderPrice=" + orderPrice +
				", orderDateFrom=" + orderDateFrom +
				", orderDateTo=" + orderDateTo +
				", statusId=" + statusId +
				'}';
	}
}