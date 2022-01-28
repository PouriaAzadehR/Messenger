package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class replyController {
    @FXML
    private TextField replyOn;

    @FXML
    private TextField replied;

    @FXML
    private TextArea response;


    @FXML
    void reply(ActionEvent event) {
        Client_server.charReq[7] = replyOn.getText();
        Client_server.charReq[8] = replied.getText();
        Client_server.charReq[0] = "6";
        Client_server.SendToServer(Client_server.charReq);
        response.setText(Client_server.readFromServer());
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("TimeLine.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
