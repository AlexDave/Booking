package ru.booking.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.booking.catalog.data.Apartment;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApartmentResponse(Apartment apartment, FreeDates freeDates) { }
