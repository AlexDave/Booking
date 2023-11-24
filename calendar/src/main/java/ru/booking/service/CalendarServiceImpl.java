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

//    @Override
//    public Calendar createCalendar(Calendar calendar) {
//        calendarRepository.createCalendar(calendar.getId(), calendar.getCheckin(), calendar.getCheckout());
//        return calendar;
//    }
//
//    @Override
//    public Calendar updateCalendar(Calendar calendar) {
//        calendarRepository.updateCalendar(calendar.getId(), calendar.getCheckin(), calendar.getCheckout());
//        return calendar;
//    }

    @Override
    public Calendar saveCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Override
    public Calendar findCalendarById(String id) {
        return calendarRepository.findCalendarById(id);
    }

    @Override
    public Collection<Calendar> findAll() {
        return calendarRepository.findAll();
    }
}
