public class UserSession {
    // This will hold the userId globally
    private static String loggedInUserId = null;

    // Method to set the logged-in user ID
    public static void setLoggedInUserId(String userId) {
        loggedInUserId = userId;
    }

    // Method to get the logged-in user ID
    public static String getLoggedInUserId() {
        return loggedInUserId;
    }

    // Method to clear the user session when logging out
    public static void clearSession() {
        loggedInUserId = null;
    }

    // Method to check if a user is logged in
    public static boolean isLoggedIn() {
        return loggedInUserId != null;
    }
}
