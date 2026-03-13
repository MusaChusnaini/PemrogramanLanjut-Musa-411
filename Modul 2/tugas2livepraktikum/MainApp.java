package tugas2livepraktikum;

public class MainApp {
    public static void main(String[] args) {
        TaxiTicket ticket = new TaxiTicket(new TicketInfo("Alice", "Downtown", "Airport", 50.0, 60.0), 30.0);

        ticket.detailedInfo();
        ticket.CheckStatus();

        ticket.DisplayRoute();
        ticket.DisplayEstimatedDuration();

        ticket.slowDown(20);
        ticket.speedUp(15);
    }
}
