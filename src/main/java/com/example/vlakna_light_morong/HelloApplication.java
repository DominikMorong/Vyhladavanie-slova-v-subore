package com.example.vlakna_light_morong;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    ProgressBar bar ;
    ImageView iv = new ImageView();
    @Override
    public void start(Stage stage)  {
        bar = new ProgressBar();
        bar.setProgress(0);
        TextField tf = new TextField("prosím najprv zadaj slovo až potom hladaj");
        Label ta = new Label();
        ta.setPadding(new Insets(0, 0, 0, 10));
        TextArea textArea = new TextArea();
        ta.setMaxSize(400,100);
        Group root =  new Group();
        VBox vBox = new VBox(10);
        Button btn1 = new Button("Hladaj");
        btn1.setOnAction(actionEvent -> {
            Thread1 vlakno1 = new Thread1(tf,textArea,bar);
            vlakno1.start();
        });
        Thread2 vlakno2 = new Thread2(ta);
        Thread3 vlakno3 = new Thread3(root,iv);
        vlakno2.start();
        vlakno3.start();
        vBox.getChildren().addAll(tf,btn1,textArea,bar,ta,iv);
        root.getChildren().add(vBox);
        Scene scene = new Scene(root, 640, 680);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}