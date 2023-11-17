package ru.booking.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.booking.order.data.Order;
import ru.booking.order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	//TODO Доделать посты
	@PostMapping
	public void addNewOrder(@RequestBody Order order) {
		orderService.addNewOrder(order);
	}

	@DeleteMapping(path = "{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
	}

}