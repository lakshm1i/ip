import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = Paths.get(filePath).toString(); // Ensures the file path is portable
        initializeFile();
    }

    private void initializeFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs(); // Ensure the directory exists
                file.createNewFile();
                System.out.println("Created new storage file: " + filePath);
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }

    public void save(ArrayList<Task> taskList) {
        try (FileWriter fw = new FileWriter(filePath)) {
            for (Task task : taskList) {
                String taskType = (task instanceof ToDo) ? "T" :
                        (task instanceof Deadline) ? "D" : "E";

                String status = task.getStatusIcon().equals("X") ? "1" : "0";
                String line;

                if (task instanceof Deadline) {
                    line = taskType + " | " + status + " | " + task.getDescription() + " | " + ((Deadline) task).getBy();
                } else if (task instanceof Event) {
                    line = taskType + " | " + status + " | " + task.getDescription() + " | " + ((Event) task).getFrom() + " | " + ((Event) task).getTo();
                } else {
                    line = taskType + " | " + status + " | " + task.getDescription();
                }

                fw.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void load(ArrayList<Task> taskList) {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" \\| ");
                String taskType = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                Task task;
                switch (taskType) {
                    case "T":
                        task = new ToDo(description);
                        break;
                    case "D":
                        task = new Deadline(description, parts[3]);
                        break;
                    case "E":
                        task = new Event(description, parts[3], parts[4]);
                        break;
                    default:
                        System.out.println("Unknown task type: " + taskType);
                        continue;
                }

                if (isDone) {
                    task.markAsDone();
                }

                taskList.add(task); // Add the task to TaskList
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}
