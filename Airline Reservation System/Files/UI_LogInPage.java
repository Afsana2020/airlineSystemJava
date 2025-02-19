import javax.swing.*;
import java.awt.*;

public class UI_LogInPage extends JFrame {

    private JTextField tf1;
    private JPasswordField pf1;
    private JButton loginButton, eyeButton, hiddenEyeButton, createAccountButton, homeButton;
    private LogInPage loginLogic;

    public UI_LogInPage() {
        super.setTitle("Airline Reservation Management System");
        super.setBounds(200, 50, 1000, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        loginLogic = new LogInPage();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Left-side image panel
        ImageIcon leftImage = new ImageIcon(new ImageIcon("img/log.jpg").getImage()
                .getScaledInstance(500, 600, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(leftImage);
        imageLabel.setBounds(0, 70, 500, 530);
        mainPanel.add(imageLabel);

        // Top header panel
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 1000, 70);
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(0, 102, 255, 150));
        mainPanel.add(topPanel);

        JLabel headerLabel = new JLabel("Login Page");
        headerLabel.setFont(new Font("Eras Demi ITC", Font.BOLD, 25));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(20, 20, 300, 25);
        topPanel.add(headerLabel);

        homeButton = new JButton("Home");
        homeButton.setBounds(900, 20, 80, 30);
        homeButton.setFont(new Font("Arial", Font.BOLD, 13));
        homeButton.setBackground(Color.WHITE);
        homeButton.setForeground(Color.BLACK);
        homeButton.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 255), 2));
        homeButton.addActionListener(e -> {
            this.setVisible(false);
            new FrontPage().setVisible(true);
        });
        topPanel.add(homeButton);

        // Right-side white background panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(500, 70, 500, 530);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(null);
        mainPanel.add(rightPanel);

        // Login form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(80, 70, 380, 300);
        rightPanel.add(formPanel);

        // Username components
        JLabel usernameLabel = new JLabel("User Name");
        usernameLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        usernameLabel.setBounds(30, 70, 100, 25);
        formPanel.add(usernameLabel);

        tf1 = new JTextField();
        tf1.setBounds(120, 70, 200, 30);
        formPanel.add(tf1);

        // Password components
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        passwordLabel.setBounds(30, 120, 100, 25);
        formPanel.add(passwordLabel);

        pf1 = new JPasswordField();
        pf1.setBounds(120, 120, 200, 30);
        pf1.setEchoChar('*');
        formPanel.add(pf1);

        // Eye toggle buttons
        eyeButton = new JButton(new ImageIcon("img/close-eye1.png"));
        eyeButton.setBounds(330, 120, 24, 24);
        eyeButton.setBorder(null);
        eyeButton.addActionListener(e -> {
            pf1.setEchoChar((char) 0);
            eyeButton.setVisible(false);
            hiddenEyeButton.setVisible(true);
        });
        formPanel.add(eyeButton);

        hiddenEyeButton = new JButton(new ImageIcon("img/eyes1.png"));
        hiddenEyeButton.setBounds(330, 120, 24, 24);
        hiddenEyeButton.setBorder(null);
        hiddenEyeButton.setVisible(false);
        hiddenEyeButton.addActionListener(e -> {
            pf1.setEchoChar('*');
            hiddenEyeButton.setVisible(false);
            eyeButton.setVisible(true);
        });
        formPanel.add(hiddenEyeButton);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(30, 170, 300, 30);
        loginButton.setBackground(new Color(0, 102, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(e -> handleLogin());
        formPanel.add(loginButton);

        // Create account button
        JLabel noAccountLabel = new JLabel("No Account?");
        noAccountLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
        noAccountLabel.setBounds(30, 210, 100, 25);
        formPanel.add(noAccountLabel);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(30, 240, 300, 30);
        createAccountButton.setBackground(new Color(0, 102, 255));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.addActionListener(e -> {
            this.setVisible(false);
            new UI_UReg().setVisible(true);
        });
        formPanel.add(createAccountButton);

        super.add(mainPanel);
    }

    private void handleLogin() {
        String username = tf1.getText();
        String password = new String(pf1.getPassword());

        if (loginLogic.checkLogin(username, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            UserSession.setLoggedInUserId(username);
            this.setVisible(false);
            new UHomePage().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }

    public static void main(String[] args) {
        new UI_LogInPage().setVisible(true);
    }
}
