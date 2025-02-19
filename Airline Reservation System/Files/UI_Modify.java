
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class UI_Modify extends JFrame implements ActionListener {
    private JPanel formPanel, pn;
    private JButton requestButton, backButton;
    private JTextField nameField, passportField, emailField;
    private JComboBox<String> dateComboBox, monthComboBox, yearComboBox, hourComboBox, minuteComboBox, ampmComboBox, seatComboBox;

    private ShowDetails currentDetails;

    public UI_Modify(ShowDetails details) {
        super("Request Modification");
        this.currentDetails = details;

        // Frame settings
        setBounds(160, 50, 1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Background Image
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 1100, 600);
        backgroundLabel.setIcon(getScaledImageIcon("img/modify_bg.jpg", 1100, 600));
        add(backgroundLabel);

        //head panel (pn)
        pn = new JPanel(null);
        pn.setBounds(0, 0, 1100, 60);
        pn.setBackground(new Color(102, 0, 255));

        JLabel title = new JLabel("Modify Page", SwingConstants.CENTER);
        title.setFont(new Font("Eras Bold ITC", Font.PLAIN, 20));
        title.setForeground(Color.white);
        title.setBounds(50, 15, 200, 30);
        pn.add(title);


        backgroundLabel.add(pn);

        // Form Panel
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(40, 80, 600, 400);
        formPanel.setBackground(Color.WHITE);
        backgroundLabel.add(formPanel);

        addModifyFields(formPanel);

        // Request Modification Button
        requestButton = createButton("Request Modification", 150, 350);
        requestButton.addActionListener(this);
        formPanel.add(requestButton);

        // Back Button
        backButton = createButton("Back", 350, 350);
        backButton.addActionListener(e -> {
            this.setVisible(false);
            new UI_ShowDetails(currentDetails).setVisible(true);
        });
        formPanel.add(backButton);
    }

    private void addModifyFields(JPanel panel) {
        // Name Field
        JLabel nameLabel = createLabel("Your Name *: ", 50, 30, 150, 30, Color.BLACK, 15, Font.PLAIN);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 30, 250, 30);
        nameField.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        panel.add(nameField);

        // Passport Field
        JLabel passportLabel = createLabel("Passport No *: ", 50, 80, 150, 30, Color.BLACK, 15, Font.PLAIN);
        panel.add(passportLabel);

        passportField = new JTextField();
        passportField.setBounds(200, 80, 250, 30);
        passportField.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        panel.add(passportField);

        // Email Field
        JLabel emailLabel = createLabel("Your Email *: ", 50, 130, 150, 30, Color.BLACK, 15, Font.PLAIN);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 130, 250, 30);
        emailField.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        panel.add(emailField);

        // Departure Date
        JLabel dateLabel = createLabel("Date: ", 50, 180, 150, 30, Color.BLACK, 15, Font.PLAIN);
        panel.add(dateLabel);

        dateComboBox = createComboBox(addNoChangeOption(ModifyPage.getDateOptions()), 200, 180, 60, 30);
        panel.add(dateComboBox);

        monthComboBox = createComboBox(addNoChangeOption(ModifyPage.getMonthOptions()), 270, 180, 100, 30);
        panel.add(monthComboBox);

        yearComboBox = createComboBox(addNoChangeOption(ModifyPage.getYearOptions()), 380, 180, 70, 30);
        panel.add(yearComboBox);

        // Departure Time
        JLabel timeLabel = createLabel("Time: ", 50, 230, 150, 30, Color.BLACK, 15, Font.PLAIN);
        panel.add(timeLabel);

        hourComboBox = createComboBox(addNoChangeOption(ModifyPage.getHourOptions()), 200, 230, 60, 30);
        panel.add(hourComboBox);

        minuteComboBox = createComboBox(addNoChangeOption(ModifyPage.getMinuteOptions()), 270, 230, 100, 30);
        panel.add(minuteComboBox);

        ampmComboBox = createComboBox(addNoChangeOption(ModifyPage.getAmpmOptions()), 380, 230, 70, 30);
        panel.add(ampmComboBox);

        // Seat Type
        JLabel seatLabel = createLabel("Seat: ", 50, 280, 150, 30, Color.BLACK, 15, Font.PLAIN);
        panel.add(seatLabel);

        seatComboBox = createComboBox(addNoChangeOption(ModifyPage.getSeatOptions()), 200, 280, 250, 30);
        panel.add(seatComboBox);
    }

    private String[] addNoChangeOption(String[] options) {
        String[] newOptions = new String[options.length + 1];
        newOptions[0] = "No Change";
        System.arraycopy(options, 0, newOptions, 1, options.length);
        return newOptions;
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, Color color, int fontSize, int fontStyle) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(color);
        label.setFont(new Font("Eras Demi ITC", fontStyle, fontSize));
        return label;
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 30);
        button.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        button.setBackground(new Color(102, 0, 255));
        button.setForeground(Color.WHITE);
        return button;
    }

    private JComboBox<String> createComboBox(String[] options, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, y, width, height);
        comboBox.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
        return comboBox;
    }

    private ImageIcon getScaledImageIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == requestButton) {
            String userName = nameField.getText();
            String passportNumber = passportField.getText();
            String userEmail = emailField.getText();

            // Validate email format (allowing only @gmail.com)
            if (!Pattern.matches("^[A-Za-z0-9+_.-]+@gmail\\.com$", userEmail)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Gmail address (e.g., user@gmail.com).");
                return;
            }

            // Validate passport ID from file
            Set<String> validPassports = loadValidPassportIDs("passport_ids.txt");
            if (!validPassports.contains(passportNumber)) {
                JOptionPane.showMessageDialog(this, "Invalid Passport Number. Please check and try again.");
                return;
            }

           // selected date components
            String selectedDate = (String) dateComboBox.getSelectedItem();
            String selectedMonth = (String) monthComboBox.getSelectedItem();
            String selectedYear = (String) yearComboBox.getSelectedItem();

            // Map month name to number
            int month = mapMonthToNumber(selectedMonth);
            int year = Integer.parseInt(selectedYear);
            int day = Integer.parseInt(selectedDate);

            // Validate February 29 for leap year
            if (month == 2) {
                if (day == 29 && !isLeapYear(year)) {
                    JOptionPane.showMessageDialog(this, "February 29 is not valid in a non-leap year.");
                    return;
                } else if (day == 30 || day == 31) {
                    JOptionPane.showMessageDialog(this, "February only has 28 or 29 days.");
                    return;
                } else if (day == 28 && !isLeapYear(year)) {
                    // February 28 is valid for non-leap years
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                // These months have only 30 days
                if (day == 31) {
                    JOptionPane.showMessageDialog(this, "This month has only 30 days.");
                    return;
                }
            } else if (month == 2) {
                // February in a leap year allows 29, and 28 in any year
                if (day == 30 || day == 31) {
                    JOptionPane.showMessageDialog(this, "February only has 28 or 29 days.");
                    return;
                }
            }

            // Include unchanged values for "No Change" options
            String newDate = dateComboBox.getSelectedItem().equals("No Change")
                    ? currentDetails.getDepartureDate()
                    : selectedDate + " " + selectedMonth + " " + selectedYear;

            String newTime = hourComboBox.getSelectedItem().equals("No Change")
                    ? currentDetails.getDepartureTime()
                    : hourComboBox.getSelectedItem() + ":" + minuteComboBox.getSelectedItem() + " " + ampmComboBox.getSelectedItem();

            String newSeat = seatComboBox.getSelectedItem().equals("No Change")
                    ? currentDetails.getSeatType()
                    : (String) seatComboBox.getSelectedItem();

            // ModifyPage object
            ModifyPage modifyPage = new ModifyPage(passportNumber, userName, userEmail, newDate, newTime, newSeat);

            // Send modification request email
            EmailSender emailSender = new EmailSender();
            boolean emailSent = emailSender.sendModificationRequest(passportNumber, userEmail, userName, currentDetails, modifyPage);

            if (emailSent) {
                JOptionPane.showMessageDialog(this, "Modification request sent successfully.");
                this.setVisible(false);
                new UI_ShowDetails(currentDetails).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to send the request. Please try again.");
            }
        }
    }

    private int mapMonthToNumber(String month) {
        switch (month) {
            case "January": return 1;
            case "February": return 2;
            case "March": return 3;
            case "April": return 4;
            case "May": return 5;
            case "June": return 6;
            case "July": return 7;
            case "August": return 8;
            case "September": return 9;
            case "October": return 10;
            case "November": return 11;
            case "December": return 12;
            default: return -1;
        }
    }

    private Set<String> loadValidPassportIDs(String fileName) {
        Set<String> passportIDs = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                passportIDs.add(line.trim());
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load passport IDs from file: " + fileName);
        }
        return passportIDs;
    }
}
