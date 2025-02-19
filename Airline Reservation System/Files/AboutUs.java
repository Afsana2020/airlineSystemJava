import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AboutUs extends JFrame {
      private JPanel panel;
      private JButton backButton;
      private FrontPage frontPage;

      public AboutUs(FrontPage frontPage) {
            this.frontPage = frontPage;
            setTitle("Airline Reservation Management System");
            setBounds(200, 30, 1000, 700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            initUI();
      }

      private void initUI() {
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.WHITE);

            // Title
            JLabel titleLabel = new JLabel("About Us");
            titleLabel.setFont(new Font("Eras Demi ITC", Font.BOLD, 40));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            titleLabel.setBounds(0, 10, 1000, 50);
            panel.add(titleLabel);

            // Member Details
            String[] names = {
                    "Afsana Hena", "Misha Maliha", "Marjia Khatun",
                    "Jannatul Aurpy", "Mihir Bormon", "Abdul Hakim"
            };
            String[] emails = {
                    "afsanahena24@gmail.com", "mishamaliha75@gmail.com", "marjiakhatun.my@gmail.com",
                    "jannatulaurpy@gmail.com", "mihir11ox@gmail.com", "hakim.shifat@gmail.com"
            };
            String[] imagePaths = {
                    "img/hj.jpg", "img/bnf.jpg", "img/ll.jpg",
                    "img/lk.jpg", "img/ima.jpg", "img/mn.jpg"
            };

            int x = 160, y = 100;
            for (int i = 0; i < names.length; i++) {

                  JLabel imageLabel = createImageLabel(imagePaths[i], 150, 150);
                  imageLabel.setBounds(x, y, 150, 150);
                  panel.add(imageLabel);

                  // Name
                  JLabel nameLabel = new JLabel(names[i]);
                  nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
                  nameLabel.setForeground(Color.BLACK);
                  nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
                  nameLabel.setBounds(x, y + 160, 200, 25);
                  panel.add(nameLabel);

                  // Email
                  JLabel emailLabel = new JLabel(emails[i]);
                  emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                  emailLabel.setForeground(Color.DARK_GRAY);
                  emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
                  emailLabel.setBounds(x, y + 185, 200, 25);
                  panel.add(emailLabel);

                  // 3 per row
                  x += 250;
                  if ((i + 1) % 3 == 0) {
                        x = 160;
                        y += 230;
                  }
            }

            // Back button
            backButton = ButtonFactory.createButton("Back", 900, 15, this::handleBackButton);
            panel.add(backButton);

            add(panel);
      }

      private void handleBackButton(ActionEvent e) {
            this.setVisible(false);
            frontPage.setVisible(true);
      }

      private JLabel createImageLabel(String imagePath, int width, int height) {
            File file = new File(imagePath);
            if (!file.exists()) {
                  System.out.println("File not found: " + imagePath);
                  return new JLabel("Image not found"); // Placeholder text
            }

            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(img));
      }

      public static void main(String[] args) {
            FrontPage dummyFrontPage = new FrontPage();
            AboutUs aboutUs = new AboutUs(dummyFrontPage);
            aboutUs.setVisible(true);
      }
}


class ButtonFactory {
      public static JButton createButton(String text, int x, int y, ActionListener action) {
            JButton button = new JButton(text);
            button.setBounds(x, y, 80, 30);
            button.setFont(new Font("Arial", Font.BOLD, 15));
            button.setBackground(Color.WHITE);
            button.addActionListener(action);
            return button;
      }
}
