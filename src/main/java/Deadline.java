/**
 * Represents a task with a deadline.
 */

public class Deadline extends Task {

    protected String by;

    /**
     * Constructs a Deadline task with the given description and deadline.
     *
     * @param description The description of the task.
     * @param by The deadline of the task.
     */

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

