public class Parser {

    public static void parse(String userInput, TaskList taskList, Ui ui, Storage storage) throws YaleException {
        if (userInput.equalsIgnoreCase("list")) {
            ui.showTaskList(taskList.getTaskList());
        } else if (userInput.startsWith("mark ")) {
            int index = Integer.parseInt(userInput.substring(5));
            if (index>=1 && index <= taskList.getTaskList().size()) {
                taskList.markTask(index - 1);
                ui.showTaskMarked(taskList.getTaskList().get(index - 1));
                storage.save(taskList.getTaskList());
            } else {
                throw new YaleException("Index out of bounds");
            }
        } else if (userInput.startsWith("unmark ")) {
            int index = Integer.parseInt(userInput.substring(7));
            if (index>=1 && index <= taskList.getTaskList().size()) {
                taskList.unmarkTask(index - 1);
                ui.showTaskUnmarked(taskList.getTaskList().get(index - 1));
                storage.save(taskList.getTaskList());
            } else {
                throw new YaleException("Index out of bounds");
            }
        } else if (userInput.startsWith("todo")) {
            String description = userInput.substring(4).trim();
            if (description.isEmpty()) {
                throw new YaleException("Description cannot be empty.");
            }
            Task task = new ToDo(description);
            taskList.addTask(task);
            ui.showTaskAdded(task, taskList.getTaskCount());
            storage.save(taskList.getTaskList());
        } else if (userInput.startsWith("deadline ")) {
            String[] parts = userInput.substring(9).split(" /by ");
            if (parts.length == 2) {
                String description = parts[0].trim();
                String by = parts[1].trim();
                Task task = new Deadline(description, by);
                taskList.addTask(task);
                ui.showTaskAdded(task, taskList.getTaskCount());
                storage.save(taskList.getTaskList());
            } else {
                throw new YaleException("Invalid deadline format. Follow: deadline <description> /by <date>");
            }
        } else if (userInput.startsWith("event ")) {
            String[] parts = userInput.substring(6).split(" /from | /to ");
            if (parts.length == 3) {
                String description = parts[0].trim();
                String from = parts[1].trim();
                String to = parts[2].trim();
                Task task = new Event(description, from, to);
                taskList.addTask(task);
                ui.showTaskAdded(task, taskList.getTaskCount());
                storage.save(taskList.getTaskList());
            } else {
                throw new YaleException("Invalid event format. Follow: event <description> /from <start> /to <end>");
            }
        } else if (userInput.startsWith("delete ")) {
            int index = Integer.parseInt(userInput.substring(7));
            if (index>=1 && index <= taskList.getTaskList().size()) {
                Task removedTask = taskList.getTaskList().get(index - 1);
                taskList.deleteTask(index - 1);
                ui.showTaskDeleted(removedTask, taskList.getTaskCount());
                storage.save(taskList.getTaskList());
            } else {
                throw new YaleException("Invalid task index. Please try again.");
            }
        } else {
            throw new YaleException("Invalid command. Please type another command.");
        }
    }
}
