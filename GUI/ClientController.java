package com;

import com.example.demo3.ClientApplication;
import com.example.demo3.Client_server;
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
        Client_server.SendToServer(Client_server.charReq);String response=Client_server.readFromServer();
        System.out.println(response);
        sign_in_response.setText(response);
        FXMLLoader fxmlLoader1 = new FXMLLoader(ClientApplication.class.getResource("TimeLine.fxml"));
        Scene scene1 = null;
        try {
            scene1 = new Scene(fxmlLoader1.load(), 320, 240);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage1 =new Stage();
        stage1.setTitle("Send twit");
        stage1.setScene(scene1);
        stage1.show();

    }

    @FXML
    void signUp_page(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("signUp.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 320, 240);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage =new Stage();
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();

    }
}