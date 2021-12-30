package com.company;



/**
 * this is a class for showing twits likes retwits and reply of its following users
 * @author pouria
 * @version 1
 * @since today
 */
public interface TimeLineService {

    /**
     * this is a method for showing twit of its followings
     * @param me person request
     * @return list of its following twits null for having no twits
     */
     String twitsFollowing(UserAccount me);

    /**
     * this is a method for returning all likes of a user
     * @param me
     * @return list of like of a user or return null for empy like
     */
     String twitLike(UserAccount me);

    /**
     * this is a method for returning retweeted of followings
     * @param me who request
     * @return list of retweeted null if it was empty
     */
     String retweetedTwits(UserAccount me);

    /**
     * this is a method for returning replyTwits of following
     * @param me user request
     * @return replyTwits of following
     */
     String replyTwits(UserAccount me);



}
