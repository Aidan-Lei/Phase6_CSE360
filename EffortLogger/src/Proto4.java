import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EstimationScales extends Application {

    private ComboBox<String> estimationScaleComboBox;
    private TextField customScaleInput;
    private Button addCustomScaleButton;

    @Override
    public void start(Stage stage) throws Exception {

        estimationScaleComboBox = new ComboBox<>();
        estimationScaleComboBox.getItems().addAll("Fibonacci", "T-Shirt", "Powers of 2", "Custom Scale");
        estimationScaleComboBox.getSelectionModel().selectFirst();

        customScaleInput = new TextField();
        customScaleInput.setVisible(false); // Initially hidden

        addCustomScaleButton = new Button("Add Custom Scale");
        addCustomScaleButton.setVisible(false); // Initially hidden

        estimationScaleComboBox.setOnAction(event -> {
            String selectedScale = estimationScaleComboBox.getSelectionModel().getSelectedItem();
            if (selectedScale.equals("Custom Scale")) {
                customScaleInput.setVisible(true); // Show input box when Custom Scale is selected
                addCustomScaleButton.setVisible(true); // Show Add Custom Scale button
            } else {
                customScaleInput.setVisible(false); // Hide input box when other scales are selected
                customScaleInput.setText(""); // Clear input box
                addCustomScaleButton.setVisible(false); // Hide Add Custom Scale button
            }
        });

        addCustomScaleButton.setOnAction(this::addCustomScale);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));

        Label label = new Label("Choose estimation scale:");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        layout.add(label, 0, 0);
        layout.add(estimationScaleComboBox, 1, 0);

        layout.add(customScaleInput, 1, 1);
        layout.add(addCustomScaleButton, 1, 2);

        Scene scene = new Scene(layout, 300, 150);

        stage.setTitle("Choose Estimation Scale");
        stage.setScene(scene);
        stage.show();
    }

    private void addCustomScale(ActionEvent event) {
        String customScaleValues = customScaleInput.getText();
        if (!isValidCustomScale(customScaleValues)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Custom Scale");
            alert.setContentText("Please enter exactly 8 values separated by commas.");
            alert.showAndWait();
            return;
        }

        estimationScaleComboBox.getItems().add(customScaleValues);
        customScaleInput.setText(""); // Clear input box after adding custom scale
    }

    private boolean isValidCustomScale(String customScaleValues) {
        String[] values = customScaleValues.split(",");
        if (values.length != 8) {
            return false;
        }

        for (String value : values) {
            if (!value.matches("[a-zA-Z0-9-]+")) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
