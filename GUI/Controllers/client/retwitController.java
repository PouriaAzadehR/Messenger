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

public class retwitController {
    @FXML
    private TextField retwitId;

    @FXML
    private TextArea respons;


    @FXML
    void retwit(ActionEvent event) {
        Client_server.charReq[7] = retwitId.getText();
        Client_server.charReq[0] = "4";
        Client_server.SendToServer(Client_server.charReq);
        respons.setText(Client_server.readFromServer());
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
