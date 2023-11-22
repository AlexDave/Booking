package ru.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.booking.entity.Calendar;
import ru.booking.repository.CalendarRepository;

import java.util.Collection;

@Component
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;

    @Override
    public Calendar findCalendarById(String id) {
        return calendarRepository.findCalendarById(id);
    }

    @Override
    public Collection<Calendar> findAll() {
        return calendarRepository.findAll();
    }




}
