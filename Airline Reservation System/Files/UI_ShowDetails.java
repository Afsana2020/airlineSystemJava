import javax.swing.*;
import java.awt.*;

public class UI_ShowDetails extends JFrame {

    public UI_ShowDetails(ShowDetails details) {
        super("Airline Reservation Management System");
        setBounds(160, 50, 1100, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(0, 0, 1100, 60);
        headerPanel.setBackground(new Color(4, 28, 132));
        mainPanel.add(headerPanel);

        JLabel headerLabel = new JLabel("Show Details Page");
        headerLabel.setBounds(20, 10, 400, 30);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Eras Demi ITC", Font.BOLD, 20));
        headerPanel.add(headerLabel);

        // Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(null);
        detailsPanel.setBounds(20, 130, 600, 300);
        detailsPanel.setBackground(new Color(0, 102, 255)); // Blue background
        mainPanel.add(detailsPanel);


        displayDetails(details, detailsPanel);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/shdimg1.jpg").getImage().getScaledInstance(450, 300, Image.SCALE_SMOOTH)); // Ensure the path is correct
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(650, 80, 450, 300);
        mainPanel.add(imageLabel);

        // Modify Button
        JButton modifyButton = createButton("Modify", 450, 260);
        modifyButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        modifyButton.setBackground(new Color(255, 153, 0));
        modifyButton.setForeground(Color.WHITE);
        modifyButton.addActionListener(e -> {
            this.setVisible(false);
            new UI_Modify(details).setVisible(true);
        });
        detailsPanel.add(modifyButton);

        // Back Button
        JButton backButton = createButton("Back", 950, 25);
        backButton.addActionListener(e -> {
            this.setVisible(false);
            new UHomePage().setVisible(true);
        });
        headerPanel.add(backButton);
    }

    private void displayDetails(ShowDetails details, JPanel panel) {
        int yOffset = 20;
        int labelWidth = 500;

        String[] detailTexts = {
                "Passenger Name: " + details.getPassengerName(),
                "Passport Number: " + details.getPassportNumber(),
                "Destination: " + details.getDestination(),
                "Flight Name: " + details.getFlightName(),
                "Departure Date: " + details.getDepartureDate(),
                "Departure Time: " + details.getDepartureTime(),
                "Seat Type: " + details.getSeatType()
        };

        for (String detail : detailTexts) {
            JLabel label = new JLabel(detail);
            label.setBounds(30, yOffset, labelWidth, 30);
            label.setForeground(Color.WHITE); // Text color
            label.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
            panel.add(label);
            yOffset += 40;
        }
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 25);
        button.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
