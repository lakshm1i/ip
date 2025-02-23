import java.util.ArrayList;

public class TaskManager {

    private static final int MAX_TASKS = 100;
    private final ArrayList<Task> taskList = new ArrayList<>();
    private static final String FILE_PATH = "./data/Yale.txt";
    private Storage storage;

    public TaskManager() {
        storage = new Storage(FILE_PATH); // Initialize the Storage with file path
        loadTasks(); // Load tasks from file
    }

    public void addTask(Task task) {
        taskList.add(task);  // Add task to the list
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
        saveTasks();

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
            saveTasks();
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void unmarkTask(int index) {
        if (index > 0 && index <= taskList.size() ) {
            taskList.get(index-1).markAsNotDone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println("  " + taskList.get(index-1));
            saveTasks();
        }
        else {
            System.out.println("Invalid task index");
        }
    }

    // Method to load tasks from the file
    private void loadTasks() {
        storage.loadTasks(taskList);
    }

    // Method to save tasks to the file
    private void saveTasks() {
        storage.saveTasks(taskList);
    }
}

