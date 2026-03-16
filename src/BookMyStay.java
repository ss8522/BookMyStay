import java.util.Scanner;
public class BookMyStay {
    public static void main(String[] args) {


        System.out.println("====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking Management System");
        System.out.println("   Version: 1.0");
        System.out.println("====================================");

        System.out.println("Application started successfully!");
        System.out.println("Thank you for using Book My Stay.");

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking System v2.1");
        System.out.println("=================================");

        // Room availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("\nAvailable Room Types:");
        System.out.println("1. Single Room");
        System.out.println("2. Double Room");
        System.out.println("3. Suite Room");

        System.out.print("\nEnter your choice (1-3): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("\nSingle Room Details");
            System.out.println("Beds: 1");
            System.out.println("Price per Night: $100");
            System.out.println("Available: " + singleAvailable);
        }
        else if (choice == 2) {
            System.out.println("\nDouble Room Details");
            System.out.println("Beds: 2");
            System.out.println("Price per Night: $180");
            System.out.println("Available: " + doubleAvailable);
        }
        else if (choice == 3) {
            System.out.println("\nSuite Room Details");
            System.out.println("Beds: 3");
            System.out.println("Price per Night: $300");
            System.out.println("Available: " + suiteAvailable);
        }
        else {
            System.out.println("Invalid choice!");
        }

        sc.close();


    }
}
