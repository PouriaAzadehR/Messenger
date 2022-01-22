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
public class Twit implements Comparable<Twit> {

    //count of twit
    static int count=0;

    //num of twit
    public int num=0;

    private int retweet=0;

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
        num=count;
        count++;
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

    /**
     * this is a method for getting number of twit
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * this is a getter method
     * @return num of retweets
     */
    public int getRetweet() {
        return retweet;
    }

    /**
     * this is a method which increment num of retweets
     */
    public void plus(){
        retweet++;
    }
    public String stringListLike(){
        String res ="";
        for (Like like:likes) {
            res+=like.liker+"----";
        }
        return res;
    }

    @Override
    public String toString() {
        return "Twit{" +
                "\nnum=" + num +
                "\nsender=" + sender +
                "\nlikes[" +stringListLike() +"]"+
                "\nretweet[" +getRetweet() +"]"+
                "\ncontents='" + contents +
                "\npublishTime=" + publishTime +
                "\n}";
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Twit o) {
        return getPublishTime().compareTo(o.getPublishTime());
    }
}
