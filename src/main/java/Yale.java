import java.util.Scanner;

public class Yale {

    public static void main(String[] args) {
        UI.greetUser();
        handleUserInput();
    }

    private static void handleUserInput() {
        TaskManager taskManager = new TaskManager();
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            String userInput = inputScanner.nextLine().trim(); // Read and trim user input
            if (userInput.equalsIgnoreCase("bye")) {
                UI.exitChat();
                break;
            }
            processUserInput(userInput, taskManager);
        }
    }

    private static void processUserInput(String userInput, TaskManager taskManager) {
        if (userInput.equalsIgnoreCase("list")) {
            taskManager.displayTaskList();
        } else if (userInput.startsWith("mark ")) {
            processMarkTask(userInput, taskManager);
        } else if (userInput.startsWith("unmark ")) {
            processUnmarkTask(userInput, taskManager);
        } else if (userInput.startsWith("todo ")) {
            processToDoTask(userInput, taskManager);
        } else if (userInput.startsWith("deadline ")) {
            processDeadlineTask(userInput, taskManager);
        } else if (userInput.startsWith("event ")) {
            processEventTask(userInput, taskManager);
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }

    private static void processMarkTask(String userInput, TaskManager taskManager) {
        int index = parseTaskIndex(userInput.substring(5));
        if (index != -1) {
            taskManager.markTask(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    private static void processUnmarkTask(String userInput, TaskManager taskManager) {
        int index = parseTaskIndex(userInput.substring(7));
        if (index != -1) {
            taskManager.unmarkTask(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    private static void processToDoTask(String userInput, TaskManager taskManager) {
        String description = userInput.substring(5).trim();
        if (!description.isEmpty()) {
            taskManager.addTask(new ToDo(description));
        } else {
            System.out.println("Description cannot be empty.");
        }
    }

    private static void processDeadlineTask(String userInput, TaskManager taskManager) {
        String[] parts = userInput.substring(9).split(" /by ");
        if (parts.length == 2) {
            String description = parts[0].trim();
            String by = parts[1].trim();
            taskManager.addTask(new Deadline(description, by));
        } else {
            System.out.println("Invalid deadline format.");
        }
    }

    private static void processEventTask(String userInput, TaskManager taskManager) {
        String[] parts = userInput.substring(6).split(" /from | /to ");
        if (parts.length == 3) {
            String description = parts[0].trim();
            String from = parts[1].trim();
            String to = parts[2].trim();
            taskManager.addTask(new Event(description, from, to));
        } else {
            System.out.println("Invalid event format.");
        }
    }

    private static int parseTaskIndex(String input) {
        try {
            int index = Integer.parseInt(input.trim());
            return index > 0 ? index : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
