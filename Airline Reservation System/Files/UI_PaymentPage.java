import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UI_PaymentPage extends JFrame implements MouseListener, ActionListener {
    private JPanel pnl1, pnl2;
    private JButton jb1, jb2, imgbtn1, imgbtn2;
    private JTextField tf1, tf2, tf3, tf4;
    private JLabel lbPayDate, imageLabel;
    private PaymentPage paymentLogic;
    private UI_BookingPage bookingPage;
    private ShowDetails details;

    public UI_PaymentPage(double totalPrice, UI_BookingPage bookingPage, ShowDetails details) {
        super("Airline Reservation Management System");
        setBounds(200, 40, 1000, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        this.bookingPage = bookingPage;
        this.details = details;
        this.paymentLogic = new PaymentPage(totalPrice);

        pnl1 = new JPanel(null);
        pnl1.setBackground(Color.white);

        pnl2 = new JPanel(null);
        pnl2.setBounds(0, 0, 1000, 60);
        pnl2.setBackground(new Color(0, 102, 255));
        pnl1.add(pnl2);

        JLabel title = new JLabel("Payment Page", SwingConstants.CENTER);
        title.setFont(new Font("Eras Bold ITC", Font.PLAIN, 20));
        title.setForeground(Color.white);
        title.setBounds(10, 15, 200, 30);
        pnl2.add(title);

        JLabel lbTotal = new JLabel("Total Payment: $" + totalPrice);
        lbTotal.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lbTotal.setBounds(20, 80, 300, 25);
        pnl1.add(lbTotal);

        createFormElements();
        addButtons();
        addPaymentIcons();
        addImageToRight();

        add(pnl1);
    }

    private void createFormElements() {
        String[] labels = { "Card Number *", "CVV *", "PIN *", "Promo Code *", "Pay Date: " };
        JTextField[] fields = { tf1 = new JTextField(), tf2 = new JTextField(), tf3 = new JTextField(), tf4 = new JTextField() };
        int yOffset = 120;

        for (int i = 0; i < labels.length; i++) {
            JLabel lb = new JLabel(labels[i]);
            lb.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
            lb.setBounds(20, yOffset, 200, 25);
            pnl1.add(lb);

            if (i < 4) {
                fields[i].setBounds(20, yOffset + 30, 200, 30);
                pnl1.add(fields[i]);
            } else {
                JPanel datePanel = new JPanel();
                datePanel.setBounds(20, yOffset + 30, 200, 30);
                datePanel.setBackground(new Color(220, 220, 220));
                datePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                lbPayDate = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")), SwingConstants.CENTER);
                lbPayDate.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
                datePanel.add(lbPayDate);
                pnl1.add(datePanel);
            }
            yOffset += 70;
        }
    }

    private void addButtons() {
        jb1 = new JButton("Back");
        jb1.setBounds(840, 20, 100, 30);
        jb1.addActionListener(this);
        pnl1.add(jb1);

        jb2 = new JButton("Exit");
        jb2.setBounds(840, 580, 100, 30);
        jb2.addActionListener(this);
        pnl1.add(jb2);
    }

    private void addPaymentIcons() {
        imgbtn1 = new JButton(new ImageIcon("img/mcard.png"));
        imgbtn1.setBounds(20, 520, 64, 40);
        imgbtn1.addActionListener(this);
        pnl1.add(imgbtn1);

        imgbtn2 = new JButton(new ImageIcon("img/vcard.png"));
        imgbtn2.setBounds(130, 520, 64, 40);
        imgbtn2.addActionListener(this);
        pnl1.add(imgbtn2);
    }

    private void addImageToRight() {
        ImageIcon icon = new ImageIcon("img/ppimg2.jpg");
        Image scaledImage = icon.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(450, 60, 550, 550);
        pnl1.add(imageLabel);
    }

    private String getSelectedDate() {
        return lbPayDate.getText(); // Get real-time system date
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jb1) {
            if (bookingPage != null) {
                bookingPage.setVisible(true);
            }
            setVisible(false);
        } else if (ae.getSource() == jb2) {
            System.exit(0);
        } else if (ae.getSource() == imgbtn1 || ae.getSource() == imgbtn2) {
            String paymentDate = getSelectedDate();

            String message = validateCardDetails(tf1.getText(), tf2.getText(), tf3.getText());
            if (message.equals("Payment Successful")) {
                JOptionPane.showMessageDialog(this, message);
                new UI_ShowDetails(details).setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, message);
            }
        }
    }

    private String validateCardDetails(String cardNumber, String cvv, String pin) {
        try {
            Path path = Paths.get("card_details.txt");
            if (!Files.exists(path)) {
                return "Card details file not found!";
            }

            for (String line : Files.readAllLines(path)) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].trim().equals(cardNumber) && parts[1].trim().equals(cvv) && parts[2].trim().equals(pin)) {
                    return "Payment Successful";
                }
            }
        } catch (IOException e) {
            return "Error reading card details file!";
        }
        return "Invalid Card Details";
    }

    @Override public void mousePressed(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
    @Override public void mouseClicked(MouseEvent me) {}
    @Override public void mouseEntered(MouseEvent me) {}
    @Override public void mouseExited(MouseEvent me) {}
}
