package tugas2;

public class TaxiTicket extends Ticket implements Operational {

    public static final double TAX_RATE = 0.1;

    private double duration;
    private double speed;

    private static final double MIN_SPEED = 5;
    private static final double MAX_SPEED = 100;

    public TaxiTicket(TicketInfo ticketInfo, double duration) {
        this.setPassengerName(ticketInfo.passengerName());
        this.setStartLocation(ticketInfo.startLocation());
        this.setDestination(ticketInfo.destination());
        this.setPrice(ticketInfo.price());
        this.duration = duration;
        this.speed = ticketInfo.speed();
    }

    // Method to check taxi status
    @Override
    public void checkStatus() {
        System.out.println("Your taxi is heading to " + getDestination());
    }

    // Method to display estimated travel duration
    @Override
    public void displayEstimatedDuration() {
        System.out.println("Estimated travel duration: " + duration + " minutes");
    }

    // Method to display the route
    @Override
    public void displayRoute() {
        System.out.println("Route: " + getStartLocation() + " -> " + getDestination());
    }

    // Method to slow down the taxi
    public void slowDown(double speedReduction) {
        speed -= speedReduction;
        if (speed < MIN_SPEED)
            speed = MIN_SPEED;
        duration += speedReduction * 0.5;
        System.out.println("Taxi slowed down! Current speed: " + speed + " km/h");
    }
    // [ Lanjutan dari kode diatas ]

    // Method to speed up the taxi
    public void speedUp(double speedIncrease) {
        speed += speedIncrease;
        if (speed > MAX_SPEED)
            speed = MAX_SPEED;
        System.out.println("Taxi sped up! Current speed: " + speed + " km/h");
    }

    // Method to display basic info passenger and trip
    @Override
    public void displayInfo() {
        System.out.println("Passenger Name : " + getPassengerName());
        System.out.println("Start Location  : " + getStartLocation());
        System.out.println("Destination     : " + getDestination());
        System.out.println("Price           : " + getPrice());
        System.out.println("Final Price     : " + calculateFinalePrice()); // Price including 10% tax
    }

    private double calculateFinalePrice() {
        return getPrice() + (getPrice() * TAX_RATE);
    }

    // Method to display full info including duration and speed
    public void detailedInfo() {
        displayInfo();
        System.out.println("Duration        : " + duration + " minutes");
        System.out.println("Speed           : " + speed + " km/h");
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
