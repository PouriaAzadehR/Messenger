package com.company;

import java.io.*;
import java.util.ArrayList;

/**
 * this class is like the manger of client and is responsible for communicating with server
 * @author pouri
 * @version 1
 * @since today
 */
public class CommandParser {

    //client outputStream
    private ObjectOutputStream out;

    //client inputStream
    private ObjectInputStream in;

    /**
     * this is a constructor
     * @param out outStream of client
     * @param in inputStream of client
     */
    public CommandParser(OutputStream out,InputStream in){
        try {
            this.in=new ObjectInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.out=new ObjectOutputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendToServer(Object req){
        try {
            out.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList readFromServer(){
        ArrayList<String> response = null;
        try {
            response = (ArrayList) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return response;
    }
}
