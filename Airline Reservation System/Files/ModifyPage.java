public class ModifyPage {
    private String userEmail, date, time, seat, passportNumber, userName;

    public ModifyPage(String passportNumber, String userName, String userEmail, String date, String time, String seat) {
        this.passportNumber = passportNumber;
        this.userName = userName;
        this.userEmail = userEmail;
        this.date = date;
        this.time = time;
        this.seat = seat;
    }

    // Static methods for dropdown options
    public static String[] getDateOptions() {
        return new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    }

    public static String[] getMonthOptions() {
        return new String[]{ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    }

    public static String[] getYearOptions() {
        return new String[]{"2024", "2025", "2026", "2027", "2028", "2029", "2030"};
    }

    public static String[] getHourOptions() {
        return new String[]{ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    }

    public static String[] getMinuteOptions() {
        return new String[]{ "00", "15", "30", "45"};
    }

    public static String[] getAmpmOptions() {
        return new String[]{ "AM", "PM"};
    }

    public static String[] getSeatOptions() {
        return new String[]{ "Aisle Seat", "Window Seat", "Middle Seat"};
    }

    // Getters
    public String getPassportNumber() {
        return passportNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSeat() {return seat;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
