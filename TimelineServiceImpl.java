package com.company;

import java.util.ArrayList;
import services.TimeLineService;
import java.util.Collections;

/**
 * this is a class for showing twits likes retwits and reply of its following users
 * @author pouria
 * @version 1
 * @since today
 */
public class TimelineServiceImpl implements TimeLineService{

    /**
     * this is a method for showing twit of its followings
     * @param me person request
     * @return list of its following twits null for having no twits
     */
    public String twitsFollowing(UserAccount me){
        if (me.getFollowing().size()==0) {
            return "you have no following\n";
        }
        ArrayList<Twit> result=new ArrayList<>();
        for (UserAccount following:me.getFollowing())
            result.addAll(following.getTwits());
        if (result.size()==0) {
            return "your following users have no twits\n";
        }
        Collections.sort(result);
        String stringRes="";
        for (Twit twit:result) {
            stringRes+=twit.toString();
        }
        return stringRes;
    }

    /**
     * this is a method for returning all likes of a user
     * @param me
     * @return list of like of a user or return null for empy like
     */
    public String twitLike(UserAccount me){
        ArrayList<Like> result=new ArrayList<>();
        for (UserAccount following:me.getFollowing())
            for (Twit twit:following.getTwits())
                result.addAll(twit.getListLikes());
        if (result.size()==0)
            return "you have no like\n";
        String stringRes="";
        for (Like like:result) {
            stringRes+=like.toString();
        }
        return stringRes;
    }

    /**
     * this is a method for returning retweeted of followings
     * @param me who request
     * @return list of retweeted null if it was empty
     */
    public String retweetedTwits(UserAccount me){
        ArrayList<Twit> result=new ArrayList<>();
        for (UserAccount following:me.getFollowing())
            for (Twit twit:following.getTwits())
                if (twit instanceof retweetedTwit)
                    result.add(twit);
        if (result.size()==0)
            return "your followings have no retweets\n";
        String stringRes="";
        for (Twit twit:result) {
            stringRes+=twit.toString();
        }
        return stringRes;
    }

    /**
     * this is a method for returning replyTwits of following
     * @param me user request
     * @return replyTwits of following
     */
    public String replyTwits(UserAccount me){
        ArrayList<Twit> result=new ArrayList<>();
        for (UserAccount following:me.getFollowing())
            for (Twit twit:following.getTwits())
                result.addAll(twit.getDirectReplyTwit());
        if (result.size()==0)
            return "your followings have no reply\n";
        Collections.sort(result);
        String stringRes="";
        for (Twit twit:result) {
            stringRes+=twit.toString();
        }
        return stringRes;    }
}
