import javax.swing.*;
import java.io.*;

public class LogInPage {


    public boolean checkLogin(String enteredName, String enteredPassword) {
        boolean foundUser = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("ureg-data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.startsWith("Name:")) {
                    String storedName = line.substring(5).trim();
                    reader.readLine(); // Email
                    reader.readLine(); // Phone
                    reader.readLine(); // DOB
                    reader.readLine(); // Gender


                    String passwordLine = reader.readLine();
                    if (passwordLine != null && passwordLine.startsWith("Password:")) {
                        String storedPassword = passwordLine.substring(9).trim();

                        if (storedName.equals(enteredName) && storedPassword.equals(enteredPassword)) {
                            foundUser = true; // Login successful
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return foundUser; // Return whether the user was found
    }

    // eye visibility
    public void togglePasswordVisibility(JPasswordField passwordField, JButton eyeButton, JButton hiddenEyeButton) {
        if (passwordField.getEchoChar() == '*') {
            passwordField.setEchoChar((char) 0); // Show password
            eyeButton.setVisible(false);
            hiddenEyeButton.setVisible(true);
        } else {
            passwordField.setEchoChar('*'); // Hide password
            eyeButton.setVisible(true);
            hiddenEyeButton.setVisible(false);
        }
    }
}