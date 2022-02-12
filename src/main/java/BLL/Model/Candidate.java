package BLL.Model;

import java.util.Date;

public class Candidate {
    private static int AUTO_ID = 0;
    private int id;
    private String name;
    private String description;
    private String image;

    public Candidate(String name, String description, String image){
        this.id = AUTO_ID;
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
