import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles interactions with the user, such as displaying messages and reading input.
 */

public class Ui {

    private final Scanner scanner;

    /**
     * Constructs an Ui object and initializes the scanner for user input.
     */

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays a welcome message to the user.
     */

    public void showWelcome() {
        System.out.println("Hello! I'm Yale");
        System.out.println("What can I do for you?");
    }

    /**
     * Displays a goodbye message to the user.
     */

    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Reads a command from the user.
     *
     * @return The user's input as a trimmed string.
     */

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    /**
     * Displays a loading error message to the user.
     */

    public void showLoadingError() {
        System.out.println("Error loading tasks from file. Starting with an empty task list.");
    }

    /**
     * Displays a message confirming that a task has been added.
     *
     * @param task The task that was added.
     * @param taskCount The total number of tasks after adding.
     */

    public void showTaskAdded(Task task, int taskCount) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }

    /**
     * Displays the list of tasks to the user.
     *
     * @param taskList The list of tasks to display.
     */

    public void showTaskList(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks have been added");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }
    }

    /**
     * Displays a message confirming that a task has been marked as done.
     *
     * @param task The task that was marked as done.
     */


    public void showTaskMarked(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    /**
     * Displays a message confirming that a task has been marked as not done.
     *
     * @param task The task that was marked as not done.
     */

    public void showTaskUnmarked(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
    }

    /**
     * Displays a message confirming that a task has been deleted.
     *
     * @param task The task that was deleted.
     * @param taskCount The total number of tasks after deletion.
     */

    public void showTaskDeleted(Task task, int taskCount) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }
}
