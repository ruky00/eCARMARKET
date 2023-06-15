package com.example.eCARMARKET.Backend.models.aux;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRange {
    private Date date1;
    private Date date2;

    private SimpleDateFormat dateFormat;

    public Date getDate1() { return date1; }

    public void setDate1(Date date1) { this.date1 = date1; }

    public Date getDate2() { return date2; }

    public void setDate2(Date date2) { this.date2 = date2; }

    public String toString(){
        return dateFormat.format(date1) + " - " + dateFormat.format(date2);
    }

    public DateRange(Date date1, Date date2) {
        this.date1 = date1;
        this.date2 = date2;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    }
}
