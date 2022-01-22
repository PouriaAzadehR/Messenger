package com.company.ap.server;
import com.company.ap.server.services.ObserverService;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * this is a class which is for following , unfollowing and see twits of all of his following users
 * @author pouri
 * @version 1
 * @since today
 */
public class ObserverServiceImpl implements ObserverService , Serializable {

    /**
     * this is a method for following others
     * @param me who wants to follow
     * @param you whom is followed
     */
    public void follow(com.company.ap.server.UserAccount me, com.company.ap.server.UserAccount you){
        if (you.getFollower().contains(me))
            System.out.println("you have already follow this user");
        else {
            me.getFollowing().add(you);
            you.getFollower().add(me);
        }
    }

    /**
     * this is a method for removing followers
     * @param me want remove follower
     * @param you whom wants to removed
     */
    public void unfollow(com.company.ap.server.UserAccount me, com.company.ap.server.UserAccount you){
        if (!you.getFollower().contains(me))
            System.out.println("you have not already follow this user");
        else {
            you.getFollower().remove(me);
            me.getFollowing().remove(you);
        }
    }

    /**
     * this is a method for returning twits of its following
     * @param me
     * @return list of twits of its followings null for having no twits
     */
    public String twitFollowing(com.company.ap.server.UserAccount me){
        if (me.getFollowing().size()==0) {
            return "you have no followings\n";
        }
        ArrayList<Twit> result=new ArrayList<>();
        for (UserAccount following:me.getFollowing())
            result.addAll(following.getTwits());
        if (result.size()==0) {
            return "your followings have no twits\n";
        }
        String stringRes="";
        for (Twit twit:result) {
            stringRes+=twit.toString();
        }
        return stringRes;
    }
}
