package com.example.vlakna_light_morong;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Thread1 extends Thread{
    TextField tf;
    TextArea textArea;
    int vyska;
    int pocetZnakov;
    String hladane;
    ProgressBar bar;
    String textik="slovo sa našlo na pozicii ";

    public Thread1(TextField textField,TextArea ta,ProgressBar bar){
        this.bar=bar;
    this.textArea=ta;
    this.tf=textField;
    this.vyska = 0;
    this.pocetZnakov = 0;
    }
    @Override
    public void run() {
        String subor = "src/main/resources/subor.txt";
        hladane = tf.getText();
        getSizeOfFile(subor);
        najdiVSubore(hladane,subor);
        try {
            sleep(200);
        }catch (InterruptedException e){
        }
    }
    private void getSizeOfFile (String subor) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(subor));
                String riadok = "";
                while (riadok != null) {
                    riadok = br.readLine();
                    if (riadok != null) {
                        vyska++;
                        pocetZnakov += riadok.length();
                    }
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Chybny subor");
            }
    }
    private void najdiVSubore(String hladaneSlovo, String nazovSuboru) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nazovSuboru));
            String riadok = "";
            int index = 1;
            while ((riadok = br.readLine()) != null) {
               for (int i=0;i<riadok.length()- hladaneSlovo.length()+1;i++){
                   if(riadok.substring(i,i+hladaneSlovo.length()).equals(hladaneSlovo)){
                       int finalIndex = index;
                       int finalI = i;
                       Platform.runLater(() -> {
                         textArea.appendText(textik + finalI + " a riadok číslo: " + finalIndex  + "\n");
                       });
                   }
               }
               int finalIndex = index;
               Platform.runLater(() -> {
                   bar.setProgress((100.0 / vyska) * finalIndex / 100.0);
               });
               index++;
               sleep(200);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
