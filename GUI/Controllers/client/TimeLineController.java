package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TimeLineController implements Initializable {
    @FXML
    private TextArea show_twits;

    @FXML
    private Button closeButton;

    @FXML
    private TextArea usersField;

    @FXML
    private CheckBox darkMode;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Client_server.charReq[0] = "10";
        Client_server.SendToServer(Client_server.charReq);
        System.out.println(";lajk");
        String response=Client_server.readFromServer();
        System.out.println(response);
        show_twits.setText(response);
    }

    @FXML
    void send_twit(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("sendTwit.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void delete(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("delete.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void reply(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("reply.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void retwit(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("retwit.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void refresh(ActionEvent event){
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

    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void logOut(ActionEvent event) {
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
    void about(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("about.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dark(ActionEvent event) {

    }
    @FXML
    void like(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("like.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void follow(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("follow.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void unfollow(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("unfollow.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void chat(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("chat.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case F1:
                try {
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("sendTwit.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case F2:
                try {
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("TimeLine.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case F3:
                try {
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("myProfile.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case F4:
                Client_server.charReq[0] = "19";
                Client_server.SendToServer(Client_server.charReq);
                String response=Client_server.readFromServer();
                System.out.println(response);
                usersField.setText(response);



        }
    }


    @FXML
    void myProfile(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("myProfile.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void users(ActionEvent event) {
        Client_server.charReq[0] = "19";
        Client_server.SendToServer(Client_server.charReq);
        String response=Client_server.readFromServer();
        System.out.println(response);
        usersField.setText(response);
    }

}
