package edu.sber.controller;

import edu.sber.dto.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping(path = "/order")
public class CreateOrderController {

	@Value("${order.url}")
	private String orderUrl;

	@PostMapping("/create")
	public void createOrder(@RequestBody Order order){
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Order> request = new HttpEntity<>(order);
		String productCreateResponse = restTemplate.postForObject(orderUrl, request, String.class);

		System.out.println(productCreateResponse);
	}

}
