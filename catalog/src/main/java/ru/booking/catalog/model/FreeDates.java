package ru.booking.catalog.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FreeDates(ArrayList<String> freeDate) { }
