package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class chatController implements Initializable {
    static String response;

    static int check = 0;

    static String chat;

    @FXML
    private TextArea chatData;

    @FXML
    private TextField message;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Client_server.charReq[0] = "15";
        String server = "null";
        Client_server.SendToServer(Client_server.charReq);
        chatController.response= Client_server.readFromServer();
//        System.out.println(response);
        System.out.println(response);
        chat=(response);
        chatData.setText(chat);
    }

    @FXML
    void send(ActionEvent event) {
        String server = "null";

        while (check > 0) {
            server = Client_server.readFromServer();
            if (server != null) {
//                    System.out.println(server);
                chat=(server);
                chatData.setText(chat);
                break;
            }
            Client_server.charReq[0] = "14";
            Client_server.SendToServer(Client_server.charReq);
        }
        check++;
        String[] lines = response.split("\n");
        Client_server.charReq[10] = Client_server.charReq[3] + "--->" + message.getText();
        Client_server.charReq[11] = lines[lines.length - 1];
        Client_server.charReq[0] = "16";
        Client_server.SendToServer(Client_server.charReq);
    }

    @FXML
    void back(ActionEvent event) {
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

