import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

    public class EmailSender {
        private final String serviceEmail = "onlyformyproject24@gmail.com"; // service email
        private final String servicePassword = "fwxz lmmf nqpp qkfd"; //app password
        private final String adminEmail = "afsanahena24@gmail.com";  // admin email
        public boolean sendModificationRequest(String passportNumber, String userEmail, String userName, ShowDetails currentDetails, ModifyPage modifyPage) {
            try {
                // Set up mail server properties
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");

                // Authenticate the sender
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(serviceEmail, servicePassword);
                    }
                });

                // Prepare the email message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(serviceEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(adminEmail));
                message.setSubject("Flight Modification Request");

                String emailBody = String.format(
                        "Dear Admin,\n\n" +
                                "This mail is to inform the Admin that this user wants to change his/her flight time.\n"+
                                "Below are the details of the modification request:\n\n" +
                                "=== Current Flight Details ===\n" +
                                "User Name: %s\n" +
                                "User Email: %s\n" +
                                "Passport Number: %s\n" +
                                "Departure Date: %s\n" +
                                "Departure Time: %s\n" +
                                "Seat: %s\n\n" +
                                "=== Requested Modifications ===\n" +
                                "New Date: %s\n" +
                                "New Time: %s\n" +
                                "New Seat: %s\n\n" +
                                "Thank you for your assistance.\n\n" +
                                "Best regards,\n" +
                                "AeroVista Assistant",
                        userName,
                        userEmail,
                        passportNumber,
                        currentDetails.getDepartureDate(),
                        currentDetails.getDepartureTime(),
                        currentDetails.getSeatType(),
                        modifyPage.getDate(),
                        modifyPage.getTime(),
                        modifyPage.getSeat()
                        
                );

                message.setText(emailBody);

                // to Send the email
                Transport.send(message);
                return true;
            } catch (MessagingException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
