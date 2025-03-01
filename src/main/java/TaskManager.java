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
        UI.displayTaskAdded(task, taskList.size());
        saveTasks();
    }

    public void displayTaskList() {
        UI.displayTaskList(taskList);
    }

    public void markTask(int taskIndex) {
        if (taskIndex > 0 && taskIndex <= taskList.size()) {
            taskList.get(taskIndex - 1).markAsDone();
            UI.displayTaskMarked(taskList.get(taskIndex - 1));
            saveTasks();
        } else {
            UI.displayError("Invalid task index");
        }
    }

    public void unmarkTask(int index) {
        if (index > 0 && index <= taskList.size()) {
            taskList.get(index - 1).markAsNotDone();
            UI.displayTaskUnmarked(taskList.get(index - 1));
            saveTasks();
        } else {
            UI.displayError("Invalid task index");
        }
    }


    public void deleteTask(int index) {
        if (index >= 1 && index <= taskList.size()) {
            Task removedTask = taskList.remove(index - 1); // Remove task at index
            UI.displayTaskDeleted(removedTask, taskList.size());
        } else {
            UI.displayError("Invalid task index.");
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

