import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TodoApp {
    private ArrayList<String> tasks = new ArrayList<>();
    private ListView<String> taskListView = new ListView<>();

    public TodoApp(Stage stage) {
        VBox layout = new VBox(10);
        TextField taskInput = new TextField();
        Button addButton = new Button("Add Task");
        Button removeButton = new Button("Remove Task");

        addButton.setOnAction(e -> addTask(taskInput.getText()));
        removeButton.setOnAction(e -> removeTask());

        layout.getChildren().addAll(new Label("To-Do List"), taskInput, addButton, removeButton, taskListView);

        stage.setScene(new Scene(layout, 300, 400));
        stage.setTitle("To-Do List App");
        stage.show();
    }

    private void addTask(String task) {
        if (!task.isEmpty()) {
            tasks.add(task);
            taskListView.getItems().add(task);
        }
    }

    private void removeTask() {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tasks.remove(selectedIndex);
            taskListView.getItems().remove(selectedIndex);
        }
    }
}