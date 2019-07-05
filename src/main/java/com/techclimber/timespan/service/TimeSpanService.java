package com.techclimber.timespan.service;

import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Component
public class TimeSpanService implements ITimeSpanService {
    private static final Logger log = LoggerFactory.getLogger( TimeSpanService.class );


    @Override //this only handles within the same day
    public String getSpan(String start, String end) {
        LocalTime startTime = this.formatTime(start);
        LocalTime endTime = this.formatTime(end);
        long length = startTime.until(endTime, ChronoUnit.MINUTES);
        float fLength = (float)length;
        log.info("time is length: {}", length);
        return Float.toString(fLength / 60); //TODO refactor to handle time spans across day changes
    }

    public LocalTime formatTime(String timeIn){
        String[] timeMilSplit = timeIn.split("\\.");
        String[] time = timeMilSplit[0].split(":");
        return LocalTime.of(Integer.valueOf(time[0]), Integer.valueOf(time[1]), Integer.valueOf(time[2]));
    }


}
