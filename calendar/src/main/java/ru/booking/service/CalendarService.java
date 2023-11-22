package ru.booking.service;

import ru.booking.entity.Calendar;

import java.util.Collection;

public interface CalendarService {

    Calendar findCalendarById(String id);
    Collection<Calendar> findAll();

}
