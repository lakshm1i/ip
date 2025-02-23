import java.util.ArrayList;

public class TaskManager {

    private static final int MAX_TASKS = 100;
    private final ArrayList<Task> taskList = new ArrayList<>();


    public void addTask(Task task) {
        taskList.add(task); // Add task to the list
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public void displayTaskList() {
        if (taskList.isEmpty()) { //Check if there are no tasks in array
            System.out.println("No tasks have been added");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i)); //Print task number and name
        }
    }

    public void markTask(int taskIndex) {
        if (taskIndex > 0 && taskIndex <= taskList.size() ) {
            taskList.get(taskIndex-1).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("  " + taskList.get(taskIndex-1));
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void unmarkTask(int index) {
        if (index > 0 && index <= taskList.size() ) {
            taskList.get(index-1).markAsNotDone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println("  " + taskList.get(index-1));
        }
        else {
            System.out.println("Invalid task index");
        }
    }

    public void deleteTask(int index) {
        if (index >= 1 && index <= taskList.size()) {
            Task removedTask = taskList.remove(index - 1); // Remove task at index
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask);
            System.out.println("Now you have " + taskList.size() + " tasks in the list.");
        } else {
            System.out.println("Invalid task index.");
        }
    }
}

