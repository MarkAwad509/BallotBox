package BLL.Model;

import java.util.Date;

public class Forum{
    private static int AUTO_ID = 0;
    private int id;
    private String title;
    private Date createdOn;

    public Forum(String title, Date createdOn) {
        this.id = AUTO_ID;
        this.title = title;
        this.createdOn = createdOn;
        AUTO_ID++;
    }
}
