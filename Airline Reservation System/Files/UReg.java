import java.io.*;

public class UReg {

    private String name;
    private String email;
    private String phoneNo;
    private String dob;
    private String gender;
    private String password;
    private static final String FILE_PATH = "ureg-data.txt";

    public UReg(String name, String email, String phoneNo, String dob, String gender, String password) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dob = dob;
        this.gender = gender;
        this.password = password;
    }

    // Method to check if the username already exists
    private boolean isUsernameTaken() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    String existingName = line.substring(6).trim();
                    if (existingName.equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveData() {
        if (isUsernameTaken()) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Email: " + email);
            writer.newLine();
            writer.write("Phone No: " + phoneNo);
            writer.newLine();
            writer.write("DOB: " + dob);
            writer.newLine();
            writer.write("Gender: " + gender);
            writer.newLine();
            writer.write("Password: " + password);
            writer.newLine();
            writer.write("----------------------------------");
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
