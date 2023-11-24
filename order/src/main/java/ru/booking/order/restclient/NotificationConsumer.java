package ru.booking.order.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.booking.order.api.model.Notification;

@Service
public class NotificationConsumer {

	@Value("${api.notification.url}")
	private String notiticationUrl;

	public void createNotification(String recipient, String subject, String message ) {
		RestTemplate restTemplate = new RestTemplate();


		HttpEntity<Notification> request = new HttpEntity<>(new Notification(recipient, subject, message));
		String productCreateResponse = restTemplate.postForObject(notiticationUrl, request, String.class);



		System.out.println(productCreateResponse);
	}
}
