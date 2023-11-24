package ru.booking.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.booking.order.data.Order;
import ru.booking.order.restclient.CalendarConsumer;
import ru.booking.order.restclient.CatalogConsumer;
import ru.booking.order.restclient.NotificationConsumer;
import ru.booking.order.restclient.UserConsumer;
import ru.booking.order.service.OrderService;


import java.util.List;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

	private final OrderService orderService;
	private final NotificationConsumer notificationConsumer;
	private final CalendarConsumer calendarConsumer;
	private final UserConsumer userConsumer;
	private final CatalogConsumer catalogConsumer;

	@Autowired
	public OrderController(OrderService orderService, NotificationConsumer notificationConsumer, CalendarConsumer calendarConsumer, UserConsumer userConsumer, CatalogConsumer catalogConsumer) {
		this.orderService = orderService;
		this.notificationConsumer = notificationConsumer;
		this.calendarConsumer = calendarConsumer;
		this.userConsumer = userConsumer;
		this.catalogConsumer = catalogConsumer;
	}


	@GetMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}

	@PostMapping
	public void addNewOrder(@RequestBody Order order) {
		orderService.addNewOrder(order);
		calendarConsumer.bookingDate(order.getRealEstateId(), order.getOrderDateTo(), order.getOrderDateTo());

		String userEmail = userConsumer.getEmailUser(order.getUserId());

		String subject = "Бронирование " + order.getId();

		String message = catalogConsumer.getInfo(order.getRealEstateId());

		notificationConsumer.createNotification(userEmail,subject,message);
	}

	@DeleteMapping(path = "{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
	}

}