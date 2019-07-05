package com.techclimber.timespan.web;

import com.techclimber.timespan.service.ITimeSpanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @Autowired
    private ITimeSpanService service;

    @GetMapping("/time/{startTime}/{endTime}")
    public String getTimeSpan(@PathVariable("startTime")String startTime, @PathVariable("endTime") String endTime){
        return "Time Span is: " + service.getSpan(startTime, endTime) + " Hours";
    }
}
