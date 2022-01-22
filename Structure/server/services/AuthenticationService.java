package com.company.ap.server.services;

import com.company.ap.server.UserAccount;

/**
 * this is an interface for authentication service
 * @author pouria
 * @version 1
 * @since today
 */
public interface AuthenticationService {

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


