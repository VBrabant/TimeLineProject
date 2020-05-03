package com.example.timeline.dto;

public class DateFormat {

    private Long date;
    private Long dateEnd = null;

    public DateFormat(Long date, Long dateEnd){
        this.date = date;
        this.dateEnd = dateEnd;
    }

    public boolean IsIntervalle() {

        return !(dateEnd == null);

    }

    public Long getDate() {
        return date;
    }

    public Long getDateEnd() {
        return dateEnd;
    }
}


