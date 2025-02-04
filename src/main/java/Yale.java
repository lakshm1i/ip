import java.util.Scanner;

public class Yale {
    public static void main(String[] args) {
        greetUser();
        echo();
    }

    public static void greetUser() {
        System.out.println("Hello! I'm Yale");
        System.out.println("What can I do for you?");
    }

    public static void exitChat() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void echo() {
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();  // Read the first line of user input
        while (!line.equalsIgnoreCase("bye")) {
            System.out.println(line); // Echo the user's input
            line = in.nextLine(); // Read the next line of user input
        }
        exitChat(); // Exit the chat when the user types "bye"
    }
}
