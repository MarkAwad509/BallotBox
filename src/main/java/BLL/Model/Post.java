package BLL.Model;

import java.time.LocalDate;

public class Post {
    private static int AUTO_ID = 0;
    private int id;
    private LocalDate date;
    private String message;
    private Forum forum;

    public Post(LocalDate date, String msg){
        this.id = AUTO_ID;
        this.date = date;
        this.message = msg;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", forum=" + forum +
                '}';
    }
}
