package ru.booking.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.booking.order.api.model.Catalog;
import ru.booking.order.data.Order;
import ru.booking.order.data.Results;
import ru.booking.order.restclient.CalendarConsumer;
import ru.booking.order.restclient.CatalogConsumer;
import ru.booking.order.restclient.NotificationConsumer;
import ru.booking.order.restclient.UserConsumer;
import ru.booking.order.service.OrderService;


import java.util.ArrayList;
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


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/getInfoByUser", params = {"id"})
	public List<Results> getInfo(@RequestParam(value = "id") Long id) {

		List<Order> orders = orderService.findByUser(id);


		List<Results> results = new ArrayList<>();

		orders.forEach(order -> {
			Catalog catalog = catalogConsumer.getInfo(order.getRealEstateId());

			String status = order.getStatusId() == 1 ? "Забронировано" : "Отклонено";

			Results result = new Results(order.getId(),
					catalog.city(),catalog.address(),order.getOrderDateFrom(),
					order.getOrderDateTo(),catalog.priceForDay(),status);

			results.add(result);
		});



		return results;

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping
	public Order addNewOrder(@RequestBody Order order) {
		Catalog catalog = catalogConsumer.getInfo(order.getRealEstateId());

		order.setOrderCategory("Booking");
		order.setStatusId(1);
		order.setOrderPrice(catalog.priceForDay());
		orderService.addNewOrder(order);

		calendarConsumer.bookingDate(order.getRealEstateId(), order.getOrderDateFrom(), order.getOrderDateTo());

		String userEmail = userConsumer.getEmailUser(order.getUserId());

		String subject = "Бронирование " + order.getId();


		String message = "Город: " + catalog.city() + "; Адрес: " + catalog.address() +
				"; Цена за одну ночь: " + catalog.priceForDay() + "; Дата заезда: "
				+ order.getOrderDateFrom() + "; Дата выезда: " + order.getOrderDateTo();

		notificationConsumer.createNotification(userEmail,subject,message);

		return order;
	}

	@DeleteMapping(path = "{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
	}

}