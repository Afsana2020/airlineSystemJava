import java.io.*;
public class BookingPage {

    private String passengerName;
    private String passportID;
    private String tripType;
    private String destination;
    private String flightName;
    private String departureDate;
    private String departureTime;
    private String fareType;
    private String seatType;

    public BookingPage(String passengerName, String passportID, String tripType, String destination,
                       String flightName, String departureDate, String departureTime, String fareType, String seatType) {
        this.passengerName = passengerName;
        this.passportID = passportID;
        this.tripType = tripType;
        this.destination = destination;
        this.flightName = flightName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.fareType = fareType;
        this.seatType = seatType;
    }

    public double calculateTotalPrice() {
        double farePrice = 0;
        double tripPrice = 0;
        double place = 0;
        double flight=0;

        switch (fareType) {
            case "First Class ($4999.00)":
                farePrice = 4999.00;
                break;
            case "Business Class ($3999.00)":
                farePrice = 3999.00;
                break;
            case "Premium Economy Class ($2999.00)":
                farePrice = 2999.00;
                break;
            case "Economy Class ($1999.00)":
                farePrice = 1999.00;
                break;
        }

        switch (tripType) {
            case "Connecting ($799.00)":
                tripPrice = 799.00;
                break;
            case "Direct ($399.00)":
                tripPrice = 399.00;
                break;
        }

        switch(destination)
        {
            case "New York City,USA":
                place=199;
                break;
            case "London,United Kingdom":
                place=150;
                break;
            case "Paris,France":
                place=150;
                break;
            case "Tokyo,Japan":
                place=70;
                break;
            case "Cox's Bazar,Bangladesh":
                place=50;
                break;
        }

        switch(flightName)
        {
            case "Emirates":
                flight=149;
                break;
            case "Qatar Airways":
                flight=100;
                break;
            case "Biman Bangladesh":
                flight=50;
                break;

        }

        return farePrice + tripPrice + place + flight;
    }

    public boolean validateInput() {
        return !passengerName.isEmpty() && !passengerName.equals(" ") &&
                !passportID.isEmpty() && !passportID.equals(" ") &&
                !tripType.isEmpty() && !tripType.equals(" ") &&
                !destination.isEmpty() && !destination.equals(" ") &&
                !flightName.isEmpty() && !flightName.equals(" ") &&
                !departureDate.isEmpty() && !departureDate.equals(" ") &&
                !departureTime.isEmpty() && !departureTime.equals(" ") &&
                !fareType.isEmpty() && !fareType.equals(" ") &&
                !seatType.isEmpty() && !seatType.equals(" ");

    }

    public boolean validatePassportID() {
        try (BufferedReader reader = new BufferedReader(new FileReader("passport_ids.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(passportID)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void saveBookingDetails() {
        String userId = UserSession.getLoggedInUserId();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_details.txt", true))) {
            writer.write("UserId: "+userId+"\n");
            writer.write("Passenger Name: " + passengerName + "\n");
            writer.write("Passport ID: " + passportID + "\n");
            writer.write("Trip Type: " + tripType + "\n");
            writer.write("Destination: " + destination + "\n");
            writer.write("Flight Name: " + flightName + "\n");
            writer.write("Departure Date: " + departureDate + "\n");
            writer.write("Departure Time: " + departureTime + "\n");
            writer.write("Fare Type: " + fareType + "\n");
            writer.write("Seat Type: " + seatType + "\n");
            writer.write("----------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters
    public String getPassengerName() {
        return passengerName;
    }

    public String getPassportID() {
        return passportID;
    }

    public String getTripType() {
        return tripType;
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

    public String getFareType() {
        return fareType;
    }

    public String getSeatType() {
        return seatType;
    }
}