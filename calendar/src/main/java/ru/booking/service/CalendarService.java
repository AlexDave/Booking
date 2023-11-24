package ru.booking.service;

import ru.booking.entity.Calendar;

import java.util.Collection;

public interface CalendarService {
//    Calendar createCalendar(Calendar calendar);
//    Calendar updateCalendar(Calendar calendar);
    Calendar saveCalendar(Calendar calendar);
    Calendar findCalendarById(String id);
    Collection<Calendar> findAll();


}
