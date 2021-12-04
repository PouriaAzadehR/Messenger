package com.company;

import java.util.ArrayList;

/**
 * this is a class for creating twit or removing one of them or retweeting or like
 * it contains list of all twits
 * @author pouri
 * @version 1
 * @since today
 */
public class TweetingService {

    //list of all twits
    ArrayList<Twit> twits;

    /**
     * this is a constructor
     */
    public TweetingService(){
        twits=new ArrayList<>();
    }

    /**
     * this is a like method for liking twits
     * @param likedTwit which is liked
     * @param userAccount who likes
     */
    public void like(Twit likedTwit,UserAccount userAccount){
        likedTwit.getListLikes().add(new Like(userAccount));
    }

    /**
     * this is a method for retweeting
     * @param twit which retweeted
     * @param retweeterer who retweets
     */
    public void retweet(Twit twit,UserAccount retweeterer){
        twits.add(new retweetedTwit(twit,retweeterer));
    }

    /**
     * this is a method for removing twits
     * @param removedTwit which should be removed
     */
    public void removeTwit(Twit removedTwit){
        twits.remove(removedTwit);
    }

    /**
     * this is a method for adding new twits
     * @param newTwit which want to be added
     */
    public void addTwit(Twit newTwit){
        twits.add(newTwit);
    }

    /**
     * this is a method for replying to a twit
     * @param twit main twit
     * @param replyTwit reply to main twit
     */
    public void reply(Twit twit ,Twit replyTwit){
        twit.getDirectReplyTwit().add(replyTwit);
    }


}
