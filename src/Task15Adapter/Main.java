package Task15Adapter;

public class Main {
    public static void main(String[] args) {
        // Create instance of CalendarToNewDateAdapter
        NewDateInterface newDate = new CalendarToNewDateAdapter();

        // Set the date
        newDate.setYear(2024);
        newDate.setMonth(11);
        newDate.setDay(6);

        // Advance date by 3 days
        newDate.advanceDate(3);

        // Print the date
        System.out.println("New Date: " + newDate.getYear() + "-" + newDate.getMonth() + "-" + newDate.getDay());
    }
}
