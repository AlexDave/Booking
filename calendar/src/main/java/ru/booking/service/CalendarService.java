package ru.booking.service;

import ru.booking.entity.Calendar;

import java.time.LocalDate;
import java.util.Collection;

public interface CalendarService {
    void saveCalendar(Calendar calendar);
    Calendar findCalendarById(Long id);
    Collection<Calendar> findAllBooking();


    Collection<Calendar> findAllById(Long id);
}
