package BLL.Model;

import java.util.Date;

public class Post {
    private static int AUTO_ID = 0;
    private int id;
    private Date date;
    private String message;
    private Forum forum;

    public Post(Date date, String msg){
        this.id = AUTO_ID;
        this.date = date;
        this.message = msg;
        AUTO_ID++;
    }
}
