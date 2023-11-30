/*import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

//BY ISKANDER KUSHBAY

public class Proto1 extends Application {

    private TextField[] numberFields = new TextField[6];
    private Label resultLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Number Min-Max App");
        
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        for (int i = 0; i < 6; i++) {
            numberFields[i] = new TextField();
            numberFields[i].setPromptText("Enter number " + (i + 1));
        }

        Button calculateButton = new Button("Calculate Min-Max");
        calculateButton.setOnAction(e -> calculateMinMax());

        Button discardButton = new Button("Discard Min-Max");
        discardButton.setOnAction(e -> discardMinMax());

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(calculateButton, discardButton);

        resultLabel.setWrapText(true);

        root.getChildren().addAll(numberFields);
        root.getChildren().add(buttonBox);
        root.getChildren().add(resultLabel);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateMinMax() {
        int[] numbers = new int[6];

        for (int i = 0; i < 6; i++) {
            try {
                numbers[i] = Integer.parseInt(numberFields[i].getText());
                if (numbers[i] < 1 || numbers[i] > 10) {
                    resultLabel.setText("Please enter numbers between 1 and 10.");
                    return;
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid numbers.");
                return;
            }
        }

        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < 6; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        resultLabel.setText("Min: " + min + ", Max: " + max);
    }

    private void discardMinMax() {
        for (TextField field : numberFields) {
            field.clear();
        }
        resultLabel.setText("");
    }
}
*/

//package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

//BY ISKANDER KUSHBAY
//min and max (planning poker)

public class Proto1 extends Application {

    private List<Integer> numberList = new ArrayList<>();
    private Text arrayText = new Text();
    private TextField numberInput = new TextField();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Planning Poker Evaluations App");

        // Create UI elements
        //TextField numberInput = new TextField();
        Button addButton = new Button("Add to Points");
        Button addButton1 = new Button("Delete max");
        Button addButton2 = new Button("Delete min");
        addButton.setOnAction(e -> addNumberToArray(numberInput.getText()));
        addButton1.setOnAction(e -> deleteMaxFromArray());
        addButton2.setOnAction(e -> deleteMinFromArray());
        arrayText.setText("Points: ");
        AnchorPane.setTopAnchor(arrayText, 140.0); // Adjust as needed
        AnchorPane.setLeftAnchor(arrayText, 50.0);
        //VBox vbox = new VBox(10);
        AnchorPane anchor = new AnchorPane();
        //anchor.setPadding(new Insets(10, 10, 10, 10));
        anchor.getChildren().addAll(numberInput, addButton, addButton1, addButton2, arrayText);
        AnchorPane.setTopAnchor(numberInput, 50.0); // Adjust as needed
        AnchorPane.setLeftAnchor(numberInput, 50.0); // Adjust as needed
        AnchorPane.setTopAnchor(addButton, 100.0); // Adjust as needed
        AnchorPane.setLeftAnchor(addButton, 50.0);
        AnchorPane.setTopAnchor(addButton1, 100.0); // Adjust as needed
        AnchorPane.setLeftAnchor(addButton1, 225.0);
        AnchorPane.setTopAnchor(addButton2, 100.0); // Adjust as needed
        AnchorPane.setLeftAnchor(addButton2, 150.0);
        // Set up the scene
        Scene scene = new Scene(anchor, 400, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void addNumberToArray(String input) {
        try {
            int number = Integer.parseInt(input);
            numberList.add(number);
            updateArrayText();
            numberInput.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric)
            System.out.println("Please enter a valid number.");
        }
    }
    
    private void deleteMaxFromArray() {
        try {
            int max = numberList.get(0);
            int maxind = 0;
            for (int i = 0; i < numberList.size(); i ++) {
            	if (max < numberList.get(i)) {
            		maxind = i;
            		max = numberList.get(i);
            	}
            }
            numberList.remove(maxind);
            updateArrayText();
            numberInput.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric)
            System.out.println("Points pool is empty.");
        }
    }
    
    private void deleteMinFromArray() {
        try {
            int min = numberList.get(0);
            int minind = 0;
            for (int i = 0; i < numberList.size(); i ++) {
            	if (min > numberList.get(i)) {
            		min = numberList.get(i);
            		minind = i;
            	}
            }
            numberList.remove(minind);
            updateArrayText();
            numberInput.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric)
            System.out.println("Points pool is empty.");
        }
    }
    
    private void updateArrayText() {
        // Update the Text node with the current array content
    	int sum = 0;
    	int max = numberList.get(0);
        for (int i = 0; i < numberList.size(); i ++) {
        	if (max < numberList.get(i)) {
        		max = numberList.get(i);
        	}
        }
        int min = numberList.get(0);
        for (int i = 0; i < numberList.size(); i ++) {
        	if (min > numberList.get(i)) {
        		min = numberList.get(i);
        	}
        }
    	float n = numberList.size();
    	for (int i: numberList) {
    		sum += i;
    	}
    	float mean = sum/n;
        arrayText.setText("Story points: " + numberList.toString() + "\n" + "Mean: " + mean + "\nMax: " +
    	max +"\nMin: " + min);
    }
}

