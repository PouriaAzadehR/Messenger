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

    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 7660)) {
            System.out.println("Connected to server.");
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            byte[] buffer = new byte[2048];
            String[] messages = {"salam", "chetori?", "che-khabar?"};
            for (String msg: messages) {
                out.write(msg.getBytes());
                System.out.println("SENT: " + msg);
                int read = in.read(buffer);
                System.out.println("RECV: " + new String(buffer, 0, read));
            }
            System.out.print("All messages sent.\nClosing ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}
