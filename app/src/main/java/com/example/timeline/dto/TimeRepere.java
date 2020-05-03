package com.example.timeline.dto;

import java.util.Arrays;
import java.util.stream.Stream;

public class TimeRepere {

    public String name;
    public String date;
    public String description;
    public String parent;

    public TimeRepere() {}

    public DateFormat getDateFormat() {

        String[] dates =  date.replaceAll(" ", "").split(":");

        if (dates.length == 2) {
            return new DateFormat(Long.parseLong(dates[0]), Long.parseLong(dates[1]));
        } else if (dates.length == 1) {
            return new DateFormat(Long.parseLong(dates[0]), null);
        }
        return null;
    }

}


