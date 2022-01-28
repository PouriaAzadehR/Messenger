package com.example.client;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class ClientApplication extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("signIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        stage.setTitle("TWITTER");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("127.0.0.1", 7660)) {
            Client_server.Client_server_connection(client.getOutputStream(),client.getInputStream());
            launch();
        }
    }
}
