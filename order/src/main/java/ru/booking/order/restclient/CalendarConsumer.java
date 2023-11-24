package ru.booking.order.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.booking.order.api.model.Calendar;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class CalendarConsumer {

	@Value("${api.calendar.url}")
	private String calendarUrl;

	public void bookingDate(Long realEstateId, Date checkIn, Date checkOut) {
		RestTemplate restTemplate = new RestTemplate();

		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String checkInFormatted = dmyFormat.format(checkIn);
		String checkOutFormatted = dmyFormat.format(checkOut);

		HttpEntity<Calendar> request;
		request = new HttpEntity<>(new Calendar(realEstateId,checkInFormatted,checkOutFormatted));
		System.out.println(request);
		String productCreateResponse = restTemplate.postForObject(calendarUrl, request, String.class);


		System.out.println(productCreateResponse);
	}
}
