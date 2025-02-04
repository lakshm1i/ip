import java.util.Scanner;

public class Yale {
    private static String[] tasks = new String[100]; //Array to store tasks
    private static int taskCounter = 0; //Track number of tasks stored

    public static void main(String[] args) {
        greetUser();
        echo();
    }

    public static void greetUser() {
        System.out.println("Hello! I'm Yale");
        System.out.println("What can I do for you?");
    }

    public static void exitChat() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void echo() {
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();  // Read the first line of user input
        while (!line.equalsIgnoreCase("bye")) {
            if (line.equalsIgnoreCase("list")) {
                listTask(); //Display all the tasks
            }
            else {
                addTask(line); //Add the task to the list
            }
            line = in.nextLine(); // Read the next line of user input
        }
        exitChat(); // Exit the chat when the user types "bye"
    }

    private static void addTask(String task) {
        tasks[taskCounter] = task; //Add task to array
        taskCounter++; //Increment the task counter
        System.out.println("added: " + task);
    }

    private static void listTask() {
        if (taskCounter == 0) { //Check if there are no tasks in array
            System.out.println("No tasks have been added");
        }
        for (int i = 0; i < taskCounter; i++) {
            System.out.println((i+1) + ". " + tasks[i]); //Print task number and name
        }
    }
}
