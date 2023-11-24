package ru.booking.order.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.booking.order.api.model.Catalog;

@Service
public class CatalogConsumer {

	@Value("${api.catalog.url}")
	private String catalogUrl;

	public String getInfo(Long id) {
		RestTemplate restTemplate = new RestTemplate();


		HttpEntity<Catalog> request;
		request = new HttpEntity<>(new Catalog(id));

		Catalog catalog = restTemplate.postForObject(catalogUrl, request, Catalog.class);

		String response = "Город: " + catalog.getCity() + "; Адрес: " + catalog.getAddress() +
				"; Цена за одну ночь: " + catalog.getPriceForDay();

		return  response;
	}
}
