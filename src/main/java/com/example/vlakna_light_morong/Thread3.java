package com.example.vlakna_light_morong;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class Thread3 extends Thread{
    ImageView zem;
    Group root;
    public Thread3(Group root,ImageView iv){
    this.root=root;
    this.zem=iv;
        Image image1 = new Image("a.png", 128, 128, false, false);
        zem.setImage(image1);
    }
    @Override
    public void run() {
        for (int i=1;i>0;i++){
            Platform.runLater(() -> {
                zem.getTransforms().add(new Rotate(10, 64, 64));
            });
            try {
                sleep(100);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
