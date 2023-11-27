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
    public void saveCalendar(Calendar calendar) {
        calendarRepository.save(calendar);
    }

    @Override
    public Calendar findCalendarById(Long id) {
        return calendarRepository.findCalendarById(id);
    }

    @Override
    public Collection<Calendar> findAllBooking() {
        return calendarRepository.findAll();
    }

    @Override
    public Collection<Calendar> findAllById(Long id) {
        return calendarRepository.findAllById(id);
    }

}
