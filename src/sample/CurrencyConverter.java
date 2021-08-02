package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
//import javafx.scene.
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;

public class CurrencyConverter extends Application {
    // Instance variables
    final static double EXCHANGE_RATE = 0.81;

    public void start(Stage stage) {
        Label valueLb1 = new Label("Input Value : $");
        Label poundsLbl = new Label();
        TextField dollarsTxt = new TextField();
        Button exchangeBtn = new Button();
        exchangeBtn.setText("Exchange");

        exchangeBtn.setOnAction(actionEvent -> {
            String dollarsStr = dollarsTxt.getCharacters().toString();
            try {
                System.out.println(dollarsStr);
                double dollars = Double.parseDouble(dollarsStr);
                double pounds = exchange(dollars);
                poundsLbl.setText(String.format("%.2f", pounds));
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid Dollar Amount");
                a.setContentText("Please only use digits");
                a.showAndWait();
            }

        });

        HBox input = new HBox();
        input.setAlignment(Pos.CENTER);
        input.getChildren().addAll(valueLb1,dollarsTxt);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(8);
        root.getChildren().addAll(input, exchangeBtn,poundsLbl);

        Scene scene = new Scene(root,400,400);
        stage.setTitle("Dollars to Pounds");
        stage.setScene(scene);
        stage.show();

    }
        private double exchange ( double dollars){
            return dollars * EXCHANGE_RATE;
    }
}