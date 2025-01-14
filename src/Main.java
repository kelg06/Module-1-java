import java.util.HashMap;
import java.util.Map;

class HelloWorldProgram {
    static String message = "Hello World!";
    static Map<String, String> messageMap = new HashMap<>(); // Basic collection

    public static void main(String[] args) {
        displayMessage();


        storeMessageInMap(message);
        retrieveMessageFromMap("greeting");


        if (isMessageNonEmpty(message)) {
            System.out.println("The message is not empty!");
        } else {
            System.out.println("The message is empty.");
        }


        repeatMessage(3);


        System.out.println("Goodbye from the Hello World Program!");
    }


    public static void displayMessage() {
        System.out.println(message);
    }


    public static void storeMessageInMap(String msg) {
        messageMap.put("greeting", msg);
    }


    public static void retrieveMessageFromMap(String key) {
        if (messageMap.containsKey(key)) {
            System.out.println("Retrieved message: " + messageMap.get(key));
        } else {
            System.out.println("No message found for key: " + key);
        }
    }


    public static boolean isMessageNonEmpty(String msg) {
        return msg != null && !msg.isEmpty();
    }


    public static void repeatMessage(int times) {
        for (int i = 1; i <= times; i++) {
            System.out.println("Repeat " + i + ": " + message);
        }
    }
}
