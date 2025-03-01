import java.util.ArrayList;

public class UI {

    public static void greetUser() {
        System.out.println("Hello! I'm Yale");
        System.out.println("What can I do for you?");
    }

    public static void exitChat() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void displayTaskAdded(Task task, int taskCount) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }

    public static void displayTaskList(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks have been added");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }
    }

    public static void displayTaskMarked(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    public static void displayTaskUnmarked(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
    }

    public static void displayTaskDeleted(Task task, int taskCount) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }

    public static void displayError(String message) {
        System.out.println("Sorry! " + message);
    }

}
