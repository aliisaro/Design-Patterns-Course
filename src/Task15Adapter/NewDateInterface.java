package Task15Adapter;

public interface NewDateInterface {
    void setDay(int day);
    void setMonth(int month);
    void setYear(int year);
    int getDay();
    int getMonth();
    int getYear();
    void advanceDate(int days);
}
