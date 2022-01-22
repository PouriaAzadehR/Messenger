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
        String response_server=Client_server.readFromServer();
        response.setText(response_server);
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

}
