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
            try {
                String userInput = inputScanner.nextLine().trim(); // Read and trim user input
                if (userInput.toLowerCase().contains("bye".toLowerCase())) {
                    UI.exitChat();
                    break;
                }
                processUserInput(userInput, taskManager);
            } catch (YaleException e) {
                System.out.println("Sorry! " + e.getMessage());
            }
        }
    }

    private static void processUserInput(String userInput, TaskManager taskManager) throws YaleException {
        if (userInput.equalsIgnoreCase("list")) {
            taskManager.displayTaskList();
        } else if (userInput.startsWith("mark ")) {
            processMarkTask(userInput, taskManager);
        } else if (userInput.startsWith("unmark ")) {
            processUnmarkTask(userInput, taskManager);
        } else if (userInput.startsWith("todo")) {
            processToDoTask(userInput, taskManager);
        } else if (userInput.startsWith("deadline ")) {
            processDeadlineTask(userInput, taskManager);
        } else if (userInput.startsWith("event ")) {
            processEventTask(userInput, taskManager);
        } else if (userInput.startsWith("delete ")) {
            processDeleteTask(userInput, taskManager);
        } else {
            throw new YaleException("Invalid command. Please type another command.");
        }
    }

    private static void processMarkTask(String userInput, TaskManager taskManager) {
        int index = Integer.parseInt(userInput.substring(5));
        taskManager.markTask(index);
    }

    private static void processUnmarkTask(String userInput, TaskManager taskManager) {
        int index = Integer.parseInt(userInput.substring(7));
        taskManager.unmarkTask(index);
    }

    private static void processToDoTask(String userInput, TaskManager taskManager) throws YaleException {
        String description = userInput.substring(4).trim();
        if (description.isEmpty()) {
            throw new YaleException("Description cannot be empty.");        }
        else {
            taskManager.addTask(new ToDo(description));
        }
    }

    private static void processDeadlineTask(String userInput, TaskManager taskManager) throws YaleException {
        String[] parts = userInput.substring(9).split(" /by ");
        if (parts.length == 2) {
            String description = parts[0].trim();
            String by = parts[1].trim();
            taskManager.addTask(new Deadline(description, by));
        } else {
            throw new YaleException("Invalid deadline format. Follow: deadline <description> /by <date>\"");
        }
    }

    private static void processEventTask(String userInput, TaskManager taskManager) throws YaleException {
        String[] parts = userInput.substring(6).split(" /from | /to ");
        if (parts.length == 3) {
            String description = parts[0].trim();
            String from = parts[1].trim();
            String to = parts[2].trim();
            taskManager.addTask(new Event(description, from, to));
        } else {
            throw new YaleException("Invalid event format. Follow: event <description> /from <start> /to <end>");
        }
    }

    private static void processDeleteTask(String userInput, TaskManager taskManager) {
        int index = Integer.parseInt(userInput.substring(7));
        taskManager.deleteTask(index);
    }

}
