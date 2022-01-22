package com;

import com.example.demo3.Client_server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SendTwitController {

    @FXML
    private Text response;

    @FXML
    private TextField twit;

    @FXML
    void send(ActionEvent event) {
        Client_server.charReq[6] = twit.getText();
        Client_server.charReq[0] = "2";
        Client_server.SendToServer(Client_server.charReq);
        response.setText(Client_server.readFromServer());
    }


}
