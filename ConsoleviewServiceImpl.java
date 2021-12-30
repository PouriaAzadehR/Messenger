package com.company;

/**
 * this is a class for sout in console
 * @author pouria
 * @version 1
 * @since today
 */
public class ConsoleviewServiceImpl implements ConsoleViewService {

    /**
     * this is a method for cleaning console
     */
    public void clean(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * this is a method for border
     */
    public void upperBorder(){
        System.out.println();
        System.out.println();
        System.out.println("*********************************************************************************");
    }

    /**
     * this is a method for downer border
     */
    public void downerBorder(){
        System.out.println("*********************************************************************************");
        System.out.println();
        System.out.println();
    }

    /**
     * this is a method for showing connection status
     */
    public void connection(){
        System.out.println("Connected to server.\n");
    }

    /**
     * this is a method for showing done
     */
    public void done(){
        System.out.println("done.");
    }

    /**
     * this is method which ask user whether you want to sing in or sign up
     */
    public void signInOrSingOut(){
        System.out.println("have you already had account?\n");
    }

    /**
     * this is a method for menu
     */
    public void menu(){
        upperBorder();
        System.out.println("MENU\n");
        System.out.println("1-add Twit\n");
        System.out.println("2-remove twit\n");
        System.out.println("3-retweet a twit\n");
        System.out.println("4-like a twit\n");
        System.out.println("5-reply to a twit\n");
        System.out.println("6-follow\n");
        System.out.println("7-unfollow\n");
        System.out.println("8-all twits of following\n");
        System.out.println("9-all twits of following based on time\n");
        System.out.println("10-likes\n");
        System.out.println("11-retweet twits\n");
        System.out.println("12-reply twits\n");
        System.out.println("13-chatroom\n");
        downerBorder();
    }

}
