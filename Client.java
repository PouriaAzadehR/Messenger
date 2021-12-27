package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * this is a class for client which want to connect to server
 * @author pouri
 * @version 1
 * @since today
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("127.0.0.1", 7660)) {
            System.out.println("Connected to server.");
            CommandParser commandParser =new CommandParser(client.getOutputStream(),client.getInputStream());
            System.out.println("done.");
        }
    }
}
