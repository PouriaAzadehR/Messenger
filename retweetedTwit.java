package com.company;

/**
 * this is a class which is used for retweeting
 */
public class retweetedTwit extends Twit{

    //the person who retweets
    UserAccount retweetPerson;

    /**
     * this is a constructor
     * @param twit which is retweeted
     * @param retweetPerson who retweet
     */
    public retweetedTwit(Twit twit,UserAccount retweetPerson) {
        super(twit.getSender(), twit.getContents());
        this.retweetPerson=retweetPerson;
    }


    @Override
    public String toString() {
        return "retweetedTwit{" +
                "\nretweetPerson=" + retweetPerson +
                "\nnum=" + num +
                "\nsender=" + getSender() +
                "\nlikes[" +getNumLikes() +"]"+
                "\nretweet[" +getRetweet() +"]"+
                "\ncontents='" + getContents() +
                "\npublishTime=" + getPublishTime() +
                "}\n";
    }
}
