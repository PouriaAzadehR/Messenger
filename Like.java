package com.company;

/**
 * this is a class for likes
 * it contains only liker
 * @author pouri
 * @version 1
 * @since today
 */
public class Like {

    //user who likes the twit
    UserAccount liker;

    /**
     * this is a constructor
     * @param liker of post
     */
    public Like(UserAccount liker){
        this.liker=liker;
    }

    @Override
    public String toString() {
        return "Like{" +
                "liker=" + liker.toString() +
                "}\n";
    }
}
