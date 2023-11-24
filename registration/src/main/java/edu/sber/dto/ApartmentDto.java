package edu.sber.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApartmentDto(Apartment apartment, FreeDatesDto freeDates) { }
