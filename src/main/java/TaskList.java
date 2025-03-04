import java.util.ArrayList;

/**
 * Represents a list of tasks and provides methods to manage them.
 */

public class TaskList {

    private final ArrayList<Task> taskList;

    /**
     * Constructs an empty TaskList.
     */


    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to add.
     */

    public void addTask(Task task) {
        taskList.add(task);
    }

    /**
     * Deletes a task from the list.
     *
     * @param index The index of the task to delete.
     */

    public void deleteTask(int index) {
        taskList.remove(index);
    }

    /**
     * Marks a task as done.
     *
     * @param index The index of the task to mark as done.
     */

    public void markTask(int index) {
        taskList.get(index).markAsDone();
    }

    /**
     * Marks a task as not done.
     *
     * @param index The index of the task to mark as not done.
     */

    public void unmarkTask(int index) {
        taskList.get(index).markAsNotDone();
    }


    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
  
     /**
     * Returns the list of tasks.
     *
     * @return The list of tasks.
     */

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks.
     */

    public int getTaskCount() {
        return taskList.size();
    }
}
