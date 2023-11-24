package ru.booking.order.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.booking.order.api.model.Notification;
import ru.booking.order.api.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserConsumer {

	@Value("${api.user.url}")
	private String userUrl;

	public String getEmailUser(Long userId) {
		RestTemplate restTemplate = new RestTemplate();

		User response = restTemplate.getForObject(userUrl, User.class, userId);

		System.out.println(response);

		assert response != null;
		return response.email();
	}
}
