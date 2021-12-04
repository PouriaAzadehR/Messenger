package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * this is a class for twits which are posted by users
 *
 * @author pouri
 * @version 1
 * @since today
 */
public class Twit {

    //sender of twit
    private UserAccount sender;

    //likes of twit
    private ArrayList<Like> likes;

    //contents of twit
    private String contents;

    //publish time of twit
    private LocalDateTime publishTime;

    private ArrayList<Twit> directReplyTwit;

    /**
     * this is a constructor
     * @param sender of twit
     * @param contents of twit
     */
    public Twit(UserAccount sender,String contents ){
        this.sender=sender;
        likes=new ArrayList<>();
        publishTime=LocalDateTime.now();
        directReplyTwit=new ArrayList<>();
        while (true){
            this.contents=contents;
            if (contents.length()<256 && contents.trim().length()>0)
                break;
            else
                System.out.println("your twit length must at least be 256 and the least 1");
        }
    }

    /**
     * this is a getter method
     * @return likes of a twit
     */
    public ArrayList<Like> getListLikes() {
        return likes;
    }

    /**
     * this is a getter method
     * @return num of likes
     */
    public int getNumLikes(){
        return getListLikes().size();
    }

    /**
     * this is a getter method
     * @return publish time of twit
     */
    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    /**
     * this is a getter method
     * @return content of twit
     */
    public String getContents() {
        return contents;
    }

    /**
     * this is a getter method
     * @return sender of twit
     */
    public UserAccount getSender() {
        return sender;
    }

    /**
     * this is a getter method
     * @return twits which are reply in this twit
     */
    public ArrayList<Twit> getDirectReplyTwit() {
        return directReplyTwit;
    }
}
