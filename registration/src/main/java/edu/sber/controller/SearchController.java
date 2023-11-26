package edu.sber.controller;

import edu.sber.dto.ApartmentWithFreeDatesDto;
import edu.sber.dto.CatalogDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/catalog")
public class SearchController {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Value("${catalog.url}")
    private String catalogUrl;

    @GetMapping()
    public CatalogDto getCatalog(RestTemplate restTemplate) {

        return restTemplate.getForObject(
                catalogUrl, CatalogDto.class);

    }

    @GetMapping(path = "/searchByCity", params = {"city"})
    public CatalogDto getApartmentsByCity(RestTemplate restTemplate, @RequestParam(value = "city") String city) {

        return restTemplate.getForObject(
                catalogUrl + "?city=" + city, CatalogDto.class);

    }

    @GetMapping(path = "/getFreeDatesForApartment", params = {"id"})
    public ApartmentWithFreeDatesDto getFreeDatesForApartment(RestTemplate restTemplate, @RequestParam(value = "id") Long id) {

        return restTemplate.getForObject(
                catalogUrl  + "/getInfoWithFreeDates?id=" + id, ApartmentWithFreeDatesDto.class);

    }

}
