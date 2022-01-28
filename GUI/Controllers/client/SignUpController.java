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

public class SignUpController {

    @FXML
    private TextField password;

    @FXML
    private Text response;

    @FXML
    private TextField user_name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField bio;

    @FXML
    private TextField first_name;



    @FXML
    void signUp(ActionEvent event) {

        Client_server.charReq[0] = "1";
        Client_server.charReq[1] = first_name.getText();
        Client_server.charReq[2] = last_name.getText();
        Client_server.charReq[3] = user_name.getText();
        Client_server.charReq[4] = bio.getText();
        Client_server.charReq[5] = password.getText();
        Client_server.SendToServer(Client_server.charReq);
        String response_server = Client_server.readFromServer();
        response.setText(response_server);
        if (response_server.contains("signed")) {
            try {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("signIn.fxml"));
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
    void back(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("signIn.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void remeberme(ActionEvent event) {

    }
}
