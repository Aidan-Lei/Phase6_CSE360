import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import javafx.geometry.Insets;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;

//BY ILIA SOROKIN
//estimation

public class Proto4 extends Application {

    private ComboBox<EstimationScale> estimationScaleComboBox;

    public void start(Stage stage) throws Exception {

        estimationScaleComboBox = new ComboBox<>();
        estimationScaleComboBox.getItems().addAll(EstimationScale.FIBONACCI, EstimationScale.T_SHIRT, EstimationScale.POWERS_OF_2);
        estimationScaleComboBox.getSelectionModel().selectFirst();

        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.getChildren().add(new Label("Choose estimation scale:"));
        layout.getChildren().add(estimationScaleComboBox);

        Scene scene = new Scene(layout, 300, 300);

        stage.setTitle("Choose Estimation Scale");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private enum EstimationScale {
        FIBONACCI,
        T_SHIRT,
        POWERS_OF_2
    }
}
