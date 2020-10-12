package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setTitle("creating combo box ");


        // Create a tile pane
        GridPane gridPane = new GridPane();
        GridPane gridPane2 = new GridPane();


        // Create a scene
        Scene scene = new Scene(gridPane, 600, 300);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(15);
        gridPane.setHgap(5);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        Label values = new Label("Hämtade filmer");

        Scene scene2 = new Scene(gridPane2, 600, 300);
        gridPane2.setAlignment(Pos.TOP_CENTER);
        gridPane2.setVgap(15);
        gridPane2.setHgap(5);
        gridPane2.setPadding(new Insets(10, 10, 10, 10));
        TextField namn = new TextField();
        Label lNamn = new Label("Namn");
        TextField telefon = new TextField();
        Label lTelefon = new Label("Telefon");
        TextField email = new TextField();
        Label lEmail = new Label("Email");


        ObservableList<String> filmer =
                FXCollections.observableArrayList(
                        "Star wars",
                        "Shrek",
                        "Tillsammans",
                        "Scream 4"
                );

        DatePicker datePicker = new DatePicker();
        ObservableList<String> antal =
                FXCollections.observableArrayList(
                        "1", "2", "3", "4", "5"
                );
        final ComboBox film = new ComboBox(filmer);
        film.setPromptText("Film");

        final ComboBox biljetter = new ComboBox(antal);
        biljetter.setPromptText("Antal biljetter");

        Button boka = new Button("Boka");
        //boka.setOnAction(e -> primaryStage.setScene(scene2));
        boka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value = (String) film.getValue();
                values.setText(value);
                primaryStage.setScene(scene2);
            }
        });
        // VBox layout2= new VBox(20);
        Button fortsatt = new Button("Fortsätt");
        Button back = new Button("Bakåt");
        back.setOnAction(e -> primaryStage.setScene(scene));
        Button avbryt = new Button("Avbryt");
        //layout2.getChildren().addAll(namn,lNamn,telefon,lTelefon,email,lEmail,fortsatt,bakat);


        gridPane.add(film, 0, 1);

        //gridPane.add(dagar,1,0);
        gridPane.add(biljetter, 1, 1);
        gridPane.add(datePicker, 2, 1);
        gridPane.add(boka, 1, 3);
        GridPane.setHalignment(boka, HPos.CENTER);


        gridPane2.add(lNamn, 0, 1);
        gridPane2.add(namn, 0, 2);

        gridPane2.add(lTelefon, 1, 1);
        gridPane2.add(telefon, 1, 2);

        gridPane2.add(lEmail, 2, 1);
        gridPane2.add(email, 2, 2);
        gridPane2.add(fortsatt, 2, 8);
        GridPane.setHalignment(fortsatt, HPos.RIGHT);
        gridPane2.add(back, 0, 8);
        GridPane.setHalignment(back, HPos.LEFT);
        gridPane2.add(values,5,6);
        // gridPane2.add(avbryt,3,8);
        // GridPane.setHalignment(avbryt, HPos.RIGHT);



        // Set the scene
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void getValues(ActionEvent event){

    }
}
