package ru.booking.catalog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.booking.catalog.data.Apartment;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApartmentWithFreeDatesDto(Apartment apartment, FreeDatesDto freeDates) { }
