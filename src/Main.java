import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class GoodBurger {
    static Map<String, Double> menu = new HashMap<>();
    static Map<String, Integer> order = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize menu
        menu.put("Good Burger", 4.50);
        menu.put("French Fries", 1.50);
        menu.put("Drinks", 1.00);

        // Display welcome message
        System.out.println("WELCOME TO GOOD BURGER.");
        System.out.println("HOME OF THE GOOD BURGER.");
        System.out.println("CAN I TAKE YOUR ORDER");

        // Create order
        createOrder(scanner, "Good Burger");
        createOrder(scanner, "French Fries");
        createOrder(scanner, "Drinks");

        // Read order
        readOrder();

        // Update order
        updateOrder(scanner, "Good Burger");

        // Read order again to see the update
        readOrder();

        // Delete order
        deleteOrder("Good Burger");

        // Read order again to see the deletion
        readOrder();

        // Calculate total
        double total = calculateTotal();
        System.out.println("Total = $" + String.format("%.2f", total));

        scanner.close();
    }

    // Create operation
    public static void createOrder(Scanner scanner, String item) {
        System.out.print(item + " ($" + menu.get(item) + "): ");
        int quantity = scanner.nextInt();
        order.put(item, quantity);
    }

    // Read operation
    public static void readOrder() {
        System.out.println("Current Order:");
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            double price = menu.get(item) * quantity;
            System.out.println(item + " $" + menu.get(item) + " x " + quantity + " = $" + String.format("%.2f", price));
        }
    }

    // Update operation
    public static void updateOrder(Scanner scanner, String item) {
        if (order.containsKey(item)) {
            System.out.print("Update " + item + " quantity: ");
            int quantity = scanner.nextInt();
            order.put(item, quantity);
            System.out.println(item + " updated to " + quantity);
        } else {
            System.out.println("No order found for " + item);
        }
    }

    // Delete operation
    public static void deleteOrder(String item) {
        if (order.containsKey(item)) {
            order.remove(item);
            System.out.println(item + " removed from order");
        } else {
            System.out.println("No order found for " + item);
        }
    }

    // Calculate total
    public static double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            total += menu.get(item) * quantity;
        }
        return total;
    }
}