import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//BY PRAKTAN PULEKAR
//KEYWORD SEARCHER

public class Proto2 extends Application {
    private ObservableList<String> strings = FXCollections.observableArrayList();
    private ListView<String> resultList = new ListView<>();
    private TextField searchField = new TextField();

    public static void main1(String[] args) {
        launch(args);
    }
    //sample data
    {
        strings.addAll(
            "As an employee I should be able to find relevent user stories by searching key words.",
            "As an employee be able to hide information that isn't relevant to the planning poker session.",
            "As an employee I can search multiple keywords and the prototype will return a more detailed list of user stories.",
            "JavaFX is super fun.",
            "String searching and matching example with JavaFX."
        );
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("String Search App");//title

        Label searchLabel = new Label("Search for strings containing:");//text before text field
        Button searchButton = new Button("Search");//search button

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(searchLabel, searchField, searchButton, resultList);

        searchButton.setOnAction(e -> searchStrings());//when clicked run searchStrings()
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void searchStrings() {
        String searchTerm = searchField.getText().toLowerCase();
        resultList.getItems().clear();

        for (String str : strings) {
            if (str.toLowerCase().contains(searchTerm)) {
                resultList.getItems().add(str);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
