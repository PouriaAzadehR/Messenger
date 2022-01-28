package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientController {

    @FXML
    private TextField password;

    @FXML
    private TextField user_name;

    @FXML
    private Text sign_in_response;


    @FXML
    void sign_in(ActionEvent event) {
        System.out.println("start");
        Client_server.charReq[0] = "0";
        Client_server.charReq[1] = "";
        Client_server.charReq[2] = "";
        Client_server.charReq[3] = user_name.getText();
        Client_server.charReq[4] = "";
        Client_server.charReq[5] = password.getText();
        Client_server.SendToServer(Client_server.charReq);
        String response=Client_server.readFromServer();
        System.out.println(response);
        sign_in_response.setText(response);
        if (response.contains("signed")) {
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

    @FXML
    void signUp_page(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("signUp.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
