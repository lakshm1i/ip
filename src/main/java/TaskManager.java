public class TaskManager {

    private static final Task[] tasks = new Task[100]; //Array to store tasks
    private static int taskCounter = 0; //Track number of tasks stored

    public static void addTask(String description) {
        tasks[taskCounter] = new Task(description); //Add task to array
        taskCounter++; //Increment the task counter
        System.out.println("added: " + description);
    }

    public static void listTask() {
        if (taskCounter == 0) { //Check if there are no tasks in array
            System.out.println("No tasks have been added");
            return;
        }
        for (int i = 0; i < taskCounter; i++) {
            System.out.println((i + 1) + ". " + tasks[i].toString()); //Print task number and name
        }
    }

    public void markTask(int index) {
        if (index > 0 && index <= taskCounter ) {
            tasks[index - 1].markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("  " + tasks[index-1]);
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void unmarkTask(int index) {
        if (index > 0 && index <= taskCounter ) {
            tasks[index-1].markAsNotDone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println("  " + tasks[index-1]);
        }
        else {
            System.out.println("Invalid task index");
        }
    }
}

