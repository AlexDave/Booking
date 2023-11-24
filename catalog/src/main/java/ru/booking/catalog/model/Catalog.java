package ru.booking.catalog.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.booking.catalog.data.Apartment;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Catalog(List<Apartment> catalog) { }

