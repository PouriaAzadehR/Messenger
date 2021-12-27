package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this is a class for server
 * it can only handle three client
 * @author pouri
 * @version 1
 * @since today
 */
public class Server {

     static AuthenticationService authenticationService=new AuthenticationService();

     static TweetingService tweetingService=new TweetingService();

     static ObserverService observerService=new ObserverService();

     static TimelineService timelineService=new TimelineService();




    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        try (ServerSocket welcomingSocket = new ServerSocket(7660)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            for (int i = 0; i < 5; i++) {
                Socket connectionSocket = welcomingSocket.accept();
                System.out.println("client accepted!");
                pool.execute(new ClientHandler(connectionSocket));
            }
            pool.shutdown();
            System.out.print("done.\nClosing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }

    /**
     * this is a getter method
     * @return authentication service
     */
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    /**
     * this is a getter method
     * @return observer service
     */
    public ObserverService getObserverService() {
        return observerService;
    }

    /**
     * this is a getter method
     * @return timeline service
     */
    public TimelineService getTimelineService() {
        return timelineService;
    }

    /**
     * this is a getter method
     * @return tweeting service
     */
    public TweetingService getTweetingService() {
        return tweetingService;
    }
}

/**
 * this is a class for handling multithreading
 * @author pouri
 * @version 1
 * @since today
 */
class ClientHandler implements Runnable {

    private Socket connectionSocket;

    public ClientHandler(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {
        try {

            ObjectOutputStream out = new ObjectOutputStream(connectionSocket.getOutputStream());
            ObjectInputStream in =new ObjectInputStream(connectionSocket.getInputStream());
            //Thread.sleep(2000);
            ArrayList<String> arrayListReq=readFromClient(in);
            int reqMethod= Integer.parseInt(arrayListReq.get(0));
            ArrayList<String> respond=new ArrayList<>();
            switch (reqMethod){
                case 1:{
                }
                case 2:
            }
            System.out.print("All messages sent..\nClosing client ... ");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                connectionSocket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    /**
     * this is a method for sending respond to client
     * @param respond of server
     * @param out of server
     */
    public void SendToClient(Object respond,ObjectOutputStream out){
        try {
            out.writeObject(respond);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this is a method for reading resopnse
     * @param in inputStream of serverr
     * @return object req
     */
    public ArrayList readFromClient(ObjectInputStream in){
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

    /**
     * this is a method for creating new users with clients info
     * @param req is sent by client
     * @return a user account
     */
    public UserAccount createUserAccount(ArrayList<String> req){
        UserAccount newUser=new UserAccount(req.get(1),req.get(2),req.get(3),req.get(4),req.get(5));
        return newUser;
    }

}
