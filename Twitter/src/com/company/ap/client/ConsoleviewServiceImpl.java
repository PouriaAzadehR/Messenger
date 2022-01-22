package com.company.ap.client;

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
        System.out.println("14-my twits\n");
        System.out.println("15-my account\n");
        downerBorder();
    }

    /**
     * this is a method for showing bio
     */
    public void bio() {System.out.println("enter your bio\n");}

    /**
     * this is a method for showing sign up req
     */
    public void signupReq(){
        System.out.println("so you are new to tweeter\nfirst of all you should sign up\n");
        System.out.println("pleas enter following info in below format just in one line(split info with space)\n");
        System.out.println("firstName lastName userName password\n");
    }

    /**
     * this is a method for showing sign in req
     */
    public void singInReq(){
        System.out.println("please enter your userName and password in below format\n");
        System.out.println("userName password\n");
    }

    /**
     * this is a method for showing invalidity
     */
    public void invalid(){
        System.out.println("invalid input\n");
    }

    /**
     * this is a method for choose 1
     */
    public void choose1(){System.out.println("please enter content of your twit it must be at last 256 character\n");}

    /**
     * this is a method for choose 2
     */
    public void choose2(){System.out.println("please enter the number of twit which you want to delete\n");}

    /**
     * this is a method for choose 3
     */
    public void choose3() {System.out.println("please enter the number of twit you want to retweet\n");}

    /**
     * this is a method for choose 4
     */
    public void choose4(){System.out.println("please enter the number of twit which you want to like\n");}

    /**
     * this is a method for choose 5
     */
    public void choose5(){System.out.println("please enter two number for twits one for the twit which you want to reply and one for the twit that will be replied\n");}

    /**
     * this is a method for choose 6
     */
    public void choose6(){System.out.println("pleas enter the userName of the person you want to follow\n");}
    /**
     * this is a method for choose 7
     */
    public void choose7(){System.out.println("please enter the user name of the person you want to unfollow\n");}
    /**
     * this is a method for choose 8
     */
    public void choose8(){System.out.println("this is list of twits of users which you have already followed\n");}
    /**
     * this is a method for choose 9
     */
    public void choose9(){System.out.println("this is sort list of twits of users which you have already followed\n");}
    /**
     * this is a method for choose 10
     */
    public void choose10(){System.out.println("this is list of your likes\n");}
    /**
     * this is a method for choose 11
     */
    public void choose11(){System.out.println("this is the list of retwits of your followings\n");}
    /**
     * this is a method for choose 12
     */
    public void choose12(){System.out.println("enter the number of the twit which you want to see its replies\n");
    }
    }
