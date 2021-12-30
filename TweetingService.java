package com.company;

/**
 * this is a class for creating twit or removing one of them or retweeting or like
 * it contains list of all twits
 * @author pouri
 * @version 1
 * @since today
 */
public interface TweetingService {

    /**
     * this is a like method for liking twits
     * @param likedTwit which is liked
     * @param userAccount who likes
     */
     void like(Twit likedTwit,UserAccount userAccount);

    /**
     * this is a method for retweeting
     * @param twit which retweeted
     * @param retweeterer who retweets
     */
     void retweet(Twit twit,UserAccount retweeterer);

    /**
     * this is a method for removing twits
     * @param removedTwit which should be removed
     */
     void removeTwit(Twit removedTwit,UserAccount sender);

    /**
     * this is a method for adding new twits
     * @param newTwit which want to be added
     */
     void addTwit(Twit newTwit,UserAccount sender);

    /**
     * this is a method for replying to a twit
     * @param twit main twit
     * @param replyTwit reply to main twit
     */
     void reply(Twit twit ,Twit replyTwit,UserAccount sender);
}
