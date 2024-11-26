package com.example.demo;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        Label lbl1 = new Label("Ilość kostek do rzucenia ( 3 - 10 ):  ");
        ChoiceBox<Integer> kostki = new ChoiceBox<Integer>();
        Label lblresult = new Label("Wynik: ");
        Button btn = new Button("Rzuć");
        Text result = new Text();
        kostki.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10);
        kostki.getSelectionModel().select(0);
        grid.add(lbl1, 0, 0);
        grid.add(kostki, 1, 0);
        Scene scene = new Scene(grid, 600, 480);
        stage.setTitle("Kostki");
        stage.setScene(scene);
        stage.show();
        GridPane grid2 = new GridPane();
        btn.setOnAction(e -> {
            grid2.getChildren().clear();
            int suma = 0;
            int[] tab = new int[kostki.getSelectionModel().getSelectedItem()];
            for (int i = 0; i<kostki.getSelectionModel().getSelectedItem(); i++) {
                Random ran = new Random();
                int x = ran.nextInt(6) + 1;
                System.out.println(x);
                tab[i] = x;
                suma = suma + x;
            }
            System.out.println(suma);
            System.out.println("--------");
            for (int j = 0; j<tab.length; j++){
                Text txt1 = new Text("Kostka "+(j+1)+": "+tab[j]);
                grid2.add(txt1, 0, j+3);
            }
            result.setText(String.valueOf(suma));
        });
        grid.add(grid2, 0, 2);
        grid.add(lblresult, 0, 3);
        grid.add(result, 1, 3);
        grid.add(btn, 0, 1);
        }

    public static void main(String[] args) {
        launch();

    }
}