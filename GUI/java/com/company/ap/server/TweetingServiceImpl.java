package com.company.ap.server;
import com.company.ap.server.services.TweetingService;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * this is a class for creating twit or removing one of them or retweeting or like
 * it contains list of all twits
 * @author pouri
 * @version 1
 * @since today
 */
public class TweetingServiceImpl implements TweetingService , Serializable {

    //list of all twits
    ArrayList<Twit> twits;

    /**
     * this is a constructor
     */
    public TweetingServiceImpl(){
        twits=new ArrayList<>();
    }

    /**
     * this is a like method for liking twits
     * @param likedTwit which is liked
     * @param userAccount who likes
     */
    public void like(com.company.ap.server.Twit likedTwit, com.company.ap.server.UserAccount userAccount){
        likedTwit.getListLikes().add(new Like(userAccount));
    }

    /**
     * this is a method for retweeting
     * @param twit which retweeted
     * @param retweeterer who retweets
     */
    public void retweet(com.company.ap.server.Twit twit, com.company.ap.server.UserAccount retweeterer){
        retweetedTwit retweetedTwit=new retweetedTwit(twit,retweeterer);
        twits.add(retweetedTwit);
        retweeterer.getTwits().add(retweetedTwit);
        twit.plus();
    }

    /**
     * this is a method for removing twits
     * @param removedTwit which should be removed
     */
    public void removeTwit(com.company.ap.server.Twit removedTwit, com.company.ap.server.UserAccount sender){
        twits.remove(removedTwit);
        sender.getTwits().add(removedTwit);

    }

    /**
     * this is a method for adding new twits
     * @param newTwit which want to be added
     */
    public void addTwit(com.company.ap.server.Twit newTwit, com.company.ap.server.UserAccount sender){
        //System.out.println(newTwit);
        twits.add(newTwit);
        sender.getTwits().add(newTwit);
        //System.out.println(twits.get(0));
    }

    /**
     * this is a method for replying to a twit
     * @param twit main twit
     * @param replyTwit reply to main twit
     */
    public void reply(com.company.ap.server.Twit twit , com.company.ap.server.Twit replyTwit, com.company.ap.server.UserAccount sender){
        twit.getDirectReplyTwit().add(replyTwit);
    }


}
