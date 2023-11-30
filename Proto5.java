import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//BY DIMMUKHAMED YELEUSSIZ
//Anonymous

public class Proto5 extends Application {

    private String userName;
    private boolean isAnonymous;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label userNameLabel = new Label("User Name:");
        TextField userNameTextField = new TextField();

        Button anonymousButton = new Button("Anonymous");
        Button defaultButton = new Button("Default");

        VBox layout = new VBox();
        layout.getChildren().addAll(userNameLabel, userNameTextField, anonymousButton, defaultButton);

        anonymousButton.setOnAction(e -> {
            isAnonymous = true;
            nextStep(stage);
        });

        defaultButton.setOnAction(e -> {
            isAnonymous = false;
            nextStep(stage);
        });

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    private void nextStep(Stage stage) {

        if (isAnonymous) {
            userName = "1";
        }

        Label welcomeLabel = new Label("Welcome, " + userName + "!");

        Button startButton = new Button("Start Game");

        VBox layout = new VBox();
        layout.getChildren().addAll(welcomeLabel, startButton);

        startButton.setOnAction(e -> {
            // Start the game here
        });

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}
