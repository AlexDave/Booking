package ru.booking.service;

import ru.booking.entity.Calendar;
import java.util.Collection;
import java.util.List;

public interface CalendarService {

    Calendar findCalendarById(String id);
    List<Calendar> findCalendarsByStatusAndDates(String status, String checkIn, String checkOut);
    Collection<Calendar> findAll();
    Collection<Calendar> findCalendarsByDates(String checkIn, String checkOut);
    List<Calendar> findCalendarsByStatus(String status);
}
