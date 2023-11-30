import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//BY AIDAN LEI
//login page

public class Proto3 extends Application {

    public static void main1(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Two-Factor Authentication");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        
        //labels and text fields
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Enter your username");
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Enter your password");
        GridPane.setConstraints(passwordInput, 1, 1);

        Label otpLabel = new Label("One-Time Password:");
        GridPane.setConstraints(otpLabel, 0, 2);

        TextField otpInput = new TextField();
        otpInput.setPromptText("Enter your OTP");
        GridPane.setConstraints(otpInput, 1, 2);
        
        //login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 3);
        
        loginButton.setOnAction(e -> {
            if (authenticate(usernameInput.getText(), passwordInput.getText(), otpInput.getText())) {
                System.out.println("Login successful");//correct
            } else {
                System.out.println("Login failed.");//incorrect
            }
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, otpLabel, otpInput, loginButton);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean authenticate(String username, String password, String otp) {
        //Password must be at least 12 characters
    	//Can contain A-Z, a-z, 0-9, and "_", "-". 
    	//Characters "_" and "-" must be followed by a letter
    	//There must be at least one number in your password
        boolean isUsernamePasswordValid = username.equals("aidanlei") && password.equals("phase5prototype");
        boolean OTP = otp.equals("12345"); 
        
        //if everything is true, login is successful
        return isUsernamePasswordValid && OTP;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

