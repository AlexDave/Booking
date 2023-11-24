package ru.booking.order.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.booking.order.api.model.Calendar;

import java.util.Date;

@Service
public class CalendarConsumer {

	@Value("${api.calendar.url}")
	private String calendarUrl;

	public void bookingDate(Long realEstateId, Date checkIn, Date checkOut) {
		RestTemplate restTemplate = new RestTemplate();


		HttpEntity<Calendar> request;
		request = new HttpEntity<>(new Calendar(realEstateId, checkIn, checkOut));
		String productCreateResponse = restTemplate.postForObject(calendarUrl, request, String.class);


		System.out.println(productCreateResponse);
	}
}
