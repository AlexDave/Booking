package edu.sber.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.sber.dto.FreeDatesDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Apartment(Long id, Long priceForDay, String city, String address, boolean petsFriendly,
                           boolean kidsFriendly) { }