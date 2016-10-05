package com.sweetzpot.stravazpot.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.Date;

public class DateMatcher extends BaseMatcher<Date>{

    private Date expected;

    public static DateMatcher isSameDate(Date date) {
        return new DateMatcher(date);
    }

    public DateMatcher(Date expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object item) {
        if(item instanceof Date) {
            Date actual = (Date) item;
            return expected.getTime()/1000 == actual.getTime()/1000;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expected);
    }
}
