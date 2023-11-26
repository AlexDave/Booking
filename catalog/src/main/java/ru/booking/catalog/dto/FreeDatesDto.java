package ru.booking.catalog.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FreeDatesDto(ArrayList<String> freeDate) { }
