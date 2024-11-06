package Task15Adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    private Calendar calendar;

    public CalendarToNewDateAdapter() {
        this.calendar = Calendar.getInstance();
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month - 1); // Months are 0-indexed in Calendar
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1; // Convert 0-indexed month to 1-indexed
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDate(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
