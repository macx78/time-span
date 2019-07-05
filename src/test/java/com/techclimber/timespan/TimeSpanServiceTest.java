package com.techclimber.timespan;

import com.techclimber.timespan.service.TimeSpanService;
import javafx.util.converter.LocalTimeStringConverter;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimeSpanServiceTest {
    private static final Logger log = LoggerFactory.getLogger( TimeSpanServiceTest.class );



    @Test
    public void testLocalTime(){
        log.info("Now: {}", LocalTime.now().toString());
        TimeSpanService service = new TimeSpanService();
        LocalTime startTime = service.formatTime("14:00:00.30");
        LocalTime endTime = service.formatTime("15:30:00.30");

        long length = startTime.until(endTime, ChronoUnit.MINUTES);
        float intLength = (float)length;
        log.info("time is length: {}", intLength / 60);
        assertThat(service.formatTime("14:00:00.30"), instanceOf(LocalTime.class));
    }
}
