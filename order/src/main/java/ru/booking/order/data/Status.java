package ru.booking.order.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name = "status")
public class Status {

	@Id
	private Integer id;
	private String description;

	//TODO инициализация статусов

}
