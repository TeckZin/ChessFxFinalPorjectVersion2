module com.example.chessfxfinalporjectversion2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chessfxfinalporjectversion2 to javafx.fxml;
    exports com.example.chessfxfinalporjectversion2;
}