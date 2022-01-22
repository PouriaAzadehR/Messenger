package com.company.ap.client;

import com.company.ap.server.UserAccount;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * this class is like the manger of client and is responsible for communicating with server
 * @author pouri
 * @version 1
 * @since today
 */
public class CommandParser {

    static String[] charReq;


    //client outputStream
    private ObjectOutputStream out;

    //client inputStream
    private ObjectInputStream in;

    private ConsoleviewServiceImpl consoleviewService;

    /**
     * this is a constructor
     *
     * @param out outStream of client
     * @param in  inputStream of client
     */
    public CommandParser(OutputStream out, InputStream in) {
        try {
            this.in = new ObjectInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.out = new ObjectOutputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        charReq = new String[12];
        consoleviewService = new ConsoleviewServiceImpl();
    }

    public void SendToServer(Object req) {
        ArrayList<String> toServer = new ArrayList<>();
        Collections.addAll(toServer, charReq);
        try {
            out.writeObject(toServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this is a method for reading form server
     *
     * @return response of server
     */
    public String readFromServer() {
        ArrayList<String> response = null;
        try {
            response = (ArrayList) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (response.size()>0)
            return response.get(0);
        else return null;
    }

    /**
     * this is a method for reading form server
     *
     * @return response of server
     */
    public String readFromServer2() {
        ArrayList<String> response = null;
        try {
            response = (ArrayList) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return response.get(1);
    }


    public void stop() {
        String stop = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            stop = scanner.nextLine();
            if (stop != null)
                break;
        }
    }

    public void signUpReq() {
        consoleviewService.signupReq();
        Scanner scanner = new Scanner(System.in);
        String console = scanner.nextLine();
        String[] arr = console.split(" ");
        consoleviewService.bio();
        console=scanner.nextLine();
        charReq[0] = "1";
        charReq[1] = arr[0];
        charReq[2] = arr[1];
        charReq[3] = arr[2];
        charReq[4]=console;
        charReq[5] = arr[3];
        SendToServer(charReq);
        System.out.println(readFromServer());
    }

    public void signInReq() {
        while (true) {
            consoleviewService.singInReq();
            Scanner scanner = new Scanner(System.in);
            String console = scanner.nextLine();
            charReq[0] = "0";
            charReq[1] = "";
            charReq[2] = "";
            String[] arr = console.split(" ");
            charReq[3] = arr[0];
            charReq[4] = "";
            charReq[5] = arr[1];
            SendToServer(charReq);
            String response = readFromServer();
            System.out.println(response);
            if (response.charAt(0) != 'u')
                break;
        }
    }

    public void signInSignUp() {
        Scanner scanner = new Scanner(System.in);
        consoleviewService.connection();
        consoleviewService.signInOrSingOut();
        String console = scanner.nextLine();
        if (console.equals("yes"))
            signInReq();
        else
            signUpReq();


    }

    public void choose() {
        Scanner scanner = new Scanner(System.in);
        String console;
        consoleviewService.menu();
        while (true) {
            console = scanner.nextLine();
            if (isNumeric(console))
                break;
            consoleviewService.invalid();
        }
        int intInput = Integer.parseInt(console);
        switch (intInput) {
            case 1 -> {
                consoleviewService.choose1();
                console = scanner.nextLine();
                charReq[6] = console;
                charReq[0] = "2";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 2 -> {
                consoleviewService.choose2();
                console = scanner.nextLine();
                charReq[7] = console;
                charReq[0] = "3";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 3 -> {
                consoleviewService.choose3();
                console = scanner.nextLine();
                charReq[7] = console;
                charReq[0] = "4";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 4 -> {
                consoleviewService.choose4();
                console = scanner.nextLine();
                charReq[7] = console;
                charReq[0] = "5";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 5 -> {
                consoleviewService.choose5();
                console = scanner.nextLine();
                String[] arr = console.split(" ");
                charReq[7] = arr[0];
                charReq[8] = arr[1];
                charReq[0] = "6";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 6 -> {
                consoleviewService.choose6();
                console = scanner.nextLine();
                charReq[9] = console;
                charReq[0] = "7";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 7 -> {
                consoleviewService.choose7();
                console = scanner.nextLine();
                charReq[9] = console;
                charReq[0] = "8";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 8 -> {
                consoleviewService.choose8();
                charReq[0] = "9";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 9 -> {
                consoleviewService.choose9();
                charReq[0] = "10";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 10 -> {
                consoleviewService.choose10();
                charReq[0] = "11";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 11 -> {
                consoleviewService.choose11();
                charReq[0] = "12";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            case 12 -> {
                consoleviewService.choose12();
                console=scanner.nextLine();
                charReq[7]=console;
                charReq[0] = "13";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }

            case 13 -> {
                charReq[0] = "15";
                String server = "null";
                SendToServer(charReq);
                String response = readFromServer();
                System.out.println(response);
                int check = 0;
                while (true) {
                    while (check>0) {
                            server = readFromServer();
                            if (server != null) {
                                System.out.println(server);
                                break;
                            }
                            charReq[0]="14";
                            SendToServer(charReq);
                    }
                    check++;
                    String[] lines = response.split("\n");
                    console = scanner.nextLine();
                    if (console.equals("out"))
                        break;
                    charReq[10] = charReq[3] + "--->" + console;
                    charReq[11] = lines[lines.length - 1];
                    charReq[0] = "16";
                    SendToServer(charReq);
                }
            }

            case 14 ->{
                charReq[0]="17";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }

            case 15 ->{
                charReq[0]="18";
                SendToServer(charReq);
                System.out.println(readFromServer());
            }
            default -> consoleviewService.invalid();
        }

        // TODO: 12/27/2021 write a method for each req and fill it properly(for sign in fill with empty strings
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
