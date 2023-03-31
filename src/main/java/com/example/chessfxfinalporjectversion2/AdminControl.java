package com.example.chessfxfinalporjectversion2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminControl extends MainController implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){


    }

    @FXML
    protected void onResetDefault(){
        super.getPeicesHandler().loadDefaulStartPosition();

    }

}
