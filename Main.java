package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String tweet;
        Scanner scanner =new Scanner(System.in);
        while (true){
            tweet=scanner.nextLine();
            if (tweet.length()>256)
                continue;
            else
                break;
        }
        System.out.println(tweet);
    }
}
