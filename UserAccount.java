package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * this is a class which is used for each user in order to have access to tweeter app
 * it contains username biography and password
 * @author pouria
 * @version 1
 * @since 11/28/2021
 */
public class UserAccount {

    //first name of user
    private final String firstName;

    //last name of user
    private final String lastName;

    //username of user
    private final String userName;

    //some info about user
    private String bio;

    //hash password of user
    private final byte[] password;

    //list of followers
    private final ArrayList<UserAccount> follower;

    //list of following
    private final ArrayList<UserAccount> following;

    private ArrayList<Twit> twits;

    /**
     * this is a constructor
     * @param firstName of user
     * @param lastName of user
     * @param userName of user
     * @param bio of user
     * @param password of user
     */
    public UserAccount(String firstName,String lastName, String userName , String bio ,String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=hashPassword(password);
        follower=new ArrayList<>();
        following=new ArrayList<>();
        twits=new ArrayList<>();
        while (true){
            this.bio=bio;
            if (bio.length()<256)
                break;
            else
                System.out.println("your bio is too long");
        }
    }

    /**
     * this is a method for hashing password of user
     * @param input password
     * @return hash password
     */
    private byte[] hashPassword(String input){
        while (true) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                return md.digest(input.getBytes(StandardCharsets.UTF_8));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }



    }

    /**
     * this is a getter method
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * this is a getter method
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * this is a getter method
     * @return bio of user
     */
    public String getBio() {
        return bio;
    }

    /**
     * this is a getter method
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * this is a getter method
     * @return password
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * this is a getter method
     * @return list of followers
     */
    public ArrayList<UserAccount> getFollower() {
        return follower;
    }

    /**
     * this is a getter method
     * @return list of followings
     */
    public ArrayList<UserAccount> getFollowing() {
        return following;
    }

    /**
     * this is a getter method
     * @return twits of user
     */
    public ArrayList<Twit> getTwits() {
        return twits;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
