package com.example.eCARMARKET.Backend.util;

public class StringParsingUtil {

    /**
     * Parses the string and divides it into substrings
     * by splitting the original string in sections
     * separated by _
     * @param info is the original string that contains
     * the information
     * @return String[] that contains all the different
     * substrings
     */
    public static String[] StringParser(String info){
        return info.split("_");
    }

}
