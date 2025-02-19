public class ShowDetails {
    private String passengerName;
    private String passportNumber;
    private String destination;
    private String flightName;
    private String departureDate;
    private String departureTime;
    private String seatType;

    public ShowDetails(String passengerName, String passportNumber, String destination, String flightName,
                       String departureDate, String departureTime, String seatType) {
        this.passengerName = passengerName;
        this.passportNumber = passportNumber;
        this.destination = destination;
        this.flightName = flightName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.seatType = seatType;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getSeatType() {
        return seatType;
    }
}
