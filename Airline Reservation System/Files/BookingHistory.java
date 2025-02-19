import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookingHistory {
    private final String filePath;

    public BookingHistory(String filePath) {
        this.filePath = filePath;
    }

    public String loadBookingHistory() {
        StringBuilder ticketDetails = new StringBuilder();
        String loggedInUserId = UserSession.getLoggedInUserId();

        if (loggedInUserId == null) {
            return "No user is currently logged in.";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean matchFound = false;


            ticketDetails.append("<b>UserId: ").append(loggedInUserId).append("</b><br>");
            ticketDetails.append("History:<br>");


            while ((line = reader.readLine()) != null) {
                if (line.startsWith("UserId: " + loggedInUserId)) {
                    matchFound = true;
                    // Skip appending UserId here, as it's already added at the top
                } else if (matchFound) {
                    if(line.contains("----------------------------------------"))
                    {
                        ticketDetails.append("----------------------------------------<br>");
                    }
                   else if (line.trim().isEmpty()) {
                        ticketDetails.append("<br>");
                        matchFound = false;
                    } else {
                        ticketDetails.append(line).append("<br>");
                    }
                }
            }

            if (ticketDetails.length() > 0) {
                return ticketDetails.toString();
            } else {
                return "No booking history found for User ID: " + loggedInUserId;
            }
        } catch (IOException e) {
            return "Error reading booking history file.";
        }
    }

}
