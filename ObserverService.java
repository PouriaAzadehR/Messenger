package com.company;

/**
 * this is a class which is for following , unfollowing and see twits of all of his following users
 * @author pouri
 * @version 1
 * @since today
 */
public interface ObserverService {

    /**
     * this is a method for following others
     * @param me who wants to follow
     * @param you whom is followed
     */
     void follow(UserAccount me,UserAccount you);

    /**
     * this is a method for removing followers
     * @param me want remove follower
     * @param you whom wants to removed
     */
     void unfollow(UserAccount me,UserAccount you);

    /**
     * this is a method for returning twits of its following
     * @param me
     * @return list of twits of its followings null for having no twits
     */
     String twitFollowing(UserAccount me);
}
