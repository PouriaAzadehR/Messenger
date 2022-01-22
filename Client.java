package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this is a class for client which want to connect to server
 * @author pouri
 * @version 1
 * @since today
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        ConsoleviewServiceImpl consoleviewService=new ConsoleviewServiceImpl();
        try (Socket client = new Socket("127.0.0.1", 7660)) {
            CommandParser commandParser =new CommandParser(client.getOutputStream(),client.getInputStream());
            //signIn sign up
           commandParser.signInSignUp();
           commandParser.stop();
            while (true){
               commandParser.choose();
               commandParser.stop();
            }
            //consoleviewService.done();
        }
    }
}
