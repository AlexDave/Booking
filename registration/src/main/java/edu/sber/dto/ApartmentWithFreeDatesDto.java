package edu.sber.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApartmentWithFreeDatesDto(ApartmentDto apartment, FreeDatesDto freeDates) { }
