import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI_UReg extends JFrame implements ActionListener {

    private JPanel pnl, pnl1;
    private JLabel lb1, lb2, lb4, lb6, lb8, lb12, imageLabel;
    private JTextField tf1, tf2, tf3;
    private JComboBox<String> cbb1, cbb2, cbb3;
    private JRadioButton rb1, rb2;
    private ButtonGroup bg1;
    private JPasswordField pf1;
    private JCheckBox cb1;
    private JButton jb1, jb2, homeButton;

    public UI_UReg() {
        super.setTitle("AeroVista AirLine");
        super.setBounds(200, 50, 1000, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        pnl = new JPanel();
        pnl.setLayout(null);
        pnl.setBackground(Color.white);

        // Top panel
        pnl1 = new JPanel();
        pnl1.setBounds(0, 0, 1000, 60);
        pnl1.setLayout(null);
        pnl1.setBackground(new Color(0, 102, 255));
        pnl.add(pnl1);

        lb1 = new JLabel("<<Registration Form>>");
        lb1.setFont(new Font("Eras Demi ITC", Font.BOLD, 25));
        lb1.setForeground(Color.WHITE);
        lb1.setBounds(20, 15, 300, 25);
        pnl1.add(lb1);

        // Home button
        homeButton = new JButton("Home");
        homeButton.setBounds(900, 15, 80, 30);
        homeButton.setFont(new Font("Arial", Font.BOLD, 12));
        homeButton.setBackground(Color.WHITE);
        homeButton.setForeground(new Color(0, 102, 255));
        homeButton.addActionListener(this);
        pnl1.add(homeButton);

        // Form fields
        lb2 = new JLabel("User Name *");
        lb2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb2.setBounds(20, 60, 100, 25);
        pnl.add(lb2);

        tf1 = new JTextField();
        tf1.setBounds(20, 90, 200, 30);
        tf1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        pnl.add(tf1);

        lb4 = new JLabel("Email *");
        lb4.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb4.setBounds(20, 130, 100, 25);
        pnl.add(lb4);

        tf2 = new JTextField();
        tf2.setBounds(20, 160, 200, 30);
        tf2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        pnl.add(tf2);

        lb6 = new JLabel("Phone No *");
        lb6.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb6.setBounds(20, 200, 100, 25);
        pnl.add(lb6);

        tf3 = new JTextField();
        tf3.setBounds(20, 230, 200, 30);
        tf3.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        pnl.add(tf3);

        lb8 = new JLabel("DOB *");
        lb8.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb8.setBounds(20, 270, 100, 25);
        pnl.add(lb8);

        String[] dates = { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        cbb1 = new JComboBox<>(dates);
        cbb1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb1.setBounds(20, 300, 70, 30);
        cbb1.setBackground(Color.WHITE);
        pnl.add(cbb1);

        String[] months = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        cbb2 = new JComboBox<>(months);
        cbb2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb2.setBounds(110, 300, 110, 30);
        cbb2.setBackground(Color.WHITE);
        pnl.add(cbb2);

        String[] years = { " ", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003" };
        cbb3 = new JComboBox<>(years);
        cbb3.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cbb3.setBounds(240, 300, 90, 30);
        cbb3.setBackground(Color.WHITE);
        pnl.add(cbb3);

        rb1 = new JRadioButton("Male");
        rb1.setBounds(20, 350, 70, 25);
        rb1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        rb1.setBackground(Color.WHITE);
        pnl.add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setBounds(100, 350, 90, 25);
        rb2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        rb2.setBackground(Color.WHITE);
        pnl.add(rb2);

        bg1 = new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        lb12 = new JLabel("Password *");
        lb12.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        lb12.setBounds(20, 390, 100, 25);
        pnl.add(lb12);

        pf1 = new JPasswordField();
        pf1.setBounds(20, 420, 200, 30);
        pf1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        pnl.add(pf1);

        cb1 = new JCheckBox("Accept Terms & Conditions *");
        cb1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        cb1.setBounds(20, 460, 300, 30);
        cb1.setBackground(Color.WHITE);
        pnl.add(cb1);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/uregimg1.jpg").getImage().getScaledInstance(600, 540, Image.SCALE_SMOOTH));
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(400, 60, 600, 540);
        pnl.add(imageLabel);

        jb1 = new JButton("Submit");
        jb1.setBounds(160, 510, 120, 40);
        jb1.setFont(new Font("Arial", Font.BOLD, 15));
        jb1.setBackground(new Color(102, 0, 204));
        jb1.setForeground(Color.WHITE);
        jb1.addActionListener(this);
        pnl.add(jb1);

        jb2 = new JButton("Reset");
        jb2.setBounds(20, 510, 120, 40);
        jb2.setFont(new Font("Arial", Font.BOLD, 15));
        jb2.setBackground(new Color(0, 102, 255));
        jb2.setForeground(Color.WHITE);
        jb2.addActionListener(this);
        pnl.add(jb2);

        super.add(pnl);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jb1) {
            String name = tf1.getText().trim();
            String email = tf2.getText().trim();
            String phoneNo = tf3.getText().trim();
            String dob = cbb1.getSelectedItem() + " " + cbb2.getSelectedItem() + " " + cbb3.getSelectedItem();
            String gender = rb1.isSelected() ? "Male" : (rb2.isSelected() ? "Female" : "");
            String password = new String(pf1.getPassword()).trim();
            boolean acceptedTerms = cb1.isSelected();

            // Check if any field is empty
            if (name.isEmpty() || name.equals(" ") ||
                    email.isEmpty() || email.equals(" ") ||
                    phoneNo.isEmpty() || phoneNo.equals(" ") ||
                    cbb1.getSelectedIndex() == 0 ||
                    cbb2.getSelectedIndex() == 0 ||
                    cbb3.getSelectedIndex() == 0 ||
                    password.isEmpty() || password.equals(" ") ||
                    gender.isEmpty() || gender.equals(" ")) {

                JOptionPane.showMessageDialog(this, "Please fill all the fields!");
                return;
            }


            // Validate email format
            String emailRegex = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
            if (!email.matches(emailRegex)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid @gmail.com email address!");
                return;
            }

            // Validate phone number (must be digits only)
            if (!phoneNo.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "Phone number must be 10 digits!");
                return;
            }

            // Validate password (minimum 6 characters)
            if (password.length() < 6) {
                JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long!");
                return;
            }

            // Check if terms and conditions are accepted
            if (!acceptedTerms) {
                JOptionPane.showMessageDialog(this, "Please accept terms and conditions!");
                return;
            }

            // Date validation for February
            try {
                int day = Integer.parseInt(cbb1.getSelectedItem().toString());
                String month = cbb2.getSelectedItem().toString();
                int year = Integer.parseInt(cbb3.getSelectedItem().toString());

                if (month.equals("February")) {
                    boolean isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                    if ((isLeapYear && day > 29) || (!isLeapYear && day > 28)) {
                        JOptionPane.showMessageDialog(this, "Invalid date for February! Max day is 29 in leap years, otherwise 28.");
                        return;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid date format!");
                return;
            }

            // Check if username is already taken before saving
            UReg user = new UReg(name, email, phoneNo, dob, gender, password);
            if (!user.saveData()) {
                JOptionPane.showMessageDialog(this, "Username already exists! Try a different one.");
                return;
            }

            // Successful registration
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            this.setVisible(false);
            new UI_LogInPage().setVisible(true);
        }
        else if (ae.getSource() == jb2) { // Reset button
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            pf1.setText("");
            cbb1.setSelectedIndex(0);
            cbb2.setSelectedIndex(0);
            cbb3.setSelectedIndex(0);
            bg1.clearSelection();
            cb1.setSelected(false);
        }
        else if (ae.getSource() == homeButton) { // Home button
            this.setVisible(false);
            new FrontPage().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new UI_UReg().setVisible(true);
    }
}
