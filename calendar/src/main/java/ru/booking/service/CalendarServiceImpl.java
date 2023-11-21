package ru.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.booking.entity.Calendar;
import ru.booking.repository.CalendarRepository;
import java.util.Collection;
import java.util.List;

@Component
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;

    @Override
    public Calendar findCalendarById(String id) {
        return calendarRepository.findCalendarById(id);
    }

    @Override
    public List<Calendar> findCalendarsByStatusAndDates(String status, String checkIn, String checkOut) {
        return calendarRepository.findCalendarsByStatusAndCheckinAndCheckout(status, checkIn, checkOut);
    }

    @Override
    public Collection<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    @Override
    public Collection<Calendar> findCalendarsByDates(String checkIn, String checkOut) {
        return calendarRepository.findCalendarsByCheckinAndCheckout(checkIn, checkOut);
    }

    @Override
    public List<Calendar> findCalendarsByStatus(String status) {
        return calendarRepository.findCalendarsByStatus(status);
    }
}
