import java.util.Scanner;

public class Yale {

    public static void main(String[] args) {
        UI.greetUser();
        runChat();
    }

    private static void runChat() {
        TaskManager taskManager = new TaskManager();
        Scanner in = new Scanner(System.in);
        String line;
        line = in.nextLine();  // Read the first line of user input
        while (!line.equalsIgnoreCase("bye")) {
            if (line.equalsIgnoreCase("list")) {
                TaskManager.listTask(); //Display all the tasks
            }
            else if (line.startsWith("mark ")) {
                int index = Integer.parseInt(line.substring(5));
                taskManager.markTask(index);
            }
            else if (line.startsWith("unmark ")) {
                int index = Integer.parseInt(line.substring(7));
                taskManager.unmarkTask(index);
            }
            else {
                TaskManager.addTask(line); //Add the task to the list
            }
            line = in.nextLine(); // Read the next line of user input
        }
        UI.exitChat(); // Exit the chat when the user types "bye"
    }


}
