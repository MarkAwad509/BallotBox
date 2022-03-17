package BLL.Model;

import java.time.LocalDate;

public class Forum{
    private static int AUTO_ID = 0;
    private int id;
    private String title;
    private LocalDate createdOn;

    public Forum(String title, LocalDate createdOn) {
        this.id = AUTO_ID;
        this.title = title;
        this.createdOn = createdOn;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
