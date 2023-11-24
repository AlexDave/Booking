package ru.booking.order.api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Catalog(Long id, Long priceForDay, String city, String address) { }