package ru.booking.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.booking.order.data.Order;
import ru.booking.order.data.OrderRepository;

import java.util.List;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private RestTemplate restTemplate;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	//TODO FindByID

	public void addNewOrder(Order order) {

		orderRepository.save(order);
	}

	public void deleteOrder(Long orderId) {
		orderRepository.deleteById(orderId);
	}
}