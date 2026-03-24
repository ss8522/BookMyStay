import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.*;
class Service {
    String name;
    int price;

    Service(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " ($" + price + ")";
    }
}
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

        System.out.println("\nWhich room would you like to book?");
        System.out.println("Options: Single Room, Double Room, Suite Room");
        System.out.print("Enter room type: ");
        String roomChoice = sc.nextLine();

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
            if (available > 0) {
                System.out.println(roomType + " - Beds: " +
                        (roomType.equals("Single Room") ? 1 : roomType.equals("Double Room") ? 2 : 3) +
                        ", Price: $" +
                        (roomType.equals("Single Room") ? 100 : roomType.equals("Double Room") ? 180 : 300) +
                        ", Available: " + available);
            }
        }
        Queue<String> bookingQueue = new LinkedList<>();

        System.out.println("\n--- Booking Request Queue ---");
        System.out.println("Enter booking requests (type 'done' to finish):");

        while (true) {
            System.out.print("Guest name and room type (e.g., John, Single Room): ");
            String request = sc.nextLine();

            if (request.equalsIgnoreCase("done")) {
                break;
            }

            bookingQueue.add(request);
            System.out.println("Request added to queue.");
        }

        System.out.println("\nBooking Requests in Queue (First-Come-First-Served):");
        int count = 1;
        for (String req : bookingQueue) {
            System.out.println(count + ". " + req);
            count++;
        }
        System.out.println("\n--- Processing Booking Queue & Allocating Rooms ---");


        HashMap<String, HashSet<String>> allocatedRooms = new HashMap<>();
        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.put("Double Room", new HashSet<>());
        allocatedRooms.put("Suite Room", new HashSet<>());

        int roomIdCounter = 1;

        while (!bookingQueue.isEmpty()) {
            String request = bookingQueue.poll();
            String[] parts = request.split(",", 2);

            if (parts.length < 2) {
                System.out.println("Invalid request format: " + request);
                continue;
            }

            String guestName = parts[0].trim();
            String requestedRoom = parts[1].trim();


            if (roomInventory.containsKey(requestedRoom)) {
                int available = roomInventory.get(requestedRoom);

                if (available > 0) {

                    String roomId = requestedRoom.substring(0, 1).toUpperCase() + roomIdCounter;
                    roomIdCounter++;


                    allocatedRooms.get(requestedRoom).add(roomId);


                    roomInventory.put(requestedRoom, available - 1);

                    System.out.println("Reservation confirmed for " + guestName +
                            " -> " + requestedRoom + " [Room ID: " + roomId + "]");
                } else {
                    System.out.println("Sorry, " + requestedRoom + " is fully booked for " + guestName);
                }
            } else {
                System.out.println("Invalid room type requested by " + guestName);
            }
        }

        System.out.println("\nFinal Allocated Rooms:");
        for (String roomType : allocatedRooms.keySet()) {
            HashSet<String> ids = allocatedRooms.get(roomType);
            System.out.println(roomType + " -> " + ids);
        }

        System.out.println("\nUpdated Room Inventory After Allocation:");
        for (String roomType : roomInventory.keySet()) {
            System.out.println(roomType + " : " + roomInventory.get(roomType) + " available");
        }
        HashMap<Integer, Service> serviceCatalog = new HashMap<>();
        serviceCatalog.put(1, new Service("Breakfast", 20));
        serviceCatalog.put(2, new Service("Airport Pickup", 50));
        serviceCatalog.put(3, new Service("Extra Bed", 30));

        HashMap<String, List<Service>> addOnServices = new HashMap<>();
        HashMap<String, String> reservationMap = new HashMap<>();

        System.out.println("\n--- Add-On Service Selection ---");

        for (String resId : reservationMap.keySet()) {

            System.out.println("\nReservation: " + resId +
                    " | Guest: " + reservationMap.get(resId));

            List<Service> selected = new ArrayList<>();

            while (true) {
                System.out.println("1. Breakfast ($20)");
                System.out.println("2. Airport Pickup ($50)");
                System.out.println("3. Extra Bed ($30)");
                System.out.println("0. Done");

                int opt = sc.nextInt();

                if (opt == 0) break;

                if (serviceCatalog.containsKey(opt)) {
                    selected.add(serviceCatalog.get(opt));
                    System.out.println("Added: " + serviceCatalog.get(opt).name);
                } else {
                    System.out.println("Invalid option!");
                }
            }

            sc.nextLine(); // clear buffer
            addOnServices.put(resId, selected);
        }

        // Billing
        System.out.println("\n--- Final Billing ---");

        for (String resId : addOnServices.keySet()) {

            List<Service> services = addOnServices.get(resId);
            int total = 0;

            System.out.println("\nReservation: " + resId);

            if (services.isEmpty()) {
                System.out.println("No add-ons selected.");
                continue;
            }

            for (Service s : services) {
                System.out.println("- " + s);
                total += s.price;
            }

            System.out.println("Total Add-On Cost: $" + total);
        }
        List<String> bookingHistory = new ArrayList<>();
        System.out.println("\n--- Booking History ---");

        if (bookingHistory.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            int index = 1;
            for (String record : bookingHistory) {
                System.out.println(index + ". " + record);
                index++;
            }
        }

// Summary Report
        System.out.println("\n--- Booking Summary Report ---");

        HashMap<String, Integer> report = new HashMap<>();

        for (String record : bookingHistory) {

            // record format: RES1 | John | Single Room
            String[] parts = record.split("\\|");

            if (parts.length < 3) continue;

            String roomType = parts[2].trim();

            report.put(roomType, report.getOrDefault(roomType, 0) + 1);
        }

// Print report
        for (String roomType : report.keySet()) {
            System.out.println(roomType + " Bookings: " + report.get(roomType));
        }

        System.out.println("\nTotal Bookings: " + bookingHistory.size());
        sc.close();


    }
}
