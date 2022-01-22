package com.company.ap.server;

import com.company.ap.server.services.AuthenticationService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * this is a class which is used for sign in ,sign up
 * it contains list of users
 * @author pouri
 * @version 1
 * @since today
 */
public class AuthenticationServiceImpl implements Serializable , AuthenticationService  {

    //list of all users
    ArrayList<UserAccount> userAccounts;

    /**
     * this is a constructor
     */
    public AuthenticationServiceImpl(){
        userAccounts=new ArrayList<>();
    }

    /**
     * this is a method for sigin
     * @param newUser for registration
     * @return true if it sign up successfully
     */
    public boolean signUp(com.company.ap.server.UserAccount newUser){
        for (UserAccount check:userAccounts)
            if (check.getUserName().equals(newUser.getUserName()))
                return false;
        userAccounts.add(newUser);
        return true;
    }

    /**
     * this is a method for sign in twitter
     * @param userAccount which want to sign in
     * @return true if sign in true
     */
    public boolean signIn(com.company.ap.server.UserAccount userAccount){
        for (UserAccount check:userAccounts)
            if (check.getUserName().equals(userAccount.getUserName()) && Arrays.equals(check.getPassword(),userAccount.getPassword()))
                return true;
        return false;
    }

}
