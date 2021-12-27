package com.company;

/**
 * this is a class for sout in console
 * @author pouria
 * @version 1
 * @since today
 */
public class ConsoleviewService {

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
    public void border(){
        System.out.println();
        System.out.println();
        System.out.println("*********************************************************************************");
    }

    public void connection(){
        System.out.println("Connected to server.\n");
    }


    public void done(){
        System.out.println("done.");
    }

    public void signInOrSingOut(){
        System.out.println("have you already had account?\n");
    }

}
