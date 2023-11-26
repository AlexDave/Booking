package edu.sber.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApartmentDto(Long id, Long priceForDay, String city, String address, boolean petsFriendly,
                           boolean kidsFriendly) { }