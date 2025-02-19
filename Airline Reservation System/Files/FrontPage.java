import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPage extends JFrame implements ActionListener {

       private JPanel pnlHeader;
       private JLabel lbTitle, backgroundLabel;
       private RoundedButton btnLogin, btnRegister, btnAboutUs;

       public FrontPage() {
              super.setTitle("AirLine Reservation Management System");
              super.setBounds(200, 50, 1000, 600);
              super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              super.setResizable(false);

              ImageIcon backgroundImage = new ImageIcon("img/fpimg3.jpg");
              Image scaledImage = backgroundImage.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
              backgroundImage = new ImageIcon(scaledImage);


              backgroundLabel = new JLabel(backgroundImage);
              backgroundLabel.setBounds(0, 0, 1000, 600);
              backgroundLabel.setLayout(null);
              super.add(backgroundLabel);

              // Header Panel
              pnlHeader = new JPanel();
              pnlHeader.setBounds(0, 0, 1000, 70);
              pnlHeader.setBackground(new Color(0, 102, 255, 200)); // Semi-transparent
              pnlHeader.setLayout(null);
              backgroundLabel.add(pnlHeader);

              // Title Label inside the header
              lbTitle = new JLabel("Welcome to AeroVista Airlines ");
              lbTitle.setFont(new Font("Eras Demi ITC", Font.BOLD, 20));
              lbTitle.setForeground(Color.WHITE);
              lbTitle.setBounds(20, 20, 800, 30);
              pnlHeader.add(lbTitle);

              // Login Button
              btnLogin = new RoundedButton("Login", 30);
              btnLogin.setBounds(750, 200, 150, 40);
              btnLogin.setBackground(new Color(0, 102, 255));
              btnLogin.setForeground(Color.WHITE);
              btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
              btnLogin.addActionListener(this);
              backgroundLabel.add(btnLogin);

              // Register Button
              btnRegister = new RoundedButton("Register", 30);
              btnRegister.setBounds(750, 270, 150, 40);
              btnRegister.setBackground(new Color(102, 0, 204));
              btnRegister.setForeground(Color.WHITE);
              btnRegister.setFont(new Font("Arial", Font.BOLD, 18));
              btnRegister.addActionListener(this);
              backgroundLabel.add(btnRegister);

              // About Us Button
              btnAboutUs = new RoundedButton("About Us", 30);
              btnAboutUs.setBounds(750, 340, 150, 40);
              btnAboutUs.setBackground(new Color(0, 153, 76));
              btnAboutUs.setForeground(Color.WHITE);
              btnAboutUs.setFont(new Font("Arial", Font.BOLD, 18));
              btnAboutUs.addActionListener(this);
              backgroundLabel.add(btnAboutUs);
       }

       @Override
       public void actionPerformed(ActionEvent e) {
              if (e.getSource() == btnLogin) {

                     this.setVisible(false);
                     UI_LogInPage loginPage = new UI_LogInPage();
                     loginPage.setVisible(true);
              } else if (e.getSource() == btnRegister) {

                     this.setVisible(false);
                     UI_UReg registerPage = new UI_UReg();
                     registerPage.setVisible(true);
              } else if (e.getSource() == btnAboutUs) {

                     this.setVisible(false);
                     AboutUs aboutUsPage = new AboutUs(this);
                     aboutUsPage.setVisible(true);
              }
       }


       public static void main(String[] args) {
              FrontPage frontPage = new FrontPage();
              frontPage.setVisible(true);
       }
}
