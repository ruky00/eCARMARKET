package com.example.eCARMARKET.Backend.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinancialInformationFormatUtil {

    /**
     * Converts two numeric values into a string with format
     * "number1 x number2"
     * @param number1 is the first numeric value
     * @param number2 is the second numeric value
     * @return String with format "number1 x number2"
     */
    public static String formatTwoNumberRelation(double number1, double number2){
        return round(number1, 2) + " x " + round(number2, 2);
    }

    /**
     * Converts two numerical values into a string with format
     * "number1 - number2"
     * @param number1 is the first numerical value
     * @param number2 is the second numerical value
     * @return String with format "number1 - number2"
     */
    public static String formatNumericalRange(double number1, double number2){
        return round(number1, 2) + " - " + round(number2, 2);
    }

    /**
     * Converts two dates into a string with format
     * "date1 - date2"
     * @param date1 is the first date
     * @param date2 is the second date
     * @return String with format "date1 - date2"
     */
    public static String formatDateRange(Date date1, Date date2){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");

        return simpleDateFormat.format(date1) + " - " + simpleDateFormat.format(date2);
    }

    /**
     * Converts a value and a unit in a string with
     * format "valueunit"
     * @param value is the value
     * @param unit is the unit
     * @return String with format "valueunit"
     */
    public static String formatValueWithUnit(double value, String unit){
        return round(value, 2) + unit;
    }

    /**
     * Rounds a double number to a certain number
     * of decimal places
     * @param value is the number to round
     * @param places is the number of decimal places
     * we want the number to be rounded to
     * @return double rounded
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
