import java.util.Scanner;

public class Yale {

    public static void main(String[] args) {
        UI.greetUser();
        handleUserInput();
    }

    private static void handleUserInput() {
        TaskManager taskManager = new TaskManager();
        Scanner inputScanner = new Scanner(System.in);
        String userInput;
        while(true) {
            userInput = inputScanner.nextLine(); // Read the next line of user input

            if (userInput.equalsIgnoreCase("bye")) {
                UI.exitChat();
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                taskManager.displayTaskList(); //Display all the tasks
            } else if (userInput.startsWith("mark ")) {
                int index = Integer.parseInt(userInput.substring(5));
                taskManager.markTask(index);
            } else if (userInput.startsWith("unmark ")) {
                int index = Integer.parseInt(userInput.substring(7));
                taskManager.unmarkTask(index);
            } else if (userInput.startsWith("todo ")) {
                String description = userInput.substring(5);
                taskManager.addTask(new ToDo(description));
            } else if (userInput.startsWith("deadline ")) {
                String[] parts = userInput.substring(9).split(" /by ");
                String description = parts[0];
                String by  = parts[1];
                taskManager.addTask(new Deadline(description, by));
            } else if (userInput.startsWith("event ")) {
                String[] parts = userInput.substring(6).split(" /from | /to ");
                String description = parts[0];
                String from = parts[1];
                String to = parts[2];
                taskManager.addTask(new Event(description, from, to));
            }
        }
    }
}
