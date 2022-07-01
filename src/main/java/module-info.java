module com.example.vlakna_light_morong {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vlakna_light_morong to javafx.fxml;
    exports com.example.vlakna_light_morong;
}