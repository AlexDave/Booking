package ru.booking.order.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.booking.order.api.model.Notification;
import ru.booking.order.api.model.User;

@Service
public class UserConsumer {

	@Value("${api.user.url}")
	private String userUrl;

	public String getEmailUser(Long userId) {
		RestTemplate restTemplate = new RestTemplate();


		HttpEntity<User> request = new HttpEntity<>(new User(userId));
		User response = restTemplate.postForObject(userUrl, request, User.class);

		assert response != null;
		return response.getEmail();
	}
}
