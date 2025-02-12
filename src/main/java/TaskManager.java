public class TaskManager {

    private static final int MAX_TASKS = 100;
    private final Task[] taskList = new Task[MAX_TASKS]; //Array to store tasks
    private int taskCounter = 0; //Track number of tasks stored

    public void addTask(Task task) {
        if (taskCounter < MAX_TASKS) {
            taskList[taskCounter++] = task; //Add task to array
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + task);
            System.out.println("Now you have " + taskCounter + " tasks in the list.");
        }
        else {
            System.out.println("Unable to add more tasks as Task list is full.");
        }
    }

    public void displayTaskList() {
        if (taskCounter == 0) { //Check if there are no tasks in array
            System.out.println("No tasks have been added");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCounter; i++) {
            System.out.println((i + 1) + ". " + taskList[i].toString()); //Print task number and name
        }
    }

    public void markTask(int taskIndex) {
        if (taskIndex > 0 && taskIndex <= taskCounter ) {
            taskList[taskIndex - 1].markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("  " + taskList[taskIndex-1]);
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void unmarkTask(int index) {
        if (index > 0 && index <= taskCounter ) {
            taskList[index-1].markAsNotDone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println("  " + taskList[index-1]);
        }
        else {
            System.out.println("Invalid task index");
        }
    }
}

