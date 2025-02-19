import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.YearMonth;
import java.io.*;
import java.util.*;

public class UI_BookingPage extends JFrame implements ActionListener {

    private JPanel pnl1, pnl2;
    private JLabel imglb, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14;
    private JTextField tf1, tf2;
    private JComboBox<String> cbb1, cbb2, cbb3, cbb4, cbb5, cbb6, cbb7, cbb8, cbb9, cbb10;
    private JRadioButton rb1, rb2;
    private ButtonGroup bg1;
    private ImageIcon img1;
    private JButton jb1, jb2, jb3;

    public UI_BookingPage() {

        super.setTitle("AirLine Reservation Management System");
        super.setBounds(201, 15, 1000, 700);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setBackground(new Color(255, 255, 255, 255));

        pnl2 = new JPanel();
        pnl2.setBounds(0, 0, 1000, 60);
        pnl2.setLayout(null);
        pnl2.setBackground(new Color(0, 102, 255));
        pnl1.add(pnl2);

        lb1 = new JLabel("Lock in your flight, Ready to jet!");
        lb1.setFont(new Font("Eras Demi ITC", Font.BOLD, 25));
        lb1.setForeground(Color.white);
        lb1.setBounds(20, 15, 500, 30);
        pnl2.add(lb1);

        lb2 = new JLabel("Passport Book");
        lb2.setFont(new Font("Eras Demi ITC", Font.BOLD, 20));
        lb2.setBounds(20, 80, 200, 25);
        pnl1.add(lb2);

        lb3 = new JLabel("Passenger Name");
        lb3.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb3.setBounds(20, 120, 150, 25);
        pnl1.add(lb3);
        lb4 = new JLabel("*");
        lb4.setForeground(Color.RED);
        lb4.setBounds(145, 120, 10, 25);
        pnl1.add(lb4);

        tf1 = new JTextField();
        tf1.setBounds(20, 150, 200, 30);
        tf1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        tf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pnl1.add(tf1);

        lb5 = new JLabel("Passport ID");
        lb5.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb5.setBounds(20, 190, 100, 25);
        pnl1.add(lb5);
        lb6 = new JLabel("*");
        lb6.setForeground(Color.RED);
        lb6.setBounds(105, 190, 10, 25);
        pnl1.add(lb6);

        tf2 = new JTextField();
        tf2.setBounds(20, 220, 200, 30);
        tf2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        tf2.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pnl1.add(tf2);

        lb7 = new JLabel("Booking Your Flights");
        lb7.setFont(new Font("Eras Demi ITC", Font.BOLD, 20));
        lb7.setBounds(670, 80, 280, 25);
        pnl1.add(lb7);

        lb8 = new JLabel("Trip Type");
        lb8.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb8.setBounds(670, 120, 100, 25);
        pnl1.add(lb8);

        rb1 = new JRadioButton("Connecting ($799.00)");
        rb1.setBounds(670, 150, 170, 25);
        rb1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        rb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rb1.setBackground(Color.WHITE);
        pnl1.add(rb1);

        rb2 = new JRadioButton("Direct ($399.00)");
        rb2.setBounds(840, 150, 150, 25);
        rb2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        rb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rb2.setBackground(Color.WHITE);
        pnl1.add(rb2);

        bg1 = new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        lb9 = new JLabel("Choose Your Destinations");
        lb9.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb9.setBounds(670, 190, 200, 25);
        pnl1.add(lb9);

        String destinations[] = {" ", "New York City,USA", "London,United Kingdom", "Paris,France", "Tokyo,Japan", "Cox's Bazar,Bangladesh"};
        cbb1 = new JComboBox<>(destinations);
        cbb1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb1.setBounds(670, 220, 250, 30);
        cbb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb1.setBackground(Color.WHITE);
        pnl1.add(cbb1);

        lb10 = new JLabel("Flight Names");
        lb10.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb10.setBounds(670, 260, 100, 25);
        pnl1.add(lb10);

        String flightname[] = {" ", "Emirates","Qatar Airways","Biman Bangladesh"};
        cbb2 = new JComboBox<>(flightname);
        cbb2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb2.setBounds(670, 290, 250, 30);
        cbb2.setBackground(Color.WHITE);
        pnl1.add(cbb2);

        lb11 = new JLabel("Departure Date");
        lb11.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb11.setBounds(670, 330, 150, 25);
        pnl1.add(lb11);

        // Initialize date, month, and year combo boxes
        initializeDateComboBoxes();

        lb12 = new JLabel("Departure Time");
        lb12.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb12.setBounds(670, 400, 150, 25);
        pnl1.add(lb12);

        // Initialize time combo boxes
        initializeTimeComboBoxes();

        lb13 = new JLabel("Fares Type");
        lb13.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb13.setBounds(670, 470, 100, 25);
        pnl1.add(lb13);

        String ftype[] = {" ", "First Class ($4999.00)", "Business Class ($3999.00)", "Premium Economy Class ($2999.00)", "Economy Class ($1999.00)"};
        cbb9 = new JComboBox<>(ftype);
        cbb9.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb9.setBounds(670, 500, 250, 30);
        cbb9.setBackground(Color.WHITE);
        pnl1.add(cbb9);

        lb14 = new JLabel("Choose Your Seat");
        lb14.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb14.setBounds(670, 540, 200, 25);
        pnl1.add(lb14);

        String stype[] = {" ", "Aisle Seat", "Window Seat", "Middle Seat"};
        cbb10 = new JComboBox<>(stype);
        cbb10.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb10.setBounds(670, 570, 250, 30);
        cbb10.setBackground(Color.WHITE);
        cbb10.addActionListener(this);
        pnl1.add(cbb10);

        // Booked and Reset button
        jb3 = new JButton("Reset");
        jb3.setBounds(840, 15, 100, 30);
        jb3.setFont(new Font("Arial", Font.BOLD, 15));
        jb3.setBackground(new Color(255, 255, 255));
        jb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jb3.setForeground(Color.black);
        jb3.setOpaque(true);
        pnl2.add(jb3);
        jb3.addActionListener(this);

        jb1 = new JButton("Booked");
        jb1.setBounds(850, 620, 80, 30);
        jb1.setFont(new Font("Arial", Font.BOLD, 15));
        jb1.setBackground(new Color(102, 0, 255));
        jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jb1.setForeground(Color.WHITE);
        jb1.setBorder(null);
        pnl1.add(jb1);
        jb1.addActionListener(this);

        jb2 = new JButton("Back");
        jb2.setBounds(20, 620, 100, 30);
        jb2.setFont(new Font("Arial", Font.BOLD, 15));
        jb2.setBackground(new Color(102, 0, 255));
        jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jb2.setForeground(Color.white);
        jb2.addActionListener(this);
        pnl1.add(jb2);

        //adding background
        img1 = new ImageIcon("img/bookingimg1.jpg");
        imglb = new JLabel(img1);
        imglb.setBounds(0, 220, 700, 466);
        pnl1.add(imglb);

        super.add(pnl1);
    }

    private void initializeDateComboBoxes() {
        // Initialize months
        String[] months = {" ","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        cbb4 = new JComboBox<>(months);
        cbb4.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb4.setBounds(740, 360, 100, 30);
        cbb4.setBackground(Color.WHITE);
        cbb4.addActionListener(this);
        pnl1.add(cbb4);

        // Initialize years
        String[] years = {" ","2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034"};
        cbb5 = new JComboBox<>(years);
        cbb5.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb5.setBounds(850, 360, 70, 30);
        cbb5.setBackground(Color.WHITE);
        cbb5.addActionListener(this);
        pnl1.add(cbb5);

        // Initialize days based on selected month and year
        cbb3 = new JComboBox<>();
        cbb3.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb3.setBounds(670, 360, 60, 30);
        cbb3.setBackground(Color.WHITE);
        cbb3.addActionListener(this);
        pnl1.add(cbb3);


        cbb4.addActionListener(e -> updateDaysComboBox());
        cbb5.addActionListener(e -> updateDaysComboBox());
    }

    private void updateDaysComboBox() {
        String selectedMonth = (String) cbb4.getSelectedItem();
        String selectedYear = (String) cbb5.getSelectedItem();

        if (selectedMonth == null || selectedYear == null || selectedMonth.trim().isEmpty() || selectedYear.trim().isEmpty()) {
            return;
        }

        try {
            int year = Integer.parseInt(selectedYear.trim());
            int month = Month.valueOf(selectedMonth.trim().toUpperCase()).getValue();

            YearMonth yearMonth = YearMonth.of(year, month);
            int daysInMonth = yearMonth.lengthOfMonth();

            cbb3.removeAllItems();
            cbb3.addItem(" ");
            for (int i = 1; i <= daysInMonth; i++) {
                cbb3.addItem(String.valueOf(i));
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid month or year: " + e.getMessage());
        }
    }


    private void initializeTimeComboBoxes() {
        // Initialize hours
        String[] hours = {" ","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        cbb6 = new JComboBox<>(hours);
        cbb6.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb6.setBounds(670, 430, 60, 30);
        cbb6.setBackground(Color.WHITE);
        cbb6.addActionListener(this);
        pnl1.add(cbb6);

        // Initialize minutes
        String[] minutes = {" ", "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
        cbb7 = new JComboBox<>(minutes);
        cbb7.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb7.setBounds(740, 430, 100, 30);
        cbb7.setBackground(Color.WHITE);
        cbb7.addActionListener(this);
        pnl1.add(cbb7);

        // Initialize AM/PM
        String[] ampm = { " ","AM", "PM"};
        cbb8 = new JComboBox<>(ampm);
        cbb8.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb8.setBounds(850, 430, 70, 30);
        cbb8.setBackground(Color.WHITE);
        cbb8.addActionListener(this);
        pnl1.add(cbb8);
    }



@Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == jb3) {
        // Reset all fields
        bg1.clearSelection();
        tf1.setText(null);
        tf2.setText(null);
        cbb1.setSelectedIndex(0);
        cbb2.setSelectedIndex(0);
        cbb3.setSelectedIndex(0);
        cbb4.setSelectedIndex(0);
        cbb5.setSelectedIndex(0);
        cbb6.setSelectedIndex(0);
        cbb7.setSelectedIndex(0);
        cbb8.setSelectedIndex(0);
        cbb9.setSelectedIndex(0);
        cbb10.setSelectedIndex(0);
    } else if (ae.getSource() == jb1) {
            String name = tf1.getText();
            String passportID = tf2.getText();
            String tripType = rb1.isSelected() ? rb1.getText() : rb2.getText();
            String destination = (String) cbb1.getSelectedItem();
            String flightName = (String) cbb2.getSelectedItem();
            String departureDate = (String) cbb3.getSelectedItem() + " " + (String) cbb4.getSelectedItem() + " " + (String) cbb5.getSelectedItem();
            String departureTime = (String) cbb6.getSelectedItem() + ":" + (String) cbb7.getSelectedItem() + " " + (String) cbb8.getSelectedItem();
            String fareType = (String) cbb9.getSelectedItem();
            String seatType = (String) cbb10.getSelectedItem();

            BookingPage booking = new BookingPage(name, passportID, tripType, destination, flightName, departureDate, departureTime, fareType, seatType);

            if (!booking.validatePassportID()) {
                JOptionPane.showMessageDialog(this, "Invalid Passport ID.");
                return;
            }

            if (!booking.validateInput()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields correctly.");
                return;
            }

            booking.saveBookingDetails();
            ShowDetails details = new ShowDetails(name, passportID, destination, flightName, departureDate, departureTime, seatType);

            double totalPrice = booking.calculateTotalPrice();
            UI_PaymentPage pp = new UI_PaymentPage(totalPrice,this,details);
            pp.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == jb2) {
        this.setVisible(false);
        UHomePage uhp = new UHomePage();
        uhp.setVisible(true);
    }
}


public static void main(String[] args) {
    UI_BookingPage bp = new UI_BookingPage();
    bp.setVisible(true);
}
}