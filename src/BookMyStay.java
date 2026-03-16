import java.util.Scanner;
import java.util.HashMap;

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
        HashMap<String, Integer> roomInventory = new HashMap<>();
        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 3);
        roomInventory.put("Suite Room", 2);

        System.out.println("\nCurrent Room Inventory:");
        for (String roomType : roomInventory.keySet()) {
            System.out.println(roomType + " : " + roomInventory.get(roomType) + " available");
        }

        // User input for booking
        System.out.println("\nWhich room would you like to book?");
        System.out.println("Options: Single Room, Double Room, Suite Room");
        System.out.print("Enter room type: ");
        String roomChoice = sc.nextLine(); // renamed variable to avoid conflict

        // Check availability and update
        if (roomInventory.containsKey(roomChoice)) {
            int available = roomInventory.get(roomChoice);
            if (available > 0) {
                roomInventory.put(roomChoice, available - 1);
                System.out.println("Booking confirmed for " + roomChoice + "!");
            } else {
                System.out.println("Sorry, " + roomChoice + " is fully booked.");
            }
        } else {
            System.out.println("Invalid room type entered.");
        }

        System.out.println("\nUpdated Room Inventory:");
        for (String roomType : roomInventory.keySet()) {
            System.out.println(roomType + " : " + roomInventory.get(roomType) + " available");
        }
        System.out.println("\nSearch Available Rooms (Read-only):");
        System.out.println("Available rooms with at least 1 vacancy:");

        for (String roomType : roomInventory.keySet()) {
            int available = roomInventory.get(roomType);
            if (available > 0) { // only show rooms with availability
                System.out.println(roomType + " - Beds: " +
                        (roomType.equals("Single Room") ? 1 : roomType.equals("Double Room") ? 2 : 3) +
                        ", Price: $" +
                        (roomType.equals("Single Room") ? 100 : roomType.equals("Double Room") ? 180 : 300) +
                        ", Available: " + available);
            }
        }
        sc.close();


    }
}
