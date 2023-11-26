package ru.booking.order.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.booking.order.api.model.Catalog;
import ru.booking.order.api.model.User;

@Service
public class CatalogConsumer {

	@Value("${api.catalog.url}")
	private String catalogUrl;

	public Catalog getInfo(Long realEstateId) {
		RestTemplate restTemplate = new RestTemplate();

		Catalog catalog = restTemplate.getForObject(catalogUrl, Catalog.class, realEstateId);

		return catalog;
	}
}
