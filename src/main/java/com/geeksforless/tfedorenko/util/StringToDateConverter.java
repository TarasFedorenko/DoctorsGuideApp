package com.geeksforless.tfedorenko.util;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringToDateConverter implements Formatter<Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        try {
            return dateFormat.parse(text);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd");
        }
    }

    @Override
    public String print(Date object, Locale locale) {
        return dateFormat.format(object);
    }
}

