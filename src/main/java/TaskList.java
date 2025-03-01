import java.util.ArrayList;

public class TaskList {

    private final ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int index) {
        taskList.remove(index);
    }

    public void markTask(int index) {
        taskList.get(index).markAsDone();
    }

    public void unmarkTask(int index) {
        taskList.get(index).markAsNotDone();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public int getTaskCount() {
        return taskList.size();
    }
}
