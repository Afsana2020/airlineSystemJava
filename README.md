
# Airline Reservation System

The Airline Reservation System is a Java-based desktop application designed to facilitate flight booking and management using Object-Oriented Programming (OOP) concepts and Java Swing as the framework. The system allows users to register and log in, book plane tickets, process payments through credit cards, and view their booking history.

- User Authentication: Secure registration and login system.
- Flight Booking: Search and book plane tickets seamlessly.
- Payment Integration: Process payments using credit cards.
- Booking History: View and manage previous flight reservations.
- Real-Time Communication: Send modification requests for flight details via email directly from the application.
This system enhances the efficiency of airline booking processes while ensuring a user-friendly experience.

## Features: 

### 1) Front page:
   
 ![1](https://github.com/user-attachments/assets/bad83fd7-40e9-4ef8-b025-f2e6c0dda30e)

The Front Page of the Airline Reservation System is elegantly designed using the Java Swing framework, providing a user-friendly interface. It features three main buttons: one leading to the Login Page, another to the Registration Page, and the last one to the About Us Page for system information. 

### 2) Login:

![2](https://github.com/user-attachments/assets/18b8a24d-a97d-41e7-bb20-92bfabf88a15)

The Login Page verifies user credentials by matching them with stored data in a text file created during registration. It includes a password visibility toggle (eye button) for user convenience and a Create Account button that redirects new users to the registration page if they don’t already have an account.

### 3) Registration:

![3](https://github.com/user-attachments/assets/b61f07e3-e4af-4053-a78d-8a0261367a6b)

The Registration Page collects user details to create an account while enforcing strict validation rules. It ensures that only a unique username is accepted, validates the date format (considering February's 28/29 days), enforces a valid email address, and checks for a Bangladeshi phone number (11 digits). Users must also accept the terms and conditions and set a strong password (at least 6 characters long). All registered details are securely stored in a text file, which is later used for authentication during login.

### 4) Booking Home Page:

![4](https://github.com/user-attachments/assets/cece4c2b-dc39-4509-8342-2cd42ca48163)

The Booking Home Page is designed with a simple and intuitive interface using Java Swing. It features two main buttons: one leading to the Booking History page, where users can view their past reservations, and another to the Book Now page

### 5) Booking History:

![5](https://github.com/user-attachments/assets/2833928d-ebd7-4249-b0d9-025ed9bb3581)

The Booking History page retrieves and displays all previous booking details of the logged-in user in a scrollable screen for easy viewing. To achieve this, a global variable is set during login to store the unique user name, which is then used to search for the user's bookings in the details text file. This ensures that each user can access only their own booking history efficiently

### 6) Booking now:

![6 1](https://github.com/user-attachments/assets/711a4431-82c7-494e-801c-aced90d24857)

The Book Now Page collects all necessary details for flight booking while ensuring data accuracy. It verifies the passport ID by matching it against a pre-stored text file that acts as a Reference database of valid passport IDs. The system also calculates the total price based on factors such as direct or connecting flights, flight type, destination, and flight name. Once all details are confirmed, clicking the "Book" button redirects the user to the Payment Page to complete the transaction.

### 7) Payment:

![7 1](https://github.com/user-attachments/assets/592f17b5-53a5-4d96-be60-9cc122134f31)

The Payment Page asks the user to provide card details, including the card number, PIN, and CVV, and verifies this information against a reference text file database for authentication. Users can select either MasterCard or Visa as their preferred payment method. Once the details are validated, the user can complete the transaction, and upon successful payment, the system redirects to the Show Details Page.

### 8) Show details:

![8](https://github.com/user-attachments/assets/97eda2d0-499e-4f28-a796-2f48bdbe4842)

The Show Details Page is where the booking confirmation and flight details are displayed. Here's a button that redirects to modify page.

### 9) Modify Page:

![9](https://github.com/user-attachments/assets/f926efd7-6ff7-4dfa-bf58-6fef3d99fa69)

The Modify Page allows users to request to update their booking details. It first verifies the passport ID and Gmail address for accuracy. Then, the user is prompted to input any modifications they wish to make. If they want to change something, they can click the "Request Modification" button to send a real-time email to the admin through the application. If no changes are needed, users can select "No Change". Once a modification request is submitted, a formatted email is automatically sent to the admin's Gmail account for further processing.


![10](https://github.com/user-attachments/assets/26f8d55e-a681-4d08-9210-3e56f646c366)


### 10) About us:

![11](https://github.com/user-attachments/assets/c201ceb2-5410-4fe5-bd12-502d68758347)

The About Us Page provides contact information about the admins who developed the application

## Tool Used: 
- Java
- Java Swing

## Our Team:
- Afsana Hena
- Abdul Hakim Shifat
- Mihir Borbon
- Marjia Khatun
- Misha Maliha
- Jannatul Aurpy

## Contact:
Email: afsanahena24@gmail.com

LinkedIn: https://www.linkedin.com/in/afsana-hena/









