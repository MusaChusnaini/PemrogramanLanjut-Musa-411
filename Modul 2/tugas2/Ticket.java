package tugas2;

public abstract class Ticket {
    protected String passengerName;
    protected String startLocation;
    protected String destination;
    protected double price;

    // Method to display basic info passenger and trip
    public abstract void displayInfo();
}
