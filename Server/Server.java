package com.company.ap.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this is a class for server
 * it can only handle three client
 * @author pouri
 * @version 1
 * @since today
 */
public class Server implements Serializable {

     static AuthenticationServiceImpl authenticationService=new AuthenticationServiceImpl();

     static TweetingServiceImpl tweetingService=new TweetingServiceImpl();

     static ObserverServiceImpl observerService=new ObserverServiceImpl();

     static TimelineServiceImpl timelineService=new TimelineServiceImpl();

     static FilesServiceImpl filesService=new FilesServiceImpl();

     static File chat=filesService.createFile("chat.txt");

     static File log=filesService.createFile("files\\log.txt");






    public static void main(String[] args) {
        Server.filesService.writeFile("chat.txt","CHAT ROOM");
        Server.filesService.writeFile("log.txt","LOG FILE");
        ExecutorService pool = Executors.newCachedThreadPool();
        System.out.println("do you want to load the server?\n");
        Scanner scanner =new Scanner(System.in);
        String temp=scanner.nextLine();

        //loading server
        if (temp.equals("yes")) {
            FileInputStream fi = null;
            try {
                fi = new FileInputStream("server.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                ObjectInputStream oi = new ObjectInputStream(fi);
                try {
                     authenticationService = (AuthenticationServiceImpl) oi.readObject();
                     tweetingService = (TweetingServiceImpl) oi.readObject();
                     observerService = (ObserverServiceImpl) oi.readObject();
                     timelineService= (TimelineServiceImpl)  oi.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("server is loaded\n");
        }

        try (ServerSocket welcomingSocket = new ServerSocket(7660)) {
            System.out.print("Server started.\nWaiting for a client ...\n");
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

}

/**
 * this is a class for handling multithreading
 * @author pouri
 * @version 1
 * @since today
 */
class ClientHandler implements Runnable ,Serializable {

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
            while (true) {
                ArrayList<String> respond = new ArrayList<>();
                ArrayList<String> arrayListReq = readFromClient(in);
                while (arrayListReq==null)
                    arrayListReq=readFromClient(in);
                int reqMethod = Integer.parseInt(arrayListReq.get(0));
                synchronized (this) {
                    switch (reqMethod) {
                        case 0 -> {
                            LogWriter("sign in attemp\n", arrayListReq.get(3));
                                if (Server.authenticationService.signIn(createUserAccount(arrayListReq))) {
                                    String respond0 = "signed in successfully\n";
                                    LogWriter("signed in successfully\n", "SERVER");
                                    respond.add(respond0);
                                }

                                else {
                                    String respond0 = "username or password is wrong\n";
                                    LogWriter("username or password is wrong\n", "SERVER");
                                    respond.add(respond0);
                                }
                        }
                        case 1 -> {
                            LogWriter("sign up attemp\n", arrayListReq.get(3));
                            String respond1;
                            if (Server.authenticationService.signUp(createUserAccount(arrayListReq))) {
                                respond1 = "client is signed up\n";
                            } else {
                                respond1 = "this username has already been taken\n";
                            }
                            LogWriter(respond1, "SERVER");
                            respond.add(respond1);
                        }
                        case 2 -> {
                            LogWriter("adding twit\n", arrayListReq.get(3));
                            Server.tweetingService.addTwit(createTweet(arrayListReq), findMyUserAccount(arrayListReq));
                            String respond2 = "twit is added successfully\n";
                            LogWriter(respond2, "SERVER");
                            respond.add(respond2);
                        }
                        case 3 -> {
                            LogWriter("removing twit\n", arrayListReq.get(3));
                            Server.tweetingService.removeTwit(findTwit(arrayListReq), findMyUserAccount(arrayListReq));
                            String respond3 = "twit is deleted successfully\n";
                            LogWriter(respond3, "SERVER");
                            respond.add(respond3);
                        }
                        case 4 -> {
                            LogWriter("retweeting\n", arrayListReq.get(3));
                            Server.tweetingService.retweet(findTwit(arrayListReq), findMyUserAccount(arrayListReq));
                            String respond4 = "retweeted successfully\n";
                            LogWriter(respond4, "SERVER");
                            respond.add(respond4);
                        }
                        case 5 -> {
                            LogWriter("liking\n", arrayListReq.get(3));
                            Server.tweetingService.like(findTwit(arrayListReq), findMyUserAccount(arrayListReq));
                            String respond5 = "liked successfully\n";
                            LogWriter(respond5, "SERVER");
                            respond.add(respond5);
                        }
                        case 6 -> {
                            LogWriter("replying\n", arrayListReq.get(3));
                            Server.tweetingService.reply(findTwit(arrayListReq), findReplyTwit(arrayListReq), findMyUserAccount(arrayListReq));
                            String respond6 = "replied successfully\n";
                            LogWriter(respond6, "SERVER");
                            respond.add(respond6);
                        }
                        case 7 -> {
                            LogWriter("following\n", arrayListReq.get(3));
                            Server.observerService.follow(findMyUserAccount(arrayListReq), findOtherUserAccount(arrayListReq));
                            String respond7 = "follow successfully\n";
                            LogWriter(respond7, "SERVER");
                            respond.add(respond7);
                        }
                        case 8 -> {
                            LogWriter("unfollowing\n", arrayListReq.get(3));
                            Server.observerService.unfollow(findMyUserAccount(arrayListReq), findOtherUserAccount(arrayListReq));
                            String respond8 = "unfollow successfully\n";
                            LogWriter(respond8, "SERVER");
                            respond.add(respond8);
                        }
                        case 9 -> {
                            LogWriter("getting twits of its following\n", arrayListReq.get(3));
                            respond.add(Server.observerService.twitFollowing(findMyUserAccount(arrayListReq)));
                            LogWriter("returned succesfully\n", "SERVER");
                        }
                        case 10 -> {
                            LogWriter("getting twits of its following\n", arrayListReq.get(3));
                            respond.add(Server.timelineService.twitsFollowing(findMyUserAccount(arrayListReq)));
                            LogWriter("returned succesfully\n", "SERVER");
                        }
                        case 11 -> {
                            LogWriter("returning likes\n", arrayListReq.get(3));
                            respond.add(Server.timelineService.twitLike(findMyUserAccount(arrayListReq)));
                            LogWriter("returned succesfully\n", "SERVER");
                        }
                        case 12 -> {
                            LogWriter("returning retweets\n", arrayListReq.get(3));
                            respond.add(Server.timelineService.retweetedTwits(findMyUserAccount(arrayListReq)));
                            LogWriter("returned succesfully\n", "SERVER");

                        }
                        case 13 -> {
                            LogWriter("returning replies\n", arrayListReq.get(3));
                            respond.add(Server.timelineService.replyTwits(findMyUserAccount(arrayListReq),findTwit(arrayListReq)));
                            LogWriter("returned succesfully\n", "SERVER");
                        }
                        case 14 -> {
                            if (!arrayListReq.get(10).equals(Server.filesService.readLastLine("chat.txt")))
                                respond.add(Server.filesService.readLastLine("chat.txt"));
                            else
                                respond.add(null);
                        }
                        case 15 -> {
                            respond.add(Server.filesService.readFile("chat.txt"));
                            System.out.println(Server.filesService.readFile("chat.txt"));
                        }
                        case 16 -> Server.filesService.writeFile("chat.txt", arrayListReq.get(10));

                        case 17 ->{
                            LogWriter("returning twit of users\n", arrayListReq.get(3));
                            UserAccount userAccount = findMyUserAccount(arrayListReq);
                            respond.add(userAccount.stringTwits());
                            LogWriter("returned succesfully\n", "SERVER");
                        }

                        case 18 ->{
                            LogWriter("returning data of users\n", arrayListReq.get(3));
                            UserAccount userAccount=findMyUserAccount(arrayListReq);
                            String res="first name =" + userAccount.getFirstName() +"\nlast name ="+userAccount.getLastName()+"\nuserName ="+userAccount.getUserName()+"\nbio ="+userAccount.getBio()+"\npassword ="+arrayListReq.get(5)+"\n"+userAccount.stringTwits();
                            respond.add(res);
                            LogWriter("returned succesfully\n", "SERVER");
                        }
                    }
                    Server.filesService.writeObjectServer(Server.authenticationService,Server.tweetingService,Server.observerService,Server.timelineService);
                    SendToClient(respond, out);
                }
            }
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
    public void SendToClient(ArrayList<String> respond,ObjectOutputStream out){
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
    public ArrayList<String> readFromClient(ObjectInputStream in){
        ArrayList<String> response = null;
        try {
            response = (ArrayList<String>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return response;
    }

    /**
     * this is a method for creating new users with clients info
     * @param req is sent by client
     * @return a user account
     */
    public UserAccount createUserAccount(ArrayList<String> req){
        return new UserAccount(req.get(1),req.get(2),req.get(3),req.get(4),req.get(5));
    }

    /**
     * this is a method for finding user account which clients want
     * @param req of client
     * @return userAccount
     */
    public UserAccount findMyUserAccount(ArrayList<String> req){
        for (UserAccount userAccount:Server.authenticationService.userAccounts) {
            if (req.get(3).equals(userAccount.getUserName()))
                return userAccount;
        }
        return null;
    }


    /**
     * this is a method for finding user account which clients want
     * @param req of client
     * @return userAccount
     */
    public UserAccount findOtherUserAccount(ArrayList<String> req){
        for (UserAccount userAccount:Server.authenticationService.userAccounts) {
            if (req.get(9).equals(userAccount.getUserName()))
                return userAccount;
        }
        return null;
    }

    /**
     * this is a method for creating twit
     * @param req of client
     * @return twit
     */
    public Twit createTweet(ArrayList<String> req){
        return new Twit(createUserAccount(req),req.get(6));
    }

    /**
     * this is a method for finding the twit which clients requested
     * @param req of client
     * @return requested twit
     */
    public Twit findTwit(ArrayList<String> req){
        for (Twit twit:Server.tweetingService.twits) {
            if (twit.getNum()==Integer.parseInt(req.get(7)))
                return twit;
        }
        return null;
    }

    /**
     * this is a method for finding the reply twit which clients requested
     * @param req of client
     * @return requested twit
     */
    public Twit findReplyTwit(ArrayList<String> req){
        for (Twit twit:Server.tweetingService.twits) {
            if (twit.getNum()==Integer.parseInt(req.get(8)))
                return twit;
        }
        return null;
    }


    public void LogWriter(String content,String oparator){
        Server.filesService.writeFile("log.txt",oparator+"--->"+content);
    }

}
