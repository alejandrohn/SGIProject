package org.me.isdcm.video.helpers;

import java.sql.Time;
import java.util.Date;

public class Video {

    public int id;
    public String title;
    public String autor;
    public String format;
    public String description;
    public int reproductionNumber;
    public Date createdDate;
    public Duration duration;

    public void formatToDurationType(Time durationElementOfDb) {
        duration = new Duration();
        int hours = durationElementOfDb.getHours();
        int minutes = durationElementOfDb.getMinutes();
        int seconds = durationElementOfDb.getSeconds();
        
        duration.hour = hours < 10 ? "0" + hours : String.valueOf(hours);
        duration.minutes = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        duration.seconds = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
    }
}
