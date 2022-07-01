package com.example.vlakna_light_morong;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Thread2 extends Thread {
   Label ta;
    public Thread2(Label ta){
        this.ta=ta;
    }
    @Override
    public void run() {
        for (int i=1;i>0;i++){
            int finalI = i;
            Platform.runLater(() -> {
                String pom = "od spustenia ubehlo "+finalI+" sekúnd";
                ta.setText(pom);
            });
            try {
                sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
