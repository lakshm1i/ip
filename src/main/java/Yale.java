import java.io.IOException;
import java.util.Scanner;
/**
 * Represents the main class for the Yale chatbot.
 * Handles the initialization of the application and the main execution loop.
 */
public class Yale {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    /**
     * Constructs a Yale object with the specified file path for storage.
     *
     * @param filePath The file path where tasks are stored.
     */

    public Yale(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList();
            storage.load(taskList.getTaskList());
//            taskList = new TaskList(storage.load());
        } catch (Exception e) {
            ui.showLoadingError();
            taskList = new TaskList();
        }
    }

    /**
     * Runs the Yale application.
     * Displays a welcome message and processes user commands until the user exits with the command "bye".
     */

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String userInput = ui.readCommand();
                if (userInput.toLowerCase().contains("bye".toLowerCase())) {
                    ui.showGoodbye();
                    isExit = true;
                } else {
                    Parser.parse(userInput, taskList, ui, storage);
                }
            } catch (YaleException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Yale("data/Yale.txt").run();
    }


}
