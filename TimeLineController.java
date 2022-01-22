package com.GUI;

import com.example.demo3.ClientApplication;
import com.example.demo3.Client_server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TimeLineController implements Initializable {
    @FXML
    private TextArea show_twits; // field for twits





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Client_server.charReq[0] = "10";
        Client_server.SendToServer(Client_server.charReq);
        show_twits.setText(Client_server.readFromServer());
    }

    @FXML
    void send_twit(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("sendTwit.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 320, 240);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage =new Stage();
        stage.setTitle("Send twit");
        stage.setScene(scene);
        stage.show();
    }
}
