package com.company;

/**
 * this is a class which is used for retweeting
 */
public class retweetedTwit extends Twit{


    UserAccount retweetPerson;
    /**
     * this is a constructor
     *
     * @param sender   of twit
     * @param contents of twit
     */
    public retweetedTwit(UserAccount sender, String contents,UserAccount retweetPerson) {
        super(sender, contents);
        this.retweetPerson=retweetPerson;
    }
}
