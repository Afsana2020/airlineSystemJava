import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UHomePage extends JFrame implements ActionListener {

    private JPanel pnl1, pnl2;
    private JLabel lb1, backgroundLabel;
    private JButton jb1, jb2, jb3, jb4;

    public UHomePage() {
        super.setTitle("AirLine Reservation Management System");
        super.setBounds(200, 50, 1000, 650);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        // Panel setup
        pnl1 = new JPanel();
        pnl1.setLayout(null);

        // background image
        ImageIcon bgImage = new ImageIcon("img/booking00.jpg");
        Image scaledImage = bgImage.getImage().getScaledInstance(1000, 650, Image.SCALE_SMOOTH);
        backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, 1000, 650);
        pnl1.add(backgroundLabel);

        // Top bar
        pnl2 = new JPanel();
        pnl2.setBounds(0, 0, 1000, 60);
        pnl2.setLayout(null);
        pnl2.setBackground(new Color(0, 102, 255));
        backgroundLabel.add(pnl2);

        lb1 = new JLabel("Booking Home Page");
        lb1.setFont(new Font("Eras Demi ITC", Font.BOLD, 25));
        lb1.setForeground(Color.WHITE);
        lb1.setBounds(20, 15, 400, 25);
        pnl2.add(lb1);


        int rightX = 760;
        //booking now button
        jb1 = new JButton("Booking Now");
        jb1.setBounds(rightX, 220, 200, 60);
        jb1.setFont(new Font("Arial", Font.BOLD, 20));
        jb1.setBackground(Color.YELLOW);
        jb1.setForeground(Color.BLACK);
        jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jb1.setBorder(null);
        jb1.setOpaque(true);
        backgroundLabel.add(jb1);
        jb1.addActionListener(this);

        // Booking History button
        jb4 = new JButton("Booking History");
        jb4.setBounds(rightX, 300, 200, 60);
        jb4.setFont(new Font("Arial", Font.BOLD, 20));
        jb4.setBackground(Color.RED);
        jb4.setForeground(Color.BLACK);
        jb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jb4.setBorder(null);
        jb4.setOpaque(true);
        backgroundLabel.add(jb4);
        jb4.addActionListener(this);

        // exit and back button
        jb2 = new JButton("Exit");
        jb2.setBounds(880, 550, 100, 25);
        jb2.setFont(new Font("Arial", Font.PLAIN, 20));
        jb2.setBackground(new Color(255, 204, 0));
        jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jb2.setBorder(null);
        jb2.setOpaque(true);
        backgroundLabel.add(jb2);
        jb2.addActionListener(this);

        jb3 = new JButton("Back");
        jb3.setBounds(880, 15, 100, 25);
        jb3.setFont(new Font("Arial", Font.PLAIN, 20));
        jb3.setBackground(Color.WHITE);
        jb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jb3.setBorder(null);
        jb3.setOpaque(true);
        pnl2.add(jb3);
        jb3.addActionListener(this);

        super.add(pnl1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jb1) {
            // Navigate to Booking Page
            this.setVisible(false);
            UI_BookingPage bp = new UI_BookingPage();
            bp.setVisible(true);
        } else if (ae.getSource() == jb4) {
            // Navigate to Booking History Page
            this.setVisible(false);
            UI_BookingHistory bh = new UI_BookingHistory();
            bh.setVisible(true);
        } else if (ae.getSource() == jb2) {
            // Exit the application
            System.exit(0);
        } else if (ae.getSource() == jb3) {
            // Navigate back to Login Page
            this.setVisible(false);
            UI_LogInPage lip = new UI_LogInPage();
            lip.setVisible(true);
        }
    }

    public static void main(String[] args) {
        UHomePage uhp = new UHomePage();
        uhp.setVisible(true);
    }
}
