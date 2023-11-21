package ru.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.booking.entity.Calendar;
import ru.booking.service.CalendarService;

import java.util.Collection;

@RestController
@RequestMapping(value = "/calendar")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping("/all")
    public Collection<Calendar> allRegister(){
        return calendarService.findAll();
    }

    @PostMapping("/findAll")
    public Collection<Calendar> findByDates(@RequestBody Calendar calendar){
        return calendarService.findCalendarsByDates(calendar.getCheckin(), calendar.getCheckout());
    }

    @PostMapping("/findOne")
    public Calendar findById(@RequestParam("id") String id){
        return calendarService.findCalendarById(id);
    }

    @PostMapping("/status")
    public Collection<Calendar> findStatusIsEmpty(@RequestParam("status") String status){
        return calendarService.findCalendarsByStatus(status);
    }

}
