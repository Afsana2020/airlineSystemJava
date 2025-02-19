import javax.swing.*;
import java.awt.*;

public class UI_BookingHistory extends JFrame {
    private JLabel ticketDetailsLabel;
    private JScrollPane scrollPane;

    // Constructor to display the booking history UI
    public UI_BookingHistory() {
        super("Booking History");
        setBounds(300, 100, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        JLabel titleLabel = new JLabel("Booking History");
        titleLabel.setFont(new Font("Eras Demi ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 20, 200, 30);
        panel.add(titleLabel);

        // Ticket details
        ticketDetailsLabel = new JLabel("<html></html>");
        ticketDetailsLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));

        // scrolling
        scrollPane = new JScrollPane(ticketDetailsLabel);
        scrollPane.setBounds(30, 60, 540, 220);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 320, 100, 30);
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(new Color(102, 51, 255));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBorder(null);
        backButton.setOpaque(true);
        backButton.addActionListener(e -> goBackToHomePage());
        panel.add(backButton);

        loadBookingHistoryUI();

        super.add(panel);
    }


    private void loadBookingHistoryUI() {
        BookingHistory bookingHistory = new BookingHistory("user_details.txt");

        // Load booking history for the logged-in user
        String ticketDetails = bookingHistory.loadBookingHistory();

        ticketDetailsLabel.setText("<html>" + ticketDetails + "</html>");
    }


    private void goBackToHomePage() {
        setVisible(false);
        UHomePage homePage = new UHomePage();
        homePage.setVisible(true);
    }

    public static void main(String[] args) {

        UI_BookingHistory ui = new UI_BookingHistory();
        ui.setVisible(true);
    }
}
