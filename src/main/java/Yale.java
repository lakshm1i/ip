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
        while(true) {
            line = in.nextLine(); // Read the next line of user input

            if (line.equalsIgnoreCase("bye")) {
                UI.exitChat();
                break;
            } else if (line.equalsIgnoreCase("list")) {
                taskManager.listTask(); //Display all the tasks
            } else if (line.startsWith("mark ")) {
                int index = Integer.parseInt(line.substring(5));
                taskManager.markTask(index);
            } else if (line.startsWith("unmark ")) {
                int index = Integer.parseInt(line.substring(7));
                taskManager.unmarkTask(index);
            } else if (line.startsWith("todo ")) {
                String description = line.substring(5);
                taskManager.addTask(new ToDo(description));
            } else if (line.startsWith("deadline ")) {
                String[] parts = line.substring(9).split(" /by ");
                String description = parts[0];
                String by  = parts[1];
                taskManager.addTask(new Deadline(description, by));
            } else if (line.startsWith("event ")) {
                String[] parts = line.substring(6).split(" /from | /to ");
                String description = parts[0];
                String from = parts[1];
                String to = parts[2];
                taskManager.addTask(new Event(description, from, to));
            }
        }
    }
}
