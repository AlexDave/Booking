package ru.booking.catalog.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.booking.catalog.data.Apartment;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CatalogDto(List<Apartment> catalog) { }

