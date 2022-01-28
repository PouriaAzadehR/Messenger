package com.example.client;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Client_server {
    public static String[] charReq;

    //client outputStream
    private static ObjectOutputStream outt;

    //client inputStream
    private static ObjectInputStream inn;

    public static void  Client_server_connection(OutputStream out, InputStream in) {
        try {
            inn = new ObjectInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outt = new ObjectOutputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        charReq = new String[12];
    }

    public static void SendToServer(Object req) {
        ArrayList<String> toServer = new ArrayList<>();
        Collections.addAll(toServer, charReq);
        try {
            outt.writeObject(toServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromServer() {
        ArrayList<String> response = null;
        try {
            response = (ArrayList) inn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (response.size()>0)
            return response.get(0);
        else return null;
    }

}
