package BLL.Model;

import java.util.List;

public class Candidate {
    private static int AUTO_ID = 0;
    private int id;
    private String name;
    private String description;
    private String image;
    private List<Vote> votes;

    public Candidate(String name, String description, String image, List<Vote> votes){
        this.id = AUTO_ID;
        this.name = name;
        this.description = description;
        this.image = image;
        this.votes = votes;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", votes=" + votes +
                '}';
    }
}
