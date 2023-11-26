package ru.booking.order.api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Catalog(Long id, Float priceForDay, String city, String address) { }