package com.company;

/**
 * this is an interface for authentication service
 * @author pouri
 * @version 1
 * @since today
 */
public interface AuthenticationServiceIn {

    /**
     * this is a method for signing in
     * @param userAccount who attemp
     * @return res
     */
     boolean signIn(UserAccount userAccount);

    /**
     * this is a method for signing up
     * @param newUser who attemp
     * @return res
     */
     boolean signUp(UserAccount newUser);

}


